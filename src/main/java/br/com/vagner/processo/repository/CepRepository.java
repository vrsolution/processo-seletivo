/**
 * 
 */
package br.com.vagner.processo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vagner.processo.entity.Cep;

/**
 * @author Vagner Rodrigues Souza
 *
 */
@Repository
public interface CepRepository extends CrudRepository<Cep, String> {
	
	
	Cep findEnderecoByCepIn(List<String> ceps);

}
