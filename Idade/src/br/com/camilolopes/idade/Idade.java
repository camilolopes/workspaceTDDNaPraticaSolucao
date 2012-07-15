package br.com.camilolopes.idade;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Idade {
	private static final int menorIdade = 18;

	public Idade() {
		// TODO Auto-generated constructor stub
	}

	public static String calculaIdade(int anoNascimento)
			 {
		int idade = getAnoCorrente() - anoNascimento;
		String idadeConvert = Integer.toString(idade);
		if (idade < menorIdade)
			return "Idade inapropriada";
		return idadeConvert;
	}

	public static int calculaAnoNascimento(int idadeAtual) {
		int anoNascimento = getAnoCorrente() - idadeAtual;
		return anoNascimento;
	}

	// mostrando o uso de Locale com DateFormat
	public static String getDataCorrente() {
		Date data = new Date();
		Locale br = new Locale("pt", "BR");
		DateFormat dataformatada = DateFormat.getDateInstance(2, br);
		String dataAtual = dataformatada.format(data);
		return dataAtual;
	}


	public static int getAnoCorrente() {
		Calendar calendar = Calendar.getInstance();
		int anoAtual = calendar.get(Calendar.YEAR);
		return anoAtual;
	}

	public boolean equals(Object objt) {
		if (objt instanceof Idade) {
			return true;
		} else {
			return false;
		}
	}

}// fim da classe
