package br.com.camilolopes.extenso;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Extenso {
	private ArrayList nroLista;
	private BigInteger num;

	private String Qualificadores[][] = { { "centavo", "centavos" },
			{ "", "" }, { "mil", "mil" }, { "milhão", "milhões" },
			{ "bilhão", "bilhões" }, { "trilhão", "trilhões" },
			{ "quatrilhão", "quatrilhões" }, { "quintilhão", "quintilhões" },
			{ "sextilhão", "sextilhões" }, { "septilhão", "septilhões" } };
	private String Numeros[][] = {
			{ "zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete",
					"oito", "nove", "dez", "onze", "doze", "treze", "quatorze",
					"quinze", "desesseis", "desessete", "dezoito", "desenove" },
			{ "vinte", "trinta", "quarenta", "cinquenta", "sessenta",
					"setenta", "oitenta", "noventa" },
			{ "cem", "cento", "duzentos", "trezentos", "quatrocentos",
					"quinhentos", "seiscentos", "setecentos", "oitocentos",
					"novecentos" } };

	public Extenso() {
		nroLista = new ArrayList();
	}

	public Extenso(BigDecimal dec) {
		this();
		setNumber(dec);
	}

	// para valores com casa decimal
	public Extenso(double dec) {
		this();
		setNumber(dec);
	}

	// em caso de erro de digitação
	public Extenso(String num) throws IllegalArgumentException {
		throw new IllegalArgumentException();
	}

	public void setNumber(BigDecimal dec) {
		// Converte para inteiro arredondando os centavos
		num = dec.setScale(2, BigDecimal.ROUND_HALF_UP)
				.multiply(BigDecimal.valueOf(100)).toBigInteger();

		// Adiciona valores
		nroLista.clear();
		if (num.equals(BigInteger.ZERO)) {
			// Centavos
			nroLista.add(new Integer(0));
			// Valor
			nroLista.add(new Integer(0));
		} else {
			// Adiciona centavos
			findNum(100);

			// Adiciona grupos de 1000
			while (!num.equals(BigInteger.ZERO)) {
				findNum(1000);
			}
		}
	}

	public void setNumber(double dec) {
		setNumber(new BigDecimal(dec));
	}

	public void show() {
		Iterator valores = nroLista.iterator();

		while (valores.hasNext()) {
			System.out.println(((Integer) valores.next()).intValue());
		}
		System.out.println(toString());
	}

	public String toString() {
		StringBuilder build = new StringBuilder();

		int numero = ((Integer) nroLista.get(0)).intValue();
		int ct;

		for (ct = nroLista.size() - 1; ct > 0; ct--) {
			// Se ja existe texto e o atual não é zero
			if (build.length() > 0 && !isGrupoZero(ct)) {
				build.append(" e ");
			}
			build.append(numToString(((Integer) nroLista.get(ct)).intValue(),
					ct));
		}
		if (build.length() > 0) {
			if (isUnicoGrupo())
				build.append(" de ");
			while (build.toString().endsWith(" "))
				build.setLength(build.length() - 1);
			if (isPrimeiroGrupoUm())
				build.insert(0, "h");
			if (nroLista.size() == 2
					&& ((Integer) nroLista.get(1)).intValue() == 1) {
				build.append(" real");
			} else {
				build.append(" reais");
			}
			if (((Integer) nroLista.get(0)).intValue() != 0) {
				build.append(" e ");
			}
		}
		if (((Integer) nroLista.get(0)).intValue() != 0) {
			build.append(numToString(((Integer) nroLista.get(0)).intValue(), 0));
		}
		return build.toString();
	}

	private boolean isPrimeiroGrupoUm() {
		if (((Integer) nroLista.get(nroLista.size() - 1)).intValue() == 1)
			return true;
		return false;
	}

	private void findNum(int divisor) {
		// Encontra newNum[0] = num modulo divisor, newNum[1] = num dividido
		// divisor
		BigInteger[] newNum = num.divideAndRemainder(BigInteger
				.valueOf(divisor));

		// Adiciona modulo
		nroLista.add(new Integer(newNum[1].intValue()));

		// Altera numero
		num = newNum[0];
	}

	private boolean isMaisGrupos(int pos) {
		for (; pos > 0; pos--) {
			if (((Integer) nroLista.get(pos)).intValue() != 0) {
				return true;
			}
		}

		return false;
	}

	private boolean isUltimoGrupo(int pos) {
		return (pos > 0) && ((Integer) nroLista.get(pos)).intValue() != 0
				&& !isMaisGrupos(pos - 1);
	}

	private boolean isUnicoGrupo() {
		if (nroLista.size() <= 3)
			return false;
		if (!isGrupoZero(1) && !isGrupoZero(2))
			return false;
		boolean hasOne = false;
		for (int i = 3; i < nroLista.size(); i++) {
			if (((Integer) nroLista.get(i)).intValue() != 0) {
				if (hasOne)
					return false;
				hasOne = true;
			}
		}
		return true;
	}

	private boolean isGrupoZero(int pos) {
		if (pos <= 0 || pos >= nroLista.size())
			return true;
		return ((Integer) nroLista.get(pos)).intValue() == 0;
	}

	private String numToString(int numero, int escala) {
		int unidade = (numero % 10);
		int dezena = (numero % 100); // * nao pode dividir por 10 pois verifica
										// de 0..19
		int centena = (numero / 100);
		StringBuilder buf = new StringBuilder();

		if (numero != 0) {
			if (centena != 0) {
				if (dezena == 0 && centena == 1) {
					buf.append(Numeros[2][0]);
				} else {
					buf.append(Numeros[2][centena]);
				}
			}

			if ((buf.length() > 0) && (dezena != 0)) {
				buf.append(" e ");
			}
			if (dezena > 19) {
				dezena /= 10;
				buf.append(Numeros[1][dezena - 2]);
				if (unidade != 0) {
					buf.append(" e ");
					buf.append(Numeros[0][unidade]);
				}
			} else if (centena == 0 || dezena != 0) {
				buf.append(Numeros[0][dezena]);
			}

			buf.append(" ");
			if (numero == 1) {
				buf.append(Qualificadores[escala][0]);
			} else {
				buf.append(Qualificadores[escala][1]);
			}
		}

		return buf.toString();
	}

}
