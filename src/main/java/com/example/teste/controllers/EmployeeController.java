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

import com.example.teste.DTO.EmployeeDTO;
import com.example.teste.entity.Employee;
import com.example.teste.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public List<EmployeeDTO> listar() {
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeDTO adicionar(@Valid @RequestBody Employee employee) {
		return service.adicionar(employee);
	}
	
	@GetMapping("/search/byName")
	public EmployeeDTO buscarPorNome(@Param("nome") String nome) {
		return service.buscarPorNome(nome);
	}
	
	@PutMapping(value="/{nome}")
	public ResponseEntity<EmployeeDTO> atualizar(@PathVariable String nome,
			@RequestBody EmployeeDTO dto) {
		EmployeeDTO employee = service.atualizar(nome, dto);
		return ResponseEntity.ok(employee);
	}
	
	@DeleteMapping(value="/{nome}")
	public ResponseEntity<String> excluir(@PathVariable String nome) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setNome(nome);
		try {
			service.excluir(dto);
			return new ResponseEntity<>(nome, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		}
	}

}
