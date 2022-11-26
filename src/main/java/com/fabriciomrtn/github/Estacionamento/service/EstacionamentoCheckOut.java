package com.fabriciomrtn.github.Estacionamento.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.fabriciomrtn.github.Estacionamento.model.Estacionamento;

public class EstacionamentoCheckOut {
	
	public static final int UMA_HORA = 60;
	public static final int VINTE_QUATRO_HORAS = 24 * UMA_HORA;
	public static final double VALOR_UMA_HORA = 5.00;
	public static final double ADICIONAL_POR_HORA = 2.00;
	public static final double VALOR_DO_DIA = 20.00;
	
	public static Double getConta(Estacionamento est) {
		return getConta(est.getDataEntrada(), est.getDataSaida());
	}
	
	private static Double getConta(LocalDateTime entrada, LocalDateTime saida) {
		long minutos = entrada.until(saida, ChronoUnit.MINUTES);
		Double conta = 0.0;
		
		if(minutos <= UMA_HORA) {
			return VALOR_UMA_HORA;
		}
		
		if(minutos <= VINTE_QUATRO_HORAS) {
			conta = VALOR_UMA_HORA;
			int horas = (int) (minutos / UMA_HORA);
			System.out.println(horas);
			for (int i = 0; i < horas; i++) {
				conta += ADICIONAL_POR_HORA;
			}
			return conta;
		}
		
		int dias = (int) (minutos / VINTE_QUATRO_HORAS);
		System.out.println(dias);
		for (int i = 0; i < dias; i++) {
			conta += VALOR_DO_DIA;
		}
		return conta;
	}
}
