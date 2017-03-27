/**
 * 
 */
package br.com.vagner.processo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vagner.processo.entity.Endereco;


/**
 * @author Vagner Rodrigues Souza
 *
 */
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {
	
	Endereco findEnderecoByCep(String cep);

}
