package br.com.camilolopes.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Boleto {
	private int diaPgto;
	private String data;

	public int getDiaPgto() {
		return diaPgto;
	}

	public long verificaPgto(String vencimento, String pgto)
			throws ParseException {
		SimpleDateFormat simpledf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateVenci = simpledf.parse(vencimento);
		Date datePgto = simpledf.parse(pgto);

		Calendar calendarVenc = Calendar.getInstance();
		calendarVenc.setTime(datePgto);
		Calendar calendarPgto = Calendar.getInstance();
		calendarPgto.setTime(dateVenci);
		long diferenca = calendarVenc.getTimeInMillis()
				- calendarPgto.getTimeInMillis();
		int hrDia = 24;
		int minHr = 60;
		int secMin=60;
		int mileMin = 1000;
		int tempoDia = mileMin * secMin * minHr * hrDia;
		long diasDiferenca = diferenca / tempoDia;
		return diasDiferenca;
	}

	public void setDiaPgto(int diaPgto) {
		this.diaPgto = diaPgto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
