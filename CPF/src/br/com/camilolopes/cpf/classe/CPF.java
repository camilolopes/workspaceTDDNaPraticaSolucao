package br.com.camilolopes.cpf.classe;

public class CPF {
	private static final int posDVseg = 13;
	private static final int posDVpri = 12;
	private static final int poshifen = 11;
	private static final int pospontoseg = 7;
	private static final int pospontopri = 3;
	private static final int sizeCpf = 14;
	private String cpf;

	public CPF(String cpf) {
		this.cpf = cpf;
	}

	public static CPF parseCPF(String cpf) throws CPFFormatException {
		if ((cpf == null) || (cpf.isEmpty()) || (cpf.length()) != sizeCpf
				|| (cpf.charAt(pospontopri) != '.')
				|| (cpf.charAt(pospontoseg) != '.')
				|| (cpf.charAt(poshifen) != '-')) {
			throw new CPFFormatException();
		}
		for (int i = 0; i < cpf.length(); i++) {
			if (i == posDVpri || i == posDVseg) {
				char posicao = cpf.charAt(i);
				// se não for um dígito retorne false
				if (!Character.isDigit(posicao)) {
					throw new CPFFormatException();
				}
			}
		}
		// implementar o verificador do DV antes do retorno
		return new CPF(cpf);
	}

	public String toString() {

		return cpf;
	}

	public boolean equals(Object obj) {
		if (obj instanceof CPF) {
			if (obj.toString().equals(this.toString())) {
				return true;
			}
		}
		return false;
	}

	// verifica o digito, 
	public static int digito(String cpfdv) {

		int numeros[] = new int[6];
		int soma = 0;
		int dig = 0;
		for (int i = 0; i <= 5; i++) {
			// altera mulçtiplicação por 1 e 2
			if (i % 2 == 0) {
				numeros[i] = Integer.parseInt(cpfdv) * 1;
			} else {
				numeros[i] = Integer.parseInt(cpfdv) * 2;
			}
			// se = 10 soma 1
			if (numeros[i] == 10) {
				soma += 1;
			}
			// se menor 10 soma o numero
			else if (numeros[i] < 10) {
				soma += numeros[i];
			}
			// se maior q 10 soma os digitos
			// ex.: 14 soma 1 + 4 = 5
			// nunca o numero sera maior q 18
			// 2 * 9 !!!
			else {
				soma += (numeros[i] / 10) + (numeros[i] % 10);
			}
		}
		// faz 10 - MOD10
		dig = 10 - (soma % 10);
		return dig;
	}

}
