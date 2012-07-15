package br.com.camilolopes.extenso.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.camilolopes.extenso.Extenso;


public class ExtensoTest {

	@Test
	public void testExtensoValidoDigitoNum() {
		assertEquals("dois reais", new Extenso(2).toString());
		assertEquals("três reais e vinte e cinco centavos",
				new Extenso(3.25).toString());
	}

	@Test
	public void testExtensoValidoDezena() {
		assertEquals("doze reais", new Extenso(12.0).toString());
		assertEquals("quinze reais e cinquenta centavos",
				new Extenso(15.50).toString());
	}

	@Test
	public void testExtensoValidoCentena() {
		assertEquals("cento e três reais", new Extenso(103).toString());
		assertEquals("cento e vinte e três reais", new Extenso(123).toString());
	}

	@Test
	public void testExtensoValidoMilhar() {
		assertEquals("hum mil e duzentos e cinquenta e quatro reais",
				new Extenso(1254).toString());
		assertEquals("hum mil e trezentos reais e trinta centavos",
				new Extenso(1300.30).toString());
		assertEquals(
				"vinte e três mil e novecentos e oitenta e sete reais e sessenta e cinco centavos",
				new Extenso(23987.65).toString());
	}

	@Test
	public void testExtensoValidoBilhar() {
		assertEquals("dois milhões de reais",
				new Extenso(2000000.00).toString());
	}

	@Test
	public void testExtensoValidaBigDecimal() {
		assertEquals("trinta e dois reais e onze centavos", new Extenso(
				new BigDecimal("32.11")).toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExtensoInvalidoLetra() {
		new Extenso("dois reais").toString();
	}

}
