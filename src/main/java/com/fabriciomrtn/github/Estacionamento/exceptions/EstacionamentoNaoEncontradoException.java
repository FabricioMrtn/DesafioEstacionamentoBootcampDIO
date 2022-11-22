package com.fabriciomrtn.github.Estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EstacionamentoNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EstacionamentoNaoEncontradoException(String id) {
		super("Dados de veiculo não encontrados com o id: " + id);
	}
}
