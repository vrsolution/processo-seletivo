/**
 * 
 */
package br.com.vagner.processo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.vagner.processo.entity.Endereco;
import br.com.vagner.processo.exception.CepNotFoundException;
import br.com.vagner.processo.exception.EnderecoNotFoundException;
import br.com.vagner.processo.exception.InvalidCepException;
import br.com.vagner.processo.exception.InvalidCepExceptionResolver;
import br.com.vagner.processo.servico.EnderecoService;


/**
 * @author Vagner Rodrigues Souza
 *
 */
@RestController
@RequestMapping("/endereco")
@Api(value = "endereco") //Diz ao Swagger que esse é um endpoint e REST deve ser documentado
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoServico;
	
	
	/**
	 * Obtém o endereço do usuário através do Id.
	 * 
	 * @param id Id do endereço
	 * @return Endereço do usuário
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiOperation(value="consulta endereco pelo Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, response=Endereco.class ,message = "Operacao realizada com sucesso")
	})
	@Transactional(readOnly=true)
    public @ResponseBody Endereco consulta(
    		@ApiParam(value="Id do endereço", required=true) 
    		@PathVariable("id") Integer id) {

       return enderecoServico.pesquisar(id);
    }
	
/**
 * Remove o registro pelo id
 * @param id
 * @throws EnderecoNotFoundException
 */
	@RequestMapping(value="/endereco/{id}", method=RequestMethod.DELETE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiOperation(value="Remove o endereço através do Id informado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Endereço removido"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_ENDERECO_NOT_FOUND, message = "Endereço não encontrado")
	})
	@Transactional
    public @ResponseBody void remove(
    		@ApiParam(value="Id do endereço", required=true) 
    		@PathVariable("id") Integer id) throws EnderecoNotFoundException {

		enderecoServico.delete(id);;
    }
	
	/**
	 * Efetua o update sendo passado o id e o endereco que ira ser feito a alteracao
	 * @param id
	 * @param endereco
	 * @return
	 * @throws EnderecoNotFoundException
	 * @throws InvalidCepException
	 * @throws CepNotFoundException
	 */
	@RequestMapping(value="/endereco/{id}", method=RequestMethod.PUT,
	        produces = MediaType.APPLICATION_JSON_VALUE,
	        consumes = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiOperation(value="Altera o endereço informado", notes="O CEP informado deve ser válido e o id do endereço deve existir.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Endereço alterado com sucesso"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_ENDERECO_NOT_FOUND, message = "Endereço não encontrado"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_CEP_INVALIDO, message = "CEP inválido"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_CEP_NOT_FOUND, message = "CEP não encontrado"),
	})
	@Transactional
    public @ResponseBody Endereco altera(
    		@ApiParam(value="Id do endereço", required=true) 
    		@PathVariable("id") Integer id,
    		@RequestBody Endereco endereco) throws EnderecoNotFoundException,  InvalidCepException, CepNotFoundException {

		final Endereco enderecoUpdated = enderecoServico.update(id,endereco);
		return enderecoUpdated;
    }
	
	/**
	 * Efetua o insert sendo passado o endereco que sera feito 
	 * @param endereco
	 * @return
	 * @throws InvalidCepException
	 * @throws CepNotFoundException
	 */
	@RequestMapping(value="/endereco", method=RequestMethod.POST,
	        produces = MediaType.APPLICATION_JSON_VALUE,
	        consumes = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiOperation(value="Inseri o endereço", notes="O CEP deve ser válido.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Endereço incluído com sucesso"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_CEP_INVALIDO, message = "CEP inválido"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_CEP_NOT_FOUND, message = "CEP não encontrado"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_USUARIO_NOT_FOUND, message = "Usuário não encontrado"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_INTEGRATION_FAILED, message = "Falha de comunicação com o serviço de consulta de CEP")
	})
	@Transactional
    public @ResponseBody Endereco inclui( 
    		@RequestBody @Valid Endereco endereco) throws InvalidCepException, CepNotFoundException {

		final Endereco enderecoInserted = enderecoServico.insert(endereco);
		return enderecoInserted;
    }
	
}
