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
import com.fabriciomrtn.github.Estacionamento.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {
	private final EstacionamentoRepository estacionamentoRespository;
	
	public EstacionamentoService(EstacionamentoRepository estacionamentoRespository) {
		this.estacionamentoRespository = estacionamentoRespository;
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
//	static {
//		var id1 = getUUID();
//		var id2 = getUUID();
//		Estacionamento estacionamento = new Estacionamento(id1, "DMS-1111", "SC", "CELTA", "PRETO");
//		
//		estacionamentoMap.put(id1, estacionamento);
//		
//	}
	
	public List<Estacionamento> findAll(){
		return estacionamentoRespository.findAll();
	}

	public Estacionamento findById(String id) {
		return estacionamentoRespository.findById(id).orElseThrow( 
				() -> new EstacionamentoNaoEncontradoException(id) );
	}
	
	public Estacionamento create(Estacionamento estacionamentoCreate) {
		String uuid = getUUID();
		estacionamentoCreate.setId(uuid);
		estacionamentoCreate.setDataEntrada(LocalDateTime.now());
		return estacionamentoRespository.save(estacionamentoCreate);
	}

	public void delete(String id) {
		findById(id);
		estacionamentoRespository.deleteById(id);;
	}

	public Estacionamento update(String id, Estacionamento estCreate) {
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(estCreate.getCor());
		estacionamento.setEstado(estCreate.getEstado());
		estacionamento.setModelo(estCreate.getModelo());
		estacionamento.setPlaca(estCreate.getPlaca());
		estacionamentoRespository.save(estacionamento);
		return estacionamento;
	}

	public Estacionamento saida(String id) {
		
		return null;
	}		
}
