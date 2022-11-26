package com.fabriciomrtn.github.Estacionamento.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Estacionamento> findAll(){
		return estacionamentoRespository.findAll();
	}
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Estacionamento findById(String id) {
		return estacionamentoRespository.findById(id).orElseThrow( 
				() -> new EstacionamentoNaoEncontradoException(id) );
	}
	
	@Transactional
	public Estacionamento create(Estacionamento estacionamentoCreate) {
		String uuid = getUUID();
		estacionamentoCreate.setId(uuid);
		estacionamentoCreate.setDataEntrada(LocalDateTime.now());
		return estacionamentoRespository.save(estacionamentoCreate);
	}
	
	@Transactional
	public void delete(String id) {
		findById(id);
		estacionamentoRespository.deleteById(id);;
	}
	
	@Transactional
	public Estacionamento update(String id, Estacionamento estCreate) {
		Estacionamento estacionamento = findById(id);
		estacionamento.setCor(estCreate.getCor());
		estacionamento.setEstado(estCreate.getEstado());
		estacionamento.setModelo(estCreate.getModelo());
		estacionamento.setPlaca(estCreate.getPlaca());
		estacionamentoRespository.save(estacionamento);
		return estacionamento;
	}
	
	@Transactional
	public Estacionamento checkOut(String id) {
		Estacionamento est = findById(id);
		est.setDataSaida(LocalDateTime.now());
		est.setConta(EstacionamentoCheckOut.getConta(est));		
		estacionamentoRespository.save(est);
		return est;
	}		
}
