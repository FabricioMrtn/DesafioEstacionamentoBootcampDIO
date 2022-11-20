package com.fabriciomrtn.github.Estacionamento.Controller.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoDTO;
import com.fabriciomrtn.github.Estacionamento.Model.Estacionamento;

@Component
public class EstacionamentoMapper {

	private static final ModelMapper MODEL_MAPPER= new ModelMapper();
	
	public EstacionamentoDTO estacionamentoDTO(Estacionamento estacionamento) {
		return MODEL_MAPPER.map(estacionamento, EstacionamentoDTO.class);
	}
	
	public List<EstacionamentoDTO> toEstacionamentoDTOList(List<Estacionamento> listaEstacionamento) {
		return listaEstacionamento.stream().map(this::estacionamentoDTO).collect(Collectors.toList());
	}

}
