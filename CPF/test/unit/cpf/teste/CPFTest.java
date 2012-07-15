package cpf.teste;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import br.com.camilolopes.cpf.CPF;
import br.com.camilolopes.cpf.exception.CPFFormatException;

public class CPFTest {
	private CPF cpf;
	@Before
	public void setUp() throws Exception {
		cpf = new CPF();
	}
	@Test
	public void testCPFValido(){
		assertEquals(cpf.toString(),CPF.parseCPF("014.403.100-23"));
	}
	
	@Test(expected = CPFFormatException.class)
	public void testCPFInvalido(){
		assertEquals(cpf.toString(),CPF.parseCPF("615.317.826-04"));
	}
	@Test(expected = CPFFormatException.class)
	public void testCPFSemHifen(){
		assertEquals(cpf.toString(), CPF.parseCPF("615.317.82604"));
	}
	
	@Test(expected=CPFFormatException.class)
	public void testCPFSemPontos(){
		assertEquals(cpf.toString(), CPF.parseCPF("565224818-12"));
	}
	@Test(expected=CPFFormatException.class)
	public void testCPFDigitoVerificadorIncorreto(){
		assertEquals(cpf.toString(),CPF.parseCPF("974.674.714-233"));
	}
	
	@Test(expected=CPFFormatException.class )
	public void testCPFComLetras(){
		assertEquals(cpf.toString(), CPF.parseCPF("974.6B4.714-2C"));
	}
}
