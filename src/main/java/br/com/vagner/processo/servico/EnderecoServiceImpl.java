/**
 * 
 */
package br.com.vagner.processo.servico;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vagner.processo.entity.Endereco;
import br.com.vagner.processo.exception.EnderecoNotFoundException;
import br.com.vagner.processo.exception.InvalidCepException;
import br.com.vagner.processo.repository.EnderecoRepository;



/**
 * @author Vagner Rodrigues Souza
 *
 */
@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	private final Logger log = LoggerFactory.getLogger(EnderecoServiceImpl.class);

	
	@Autowired
	private EnderecoRepository enderecoRepository;


	/* (non-Javadoc)
	 * @see br.com.vagner.desafio.service.EnderecoService#delete(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void delete(Integer id) throws EnderecoNotFoundException {
		log.debug("Inicio delete : ", id);
		final Endereco entity = enderecoRepository.findOne(id);
		if(entity == null){
			throw new EnderecoNotFoundException(id);
		}
		
		enderecoRepository.delete(id);
		log.debug("Registro excluido ", id);
	}

	/* (non-Javadoc)
	 * @see br.com.vagner.desafio.service.EnderecoService#insert(br.com.vagner.desafio.entity.Endereco)
	 */
	@Override
	public Endereco insert(Endereco entity) throws InvalidCepException {
		
		String cep = entity.getCep();
		if(!isCepValido(cep)){
			throw new InvalidCepException(cep);
		}
		Endereco enderecoInserted = enderecoRepository.save(entity);
		
		log.debug("Endereço {} incluído", enderecoInserted.getId());
		return enderecoInserted;
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


	/* (non-Javadoc)
	 * @see br.com.vagner.desafio.service.EnderecoService#update(br.com.vagner.desafio.entity.Endereco)
	 */
	@Override
	public Endereco update(Integer id, Endereco entity) throws InvalidCepException {
		log.debug("Inicio do metodo update", entity.getCep());
		String cep = entity.getCep();
		if(!isCepValido(cep)){
			throw new InvalidCepException(cep);
		}
		Endereco endereco = enderecoRepository.findOne(id);
		endereco = enderecoRepository.save(entity);
		log.debug("Alteracao efetuada", endereco.getId());
				
		return endereco;
	}

	@Override
	@Transactional(readOnly=true)
	public Endereco pesquisar(Integer id) {
		
		return enderecoRepository.findOne(id);
	}

}
