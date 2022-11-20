package com.fabriciomrtn.github.Estacionamento.exceptions;

public class EstacionamentoNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EstacionamentoNaoEncontradoException() {
		super("Dados de veiculo não encontrados");
	}
}
