package br.com.camilolopes.bean;

import java.math.BigDecimal;
import java.util.HashMap;

public class ConsumoEletro {
	private static final double DIVISOR = 1000;
	private final int HORADIA = 24;
	private double kwh;
	public BigDecimal calcularConsumoEletro(String eletro, double valorKwh) {
		
		if(listaEletrodomestico().containsKey(eletro)){
			double tempKwh = listaEletrodomestico().get(eletro)/DIVISOR;
			kwh = tempKwh * HORADIA;
		}			
		double valorConsumo = valorKwh * kwh;
		return new BigDecimal(valorConsumo);
	}
	public HashMap<String,Integer> listaEletrodomestico(){
		HashMap<String, Integer> listaEletro = new HashMap<String, Integer>();
			listaEletro.put("Lavadora", 900);
			listaEletro.put("Microondas", 500);
			listaEletro.put("Maquina de Secar", 1000);	
			listaEletro.put("Refrigerador", 1200);
		return listaEletro;
	}
	
	

}
