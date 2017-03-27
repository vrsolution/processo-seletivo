/**
 * 
 */
package br.com.vagner.processo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.vagner.processo.entity.Cep;
import br.com.vagner.processo.exception.InvalidCepException;
import br.com.vagner.processo.exception.InvalidCepExceptionResolver;
import br.com.vagner.processo.servico.CepService;


/**
 * @author Vagner 
 *
 */
@RestController
@RequestMapping("/cep")
@Api(value = "cep") //Diz ao Swagger que esse é um endpoint e REST deve ser documentado
public class CepController {
	
	@Autowired
	private CepService cepService;
	
	/**
	 * Pesquisa Cep passando string cep
	 * @param cep
	 * @return
	 * @throws InvalidCepException
	 */
	@RequestMapping(value="/{cep}", method=RequestMethod.GET,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiOperation(value="Pesquisar cep para trazer endereco")
	@ApiResponses(value = {
			@ApiResponse(code = 200, response=Cep.class ,message = "Consulta realizada com sucesso"),
			@ApiResponse(code = InvalidCepExceptionResolver.CODE_CEP_INVALIDO, message = "CEP inválido")
	})
    public @ResponseBody Cep pesquisarEndereco(
    		@ApiParam(value="CEP", required=true) 
    		@PathVariable("cep") String cep) throws InvalidCepException {
		
        return cepService.findByCep(cep);
    }



}
