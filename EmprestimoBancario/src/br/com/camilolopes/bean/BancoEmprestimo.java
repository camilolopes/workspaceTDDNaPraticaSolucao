package br.com.camilolopes.bean;

public class BancoEmprestimo {

	private static final int MULTIPLICADOR = 2;

	public static double calculaEmprestimo(double valor) {
		double valorEmprestar = valor * MULTIPLICADOR;
		return valorEmprestar;
	}
}
