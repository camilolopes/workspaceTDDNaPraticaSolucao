package br.com.camilolopes.teste;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.camilolopes.bean.ConsumoEletro;

public class ConsumoEletricoTeste {

	@Test
	public void testCalculaValorConsumoHora() {
		assertEquals(new BigDecimal(6.48),
				new ConsumoEletro().calcularConsumoEletro("Lavadora", 0.30));
		assertEquals(new BigDecimal(5.40),
				new ConsumoEletro().calcularConsumoEletro("Microondas", 0.45));
	}

	@Test
	public void testProdutoInexistente() {
		assertEquals(new BigDecimal(0),
				new ConsumoEletro().calcularConsumoEletro("Secadora", 0.33));
		assertEquals(new BigDecimal(0),
				new ConsumoEletro().calcularConsumoEletro("Centrifuga", 0.55));
	}
}
