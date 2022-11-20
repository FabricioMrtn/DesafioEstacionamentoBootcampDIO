package com.fabriciomrtn.github.Estacionamento.Controller.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoCreateDTO;
import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoDTO;
import com.fabriciomrtn.github.Estacionamento.Model.Estacionamento;

@Component
public class EstacionamentoMapper {

	private static final ModelMapper MODEL_MAPPER= new ModelMapper();
	
	public EstacionamentoDTO toEstacionamentoDTO(Estacionamento estacionamento) {
		return MODEL_MAPPER.map(estacionamento, EstacionamentoDTO.class);
	}
	
	public Estacionamento toEstacionamento(EstacionamentoDTO dto) {
		return MODEL_MAPPER.map(dto, Estacionamento.class);
	}

	public List<EstacionamentoDTO> toEstacionamentoDTOList(List<Estacionamento> listaEstacionamento) {
		return listaEstacionamento.stream().map(this::toEstacionamentoDTO).collect(Collectors.toList());
	}

	public Estacionamento toEstacionamentoCreateDTO(EstacionamentoCreateDTO dto) {
		return MODEL_MAPPER.map(dto, Estacionamento.class);
	}
}
