/**
 * 
 */
package br.com.vagner.processo.servico;

import br.com.vagner.processo.entity.Endereco;
import br.com.vagner.processo.exception.EnderecoNotFoundException;
import br.com.vagner.processo.exception.InvalidCepException;

/**
 * @author Vagner Rodrigues Souza
 *
 */
public interface EnderecoService {
	
	public static final String FORMATO_CEP = "^\\d{5,5}-?\\d{3,3}$";

	
	void delete(Integer id)throws EnderecoNotFoundException;
	
	Endereco insert(Endereco entity)throws InvalidCepException;
	
	Endereco update(Integer id, Endereco entity)throws InvalidCepException;
	
	Endereco pesquisar(Integer id);
	
	

}
