package com.fabriciomrtn.github.Estacionamento.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoDTO;
import com.fabriciomrtn.github.Estacionamento.exceptions.EstacionamentoNaoEncontradoException;
import com.fabriciomrtn.github.Estacionamento.model.Estacionamento;

@Service
public class EstacionamentoService {
	private static Map<String, Estacionamento> estacionamentoMap = new HashMap<String, Estacionamento>();
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	static {
		var id1 = getUUID();
		var id2 = getUUID();
		Estacionamento estacionamento = new Estacionamento(id1, "DMS-1111", "SC", "CELTA", "PRETO");
		
		estacionamentoMap.put(id1, estacionamento);
		
	}
	
	public List<Estacionamento> findAll(){
		return estacionamentoMap.values().stream().collect(Collectors.toList());
	}

	public Estacionamento findById(String id) {
		Estacionamento estacionamento = estacionamentoMap.get(id);
		if(estacionamento == null) {
			throw new EstacionamentoNaoEncontradoException(id);
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

	public void delete(String id) {
		findById(id);
		estacionamentoMap.remove(id);
	}

	public Estacionamento update(String id, Estacionamento estacionamentoCreate) {
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(estacionamentoCreate.getCor());
		estacionamentoMap.replace(id, estacionamento);
		return estacionamento;
	}

	public Estacionamento saida(String id) {
		return null;
	}		
}
