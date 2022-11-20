package com.fabriciomrtn.github.Estacionamento.Model;

import java.time.LocalDateTime;

public class Estacionamento {
	private String id;
	private String placa;
	private String estado;
	private String modelo;
	private String cor;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private double conta;
	
	public Estacionamento() {}
	
	
	
	public Estacionamento(String id, String placa, String estado, String modelo, String cor) {
		super();
		this.id = id;
		this.placa = placa;
		this.estado = estado;
		this.modelo = modelo;
		this.cor = cor;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}
	public double getConta() {
		return conta;
	}
	public void setConta(double conta) {
		this.conta = conta;
	}
	
	
	
}
