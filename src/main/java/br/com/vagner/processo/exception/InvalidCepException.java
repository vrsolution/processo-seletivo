/**
 * 
 */
package br.com.vagner.processo.exception;

/**
 * Sobe uma excecao quando o cep nao for valido
 * @author Vagner Rodrigues Souza
 *
 */
public class InvalidCepException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5371648400836178544L;

	public InvalidCepException() {
	}

	public InvalidCepException(String message) {
		super("CEP inválido");
	}

	public InvalidCepException(Throwable cause) {
		super(cause);
	}

	public InvalidCepException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCepException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


}
