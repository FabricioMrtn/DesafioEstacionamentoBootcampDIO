package com.fabriciomrtn.github.Estacionamento.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabriciomrtn.github.Estacionamento.Controller.mapper.EstacionamentoMapper;
import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoCreateDTO;
import com.fabriciomrtn.github.Estacionamento.DTO.EstacionamentoDTO;
import com.fabriciomrtn.github.Estacionamento.model.Estacionamento;
import com.fabriciomrtn.github.Estacionamento.service.EstacionamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parking")
@Api(tags = "Estacionamento Controller")
public class EstacionamentoController {
	private final EstacionamentoService estacionamentoService;
	private final EstacionamentoMapper estacionamentoMapper;
	
	public EstacionamentoController(EstacionamentoService estacionamentoService, EstacionamentoMapper estacionamentoMapper) {
		this.estacionamentoService = estacionamentoService;
		this.estacionamentoMapper = estacionamentoMapper;
	}
		
	@GetMapping
	@ApiOperation("Carrega todos os carros")
	public ResponseEntity<List<EstacionamentoDTO>> findAll(){
		List<Estacionamento> listaEstacionamento = estacionamentoService.findAll();	
		List<EstacionamentoDTO> resultado = estacionamentoMapper.toEstacionamentoDTOList(listaEstacionamento);
		return ResponseEntity.ok(resultado);
	}
		
	@GetMapping("/{id}")
	@ApiOperation("Busca o carro pelo Id")
	public ResponseEntity<EstacionamentoDTO> findById(@PathVariable String id){
		Estacionamento est = estacionamentoService.findById(id);
		EstacionamentoDTO resultado = estacionamentoMapper.toEstacionamentoDTO(est);
		return ResponseEntity.ok(resultado);
	}
	
	@PostMapping
	@ApiOperation("Cadastra novo carro")
	public ResponseEntity<EstacionamentoDTO> create(@RequestBody EstacionamentoCreateDTO dto){
		var estacionamentoCreate = estacionamentoMapper.toEstacionamentoCreateDTO(dto);
		var estacionamento = estacionamentoService.create(estacionamentoCreate);
		var resultado = estacionamentoMapper.toEstacionamentoDTO(estacionamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
	}
	
	@PostMapping("/{id}")
	@ApiOperation("Saida do estacionamento")
	public ResponseEntity<EstacionamentoDTO> checkOut(@PathVariable String id){
		Estacionamento estacionamento = estacionamentoService.checkOut(id);
		return ResponseEntity.ok(estacionamentoMapper.toEstacionamentoDTO(estacionamento));
	}
	
	@PutMapping("/{id}")
	@ApiOperation("Atualiza cadastro")
	public ResponseEntity<EstacionamentoDTO> update(@PathVariable String id, @RequestBody EstacionamentoCreateDTO dto){
		var estacionamentoCreate = estacionamentoMapper.toEstacionamentoCreateDTO(dto);
		var estacionamento = estacionamentoService.update(id, estacionamentoCreate);
		var resultado = estacionamentoMapper.toEstacionamentoDTO(estacionamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable String id) {
		estacionamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
