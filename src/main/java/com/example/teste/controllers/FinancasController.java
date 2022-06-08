package com.example.teste.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.DTO.FinancasDTO;
import com.example.teste.entity.Financas;
import com.example.teste.services.FinancasService;


@RestController
@RequestMapping("/financas")
public class FinancasController {
	
	@Autowired
	FinancasService service;
	
	@GetMapping
	public List<FinancasDTO> listar() {
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FinancasDTO adicionar(@Valid @RequestBody Financas financas) {
		return service.adicionar(financas);
	}
	
	@GetMapping("/search/byName")
	public FinancasDTO buscarPorNome(@Param("nome") String nome) {
		return service.buscarPorNome(nome);
	}
	
	@PutMapping(value="/{nome}")
	public ResponseEntity<FinancasDTO> atualizar(@PathVariable String nome,
			@RequestBody FinancasDTO dto) {
		FinancasDTO financas = service.atualizar(nome, dto);
		return ResponseEntity.ok(financas);
	}
	
	@DeleteMapping(value="/{nome}")
	public ResponseEntity<String> excluir(@PathVariable String nome) {
		FinancasDTO dto = new FinancasDTO();
		dto.setNome(nome);
		try {
			service.excluir(dto);
			return new ResponseEntity<>(nome, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		}
	}
}

