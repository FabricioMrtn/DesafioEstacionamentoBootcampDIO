package com.fabriciomrtn.github.Estacionamento.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EstacionamentoDTO {
	private String id;
	private String placa;
	private String estado;
	private String modelo;
	private String cor;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataEntrada;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataSaida;
	private double conta;
	
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
