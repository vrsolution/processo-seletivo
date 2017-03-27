/**
 * 
 */
package br.com.vagner.processo.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author Vagner Rodrigues Souza
 *
 */

public class InvalidCepExceptionResolver {
	
	public static final int CODE_CEP_INVALIDO = 420;
	
	public static final int SCODE_VALIDATION_ERROR = 400;
	public static final int CODE_INTEGRATION_FAILED = 510;
	public static final int CODE_USUARIO_NOT_FOUND = 430;
	public static final int CODE_ENDERECO_NOT_FOUND = 431;
	public static final int CODE_CEP_NOT_FOUND = 432;

	
	@ExceptionHandler(InvalidCepException.class)
    public void invalidCepExceptionHandler(Exception exception, HttpServletResponse response) throws IOException {
        response.setStatus(CODE_CEP_INVALIDO);   
        IOUtils.write(exception.getMessage(), response.getOutputStream());
    }
	
	@ExceptionHandler(EnderecoNotFoundException.class)
    public void enderecoUsuarioNotFoundExceptionHandler(Exception exception, HttpServletResponse response) throws IOException {
        response.setStatus(CODE_ENDERECO_NOT_FOUND);   
        IOUtils.write(exception.getMessage(), response.getOutputStream());
    }

	@ExceptionHandler(CepNotFoundException.class)
    public void cepNotFoundExceptionHandler(Exception exception, HttpServletResponse response) throws IOException {
        response.setStatus(CODE_CEP_NOT_FOUND);
        IOUtils.write(exception.getMessage(), response.getOutputStream());
    }
	

}
