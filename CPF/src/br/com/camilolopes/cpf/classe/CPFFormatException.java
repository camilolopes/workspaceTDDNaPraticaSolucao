package br.com.camilolopes.cpf.classe;

public class CPFFormatException extends IllegalArgumentException {
	public CPFFormatException() {
		super("formato cpf inválido");
	}
}
