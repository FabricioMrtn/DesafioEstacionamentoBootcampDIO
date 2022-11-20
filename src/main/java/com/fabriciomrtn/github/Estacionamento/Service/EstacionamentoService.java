package com.fabriciomrtn.github.Estacionamento.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fabriciomrtn.github.Estacionamento.Model.Estacionamento;

@Service
public class EstacionamentoService {
	private static Map<String, Estacionamento> mapaEstacionamento = new HashMap<String, Estacionamento>();
	
	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	static {
		var id = getUUID();
		Estacionamento estacionamento = new Estacionamento(id, "DMS-1111", "SC", "CELTA", "PRETO");
		mapaEstacionamento.put(id, estacionamento);
	}
	
	public List<Estacionamento> findAll(){
		return mapaEstacionamento.values().stream().collect(Collectors.toList());
	}
	
	
	
}
