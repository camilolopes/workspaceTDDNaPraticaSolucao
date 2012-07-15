package br.com.camilolopes.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.camilolopes.bean.Cliente;

public class ClienteTest {

	@Test
	public void testPegarEmprestimo() {
		assertEquals(new BigDecimal(2000), Cliente.pegaEmprestimo(2000));

	}

	@Test
	public void testEmprestimoNegado() {
		assertEquals(new BigDecimal(0.0), Cliente.pegaEmprestimo(3000));
	}

	@Test
	public void testPagarEmprestimo() {
		assertEquals(new BigDecimal(1000.0), Cliente.pagaEmprestimo(1000));

	}

	@Test
	public void testCheckEmprestimo() {
		assertEquals(new BigDecimal(1000), Cliente.checkEmprestimo());
	}

}
