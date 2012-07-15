package br.com.camilolopes.bean;

import java.math.BigDecimal;

public class Cliente {
	private String nome;
	private static double rendaMensal = 1000.00;
	private static double saldoEmprestimo;

	
	public static BigDecimal pegaEmprestimo(double valorEmp) {
		double limiteEmprestimo = BancoEmprestimo.calculaEmprestimo(rendaMensal);
		if (limiteEmprestimo >= valorEmp) {
			setSaldoEmprestimo(limiteEmprestimo);
			return new BigDecimal(Double.valueOf(valorEmp));
		} else {
			return new BigDecimal(Double.valueOf(0.0));
		}
	}
	
	public static BigDecimal pagaEmprestimo(double pagarEmp){
		if(pagarEmp <= saldoEmprestimo)
			saldoEmprestimo = saldoEmprestimo - pagarEmp;
		
		return new BigDecimal(saldoEmprestimo);
	}
	
	public static BigDecimal checkEmprestimo(){
		double checkValor = getSaldoEmprestimo();
		return new BigDecimal(checkValor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static double getRendaMensal() {
		return rendaMensal;
	}

	public static void setRendaMensal(double rendaMensal) {
		Cliente.rendaMensal = rendaMensal;
	}

	public static double getSaldoEmprestimo() {
		return saldoEmprestimo;
	}

	public static void setSaldoEmprestimo(double saldoEmp) {
		saldoEmprestimo = saldoEmp;
	}

}
