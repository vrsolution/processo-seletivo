/**
 * 
 */
package br.com.vagner.processo.servico;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vagner.processo.entity.Cep;
import br.com.vagner.processo.exception.InvalidCepException;
import br.com.vagner.processo.repository.CepRepository;
import br.com.vagner.processo.util.ValidationUtil;


/**
 * Implementacao Serviço com as funcionalidades relacionadas a consulta de CEP
 * @author Vagner Rodrigues Souza
 *
 */
@Service
public class CepServiceImpl implements CepService {
	
	private static final Logger log = LoggerFactory.getLogger(CepServiceImpl.class);

	@Autowired
	private CepRepository cepRepository;

	/**
	 * Pesquisa o Endereco pelo Cep
	 * @param cep
	 * @return Cep
	 * @throws InvalidCepException
	 */
	@Transactional(readOnly=true)
	@Override
	public Cep findByCep(String cep) throws InvalidCepException {
		
		log.debug("Inicio do findByCep: pesquisando o cep ", cep);
		if(!isCepValido(cep)){
			throw new InvalidCepException(cep);
		}
		String cepSemTraco = cep.replace("-", "");
		Cep retorno = cepRepository.findOne(cepSemTraco);
		retorno = buscarCepComListaCepZerados(cepSemTraco, retorno);
		log.debug("fim do findByCep: pesquisando o cep ", cep);
		return retorno;
	}

	/**
	 * busca cep com lista de cep com zeros a direita
	 * @param cepSemTraco
	 * @param retorno
	 * @return
	 */
	private Cep buscarCepComListaCepZerados(String cepSemTraco, Cep retorno) {
		if(retorno == null ){
			List<String> ceps = new ArrayList<>();
			for (int i = 0; i < TENTATIVA; i++) {
				final String novoCep = ValidationUtil.gerarCepComZeros(cepSemTraco);
				ceps.add(novoCep);
				cepSemTraco = novoCep;
			}
			
			retorno = cepRepository.findEnderecoByCepIn(ceps);
		}
		return retorno;
	}
	
	/**
	 * Valida o cep informado
	 * @param cep
	 * @return boolean
	 */
	private boolean isCepValido(String cep){
		
		boolean retorno = false;
		if(cep != null && cep.matches(FORMATO_CEP)){
			retorno = true;
		}
		return retorno;
		
		
	}

}
