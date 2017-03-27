/**
 * 
 */
package br.com.vagner.processo.exception;

/**
 * @author Vagner Rodrigues Souza
 *
 */
public class CepNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7222589350548817415L;

	public CepNotFoundException() {
	}

	public CepNotFoundException(String message) {
		super(message);
	}

	public CepNotFoundException(Throwable cause) {
		super(cause);
	}

	public CepNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CepNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


}
