/**
 * 
 */
package br.com.vagner.processo.servico;

import br.com.vagner.processo.entity.Cep;
import br.com.vagner.processo.exception.InvalidCepException;

/**
 * Interface Serviço com as funcionalidades relacionadas a consulta de CEP.
 * @author Vagner Rodrigues Souza
 *
 */

public interface CepService {
	
	
	public static final String FORMATO_CEP = "^\\d{5,5}-?\\d{3,3}$";
	public static final String ZERADO = "00000000";
	public static final int TENTATIVA = 8;
	
	/**
	 * Pesquisa o Endereco pelo Cep
	 * @param cep
	 * @return Cep
	 * @throws InvalidCepException
	 */
	Cep findByCep(String cep) throws InvalidCepException;

}
