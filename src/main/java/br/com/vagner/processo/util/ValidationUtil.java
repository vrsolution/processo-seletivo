/**
 * 
 */
package br.com.vagner.processo.util;

import org.apache.commons.lang3.StringUtils;


/**
 * Monta uma lista de ceps, onde vai montando os cep acrescentando zeros a direita ate chegar no cep 00000000
 * @author Vagner Rodrigues Souza
 *
 */
public final class ValidationUtil {
	/**
	 * substitui os numeros da direita por zero da direita e adiciona na string todos os ceps
	 * @param cep
	 * @return String 
	 */
	public static String gerarCepComZeros(final String cep){
		
		final StringBuilder sb = new StringBuilder();
		final char[] chaveOriginal = cep.toCharArray();
		boolean trocado = false;
		//Percorre o array ao contrário
		for(int i=chaveOriginal.length-1;i>-1;i--){
			char zero = chaveOriginal[i];
			if(zero !='0' && !trocado){
				zero ='0';
				trocado=true;
			}
			sb.append(zero);
		}
		return StringUtils.reverse(sb.toString());

	}


}
