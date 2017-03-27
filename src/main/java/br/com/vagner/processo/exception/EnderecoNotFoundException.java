/**
 * 
 */
package br.com.vagner.processo.exception;

/**
 * @author Vagner Rodrigues Souza
 *
 */
public class EnderecoNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1537267419513240321L;
	private static final String MESSAGE = "Endereço não encontrado";
	private final Integer id;

	/**
	 * Construtor.
	 * 
	 * @param id Id do endereço que não foi encontrado.
	 */
	public EnderecoNotFoundException(Integer id){
		super(MESSAGE);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}


}
