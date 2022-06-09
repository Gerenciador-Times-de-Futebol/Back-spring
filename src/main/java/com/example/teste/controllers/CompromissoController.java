package com.example.teste.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.DTO.CompromissoDTO;
import com.example.teste.entity.Compromisso;
import com.example.teste.services.CompromissoService;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController {

  @Autowired
  CompromissoService service;

  @GetMapping
  public List<CompromissoDTO> listar() {
    return service.listarTodos();
  }

  @PostMapping
  public CompromissoDTO adicionar(@RequestBody Compromisso compromisso) {
    return service.adicionar(compromisso);
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<CompromissoDTO> atualizar(@PathVariable String uuid, @RequestBody CompromissoDTO dto) {
    Optional<CompromissoDTO> compromisso = service.atualizar(uuid, dto);
    if (compromisso.isPresent())
      return ResponseEntity.ok(compromisso.get());
    else
      return ResponseEntity.badRequest().build();
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<CompromissoDTO> getByUuid(@PathVariable String uuid) {
    Optional<CompromissoDTO> compromisso = service.findByUuid(uuid);
    System.out.println(uuid);
    System.out.println(compromisso);
    if (compromisso.isPresent())
      return ResponseEntity.ok(compromisso.get());
    else
      return ResponseEntity.badRequest().build();
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<String> excluir(@PathVariable String uuid) {
    try {
      service.excluir(uuid);
      return new ResponseEntity<>(uuid, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }
  }
}
