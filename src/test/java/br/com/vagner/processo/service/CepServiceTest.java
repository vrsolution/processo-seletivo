package br.com.vagner.processo.service;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.vagner.processo.entity.Cep;
import br.com.vagner.processo.exception.CepNotFoundException;
import br.com.vagner.processo.exception.InvalidCepException;
import br.com.vagner.processo.repository.CepRepository;
import br.com.vagner.processo.servico.CepService;
import br.com.vagner.processo.servico.CepServiceImpl;


/**
 * Testes unitários para a busca do Endereco.
 * 
 * @author Vagner Rodrigues Souza
 */
@RunWith(MockitoJUnitRunner.class)
public class CepServiceTest {
	private final static String CEP_INVALIDO = "999999-9999";
	private final static String CEP_VALIDO = "08061430";
	private final static String CEP_VALIDO_ZEROS = "08061439";
	private String cep;
	private Cep endereco;
	
	@Mock
	private CepRepository cepRepository;
	
	@InjectMocks
	private CepService enderecoService = new CepServiceImpl();
	
	@Before
	public void clear(){
		cep = null;
		endereco = criarEndereco();
		Mockito.reset(cepRepository);
	}
	
	/**
	 * Carregar Endereco mockado
	 * @return entidade endereco
	 */
	private Cep criarEndereco(){
		return new Cep(CEP_VALIDO,"Rua Palmeira de Leque, 640","Jd Pedro Jose Nunes", "Sao Paulo", "SP");
		
	}
	
	/**
	 * Dado um CEP inválido deve retornar a mensagem CEP inválido.
	 * 
	 * @throws InvalidCepException
	 * @throws CepNotFoundException 
	 */
	@Test(expected=InvalidCepException.class)
	public void testCepInvalido() throws InvalidCepException, CepNotFoundException{
		cep = CEP_VALIDO;
		when(cepRepository.findOne(eq(cep))).thenReturn(endereco);
		Cep retorno = enderecoService.findByCep(CEP_INVALIDO);
		Assert.assertEquals(retorno, endereco);
	}
	
	/**
	 * Testar Cep valido, retornando Endereco cadastrado
	 * @throws InvalidCepException
	 * @throws CepNotFoundException 
	 */
	@Test
	public void testCepValido() throws InvalidCepException, CepNotFoundException{
		cep = CEP_VALIDO;
		when(cepRepository.findOne(eq(cep))).thenReturn(endereco);
		Cep retorno = enderecoService.findByCep(CEP_VALIDO);
		Assert.assertEquals(retorno, endereco);
	}
	
	/**
	 * Testar Cep para colocar os Zeros a direita
	 * @throws InvalidCepException
	 * @throws CepNotFoundException 
	 */
	@Test
	public void testCepZerado()throws InvalidCepException, CepNotFoundException{
		cep = CEP_VALIDO;
		when(cepRepository.findOne(eq(cep))).thenReturn(endereco);
		Cep retorno = enderecoService.findByCep(CEP_VALIDO_ZEROS);
		Assert.assertEquals(retorno, endereco);
		
	}
}
