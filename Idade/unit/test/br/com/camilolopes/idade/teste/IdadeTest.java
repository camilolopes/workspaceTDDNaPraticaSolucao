package br.com.camilolopes.idade.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.camilolopes.idade.Idade;


public class IdadeTest {

	@Test
	public void testIdadeCorrente() {
		assertEquals("23", Idade.calculaIdade(1987));
	}

	@Test
	public void testAnoNascimento() {
		assertEquals(1987, Idade.calculaAnoNascimento(23));
	}

	@Test
	public void testDataAtualFormatada() {
		assertEquals("22/11/2010", Idade.getDataCorrente());
	}

}
