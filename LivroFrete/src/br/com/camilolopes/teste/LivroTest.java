package br.com.camilolopes.teste;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;

import org.junit.Test;

import br.com.camilolopes.bean.Livro;

public class LivroTest {

	@Test
	public void testCalculaFreteLivroLocalmente() {
		LinkedHashSet<Livro> cestaLivro = new LinkedHashSet<Livro>();
		cestaLivro.add(new Livro(0, "Guia do exame SCJP", 1));
		assertEquals("Entrega em 5 dias",
				new Livro().checkout(cestaLivro, "SP", "SP"));
	}

	@Test
	public void testCalculaFreteLocalDiferente() {
		LinkedHashSet<Livro> cestaLivro = new LinkedHashSet<Livro>();
		cestaLivro.add(new Livro(0, "Guia do exame SCJP", 1));
		cestaLivro.add(new Livro(1, "Dominando Hibernate", 2));
		assertEquals("Entrega em 15 dias",
				new Livro().checkout(cestaLivro, "BA", "SP"));
	}

	@Test
	public void testCaculaFreteMenosUmKg() {
		LinkedHashSet<Livro> cestaLivro = new LinkedHashSet<Livro>();
		cestaLivro.add(new Livro(0, "Guia do exame SCJP", 0.500));
		assertEquals("Entrega em 5 dias",
				new Livro().checkout(cestaLivro, "SP", "SP"));

	}

	@Test
	public void testCalculaMaisUmKg() {
		LinkedHashSet<Livro> cestaLivro = new LinkedHashSet<Livro>();
		cestaLivro.add(new Livro(0, "Guia do exame SCJP", 1));
		cestaLivro.add(new Livro(1, "Dominando Hibernate", 2));
		cestaLivro.add(new Livro(3, "TomCat Administrador", 1));
		cestaLivro.add(new Livro(4, "Core JSF 2.0", 1));
		cestaLivro.add(new Livro(5, "Certificação LPI", 1));
		assertEquals("Entrega em 5 dias",
				new Livro().checkout(cestaLivro, "RJ", "rj"));
	}

}
