package com.fabriciomrtn.github.Estacionamento.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciomrtn.github.Estacionamento.Controller.Mapper.EstacionamentoMapper;
import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoDTO;
import com.fabriciomrtn.github.Estacionamento.Model.Estacionamento;
import com.fabriciomrtn.github.Estacionamento.Service.EstacionamentoService;

@RestController
@RequestMapping("/parking")
public class EstacionamentoController {
	private final EstacionamentoService estacionamentoService;
	private final EstacionamentoMapper estacionamentoMapper;
	
	public EstacionamentoController(EstacionamentoService estacionamentoService, EstacionamentoMapper estacionamentoMapper) {
		this.estacionamentoService = estacionamentoService;
		this.estacionamentoMapper = estacionamentoMapper;
		
	}
		
	@GetMapping
	public List<EstacionamentoDTO> findAll(){
		List<Estacionamento> listaEstacionamento = estacionamentoService.findAll();	
		List<EstacionamentoDTO> resultado = estacionamentoMapper.toEstacionamentoDTOList(listaEstacionamento);
		return resultado;
	}
}
