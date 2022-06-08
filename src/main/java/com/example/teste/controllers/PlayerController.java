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

import com.example.teste.DTO.PlayerDTO;
import com.example.teste.entity.Player;
import com.example.teste.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	PlayerService service;
	
	@GetMapping
	public List<PlayerDTO> listar() {
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlayerDTO adicionar(@Valid @RequestBody Player player) {
		return service.adicionar(player);
	}
	
	@GetMapping("/search/byName")
	public PlayerDTO buscarPorNome(@Param("nome") String nome) {
		return service.buscarPorNome(nome);
	}
	
	@PutMapping(value="/{nome}")
	public ResponseEntity<Player> atualizar(@PathVariable String nome,
			@RequestBody PlayerDTO dto) {
		Player player = service.atualizar(nome, dto);
		return ResponseEntity.ok(player);
	}
	
	@DeleteMapping(value="/{nome}")
	public ResponseEntity<String> excluir(@PathVariable String nome) {
		PlayerDTO dto = new PlayerDTO();
		dto.setNome(nome);
		try {
			service.excluir(dto);
			return new ResponseEntity<>(nome, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
		}
	}

}
