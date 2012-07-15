package br.com.camilolopes.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.camilolopes.bean.Email;


public class EmailTeste {

	@Test
	public void testEmailValido(){
		assertEquals("valido", Email.verificaLogin("camilo.lopes@camilolopes.com.br" ));
		assertEquals("valido", Email.verificaLogin("cam34lopes@camilolopes.com.br"));
	
	}
	@Test 
	public void testEmailValidoDominioDiferente(){
		assertEquals("valido", Email.verificaLogin("camilo@lopes.net"));
		assertEquals("valido", Email.verificaLogin("opensource@open.org"));
	}
	
	@Test
	public void testEmailInvalidoDominio(){
		assertEquals("invalido", Email.verificaLogin("camilo@"));
	}
	
	@Test
	public void testEmailInvalidoEspaco(){
		assertEquals("invalido", Email.verificaLogin("camilo lopes@camilopes.com.br"));
		assertEquals("invalido", Email.verificaLogin("debian@debian .org"));
	}
	
	@Test
	public void testEmailInvalidoSimbolo(){
		assertEquals("invalido", Email.verificaLogin("java$man@yahoo.net"));
	}
}
