package br.com.camilolopes.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Email {
	private String email;
	

	public static String verificaLogin(String email) {
		String resultado = "invalido";
		Pattern expressao = Pattern
				.compile("^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$");
		Matcher mat = expressao.matcher(email);
		boolean found = mat.matches();
		if (found) {
			resultado = "valido";
		}

		return resultado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
