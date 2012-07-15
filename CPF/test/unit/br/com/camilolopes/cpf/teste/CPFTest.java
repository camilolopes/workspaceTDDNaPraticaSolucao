package br.com.camilolopes.cpf.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.camilolopes.cpf.classe.CPF;
import br.com.camilolopes.cpf.classe.CPFFormatException;



public class CPFTest {

	@Test
	public void testCPFValido() {
		
		assertEquals(new CPF("014.403.100-23"), CPF.parseCPF("014.403.100-23"));
		assertEquals(new CPF("615.317.826-04"), CPF.parseCPF("615.317.826-04"));
		assertEquals(new CPF("565.224.818-12"), CPF.parseCPF("565.224.818-12"));
		assertEquals(new CPF("974.674.714-23"), CPF.parseCPF("974.674.714-23"));
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFFaltamDigitos() {
		CPF.parseCPF("15.317.826-04");
		CPF.parseCPF("615.17.826-04");
		CPF.parseCPF("615.317.26-04");
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFSobramDigitos() {
		CPF.parseCPF("9615.317.826-04");
		CPF.parseCPF("615.9317.826-04");
		CPF.parseCPF("615.317.9826-04");
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFSemHifen() {
		CPF.parseCPF("615.317.82604");
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFSemPontos() {
		CPF.parseCPF("818168448-61");
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFSobramDigitosVerificadores() {
		CPF.parseCPF("17043319-358");
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFComLetrasCorpo() {
		CPF.parseCPF("974.6B4.714-2C");
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFFaltamDigitosVerificadores() {
		CPF.parseCPF("974.674.714-2");
	}

	@Test(expected = CPFFormatException.class)
	public void testCPFComLetrasDigitoVerificador() {
		CPF.parseCPF("974.674.714-2C");
		CPF.parseCPF("974.674.714-D3");
	}
	

}
