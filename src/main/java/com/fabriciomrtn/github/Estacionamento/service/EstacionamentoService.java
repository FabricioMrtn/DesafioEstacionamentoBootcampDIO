package com.fabriciomrtn.github.Estacionamento.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fabriciomrtn.github.Estacionamento.exceptions.EstacionamentoNaoEncontradoException;
import com.fabriciomrtn.github.Estacionamento.model.Estacionamento;

@Service
public class EstacionamentoService {
	private static Map<String, Estacionamento> estacionamentoMap = new HashMap<String, Estacionamento>();
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	static {
		var id = getUUID();
		var id1 = getUUID();
		Estacionamento estacionamento = new Estacionamento(id, "DMS-1111", "SC", "CELTA", "PRETO");
		Estacionamento estacionamento1 = new Estacionamento(id, "PAG-2252", "RJ", "FOX", "CINZA");
		estacionamentoMap.put(id, estacionamento);
		estacionamentoMap.put(id1, estacionamento1);
	}
	
	public List<Estacionamento> findAll(){
		return estacionamentoMap.values().stream().collect(Collectors.toList());
	}

	public Estacionamento findById(String id) {
		Estacionamento estacionamento = estacionamentoMap.get(id);
		if(estacionamento == null) {
			throw new EstacionamentoNaoEncontradoException();
		}
		return estacionamento;
	}
	
	public Estacionamento create(Estacionamento estacionamentoCreate) {
		String uuid = getUUID();
		estacionamentoCreate.setId(uuid);
		estacionamentoCreate.setDataEntrada(LocalDateTime.now());
		estacionamentoMap.put(uuid, estacionamentoCreate);
		return estacionamentoCreate;
	}	
}
