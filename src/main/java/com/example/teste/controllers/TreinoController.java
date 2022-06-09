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

import com.example.teste.DTO.TreinoDTO;
import com.example.teste.entity.Treino;
import com.example.teste.services.TreinoService;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

  @Autowired
  TreinoService service;

  @GetMapping
  public List<TreinoDTO> listar() {
    return service.listarTodos();
  }

  @PostMapping
  public TreinoDTO adicionar(@RequestBody Treino treino) {
    return service.adicionar(treino);
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<TreinoDTO> atualizar(@PathVariable String uuid, @RequestBody TreinoDTO dto) {
    Optional<TreinoDTO> treino = service.atualizar(uuid, dto);
    if (treino.isPresent())
      return ResponseEntity.ok(treino.get());
    else
      return ResponseEntity.badRequest().build();
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<TreinoDTO> getByUuid(@PathVariable String uuid) {
    Optional<TreinoDTO> treino = service.findByUuid(uuid);
    System.out.println(uuid);
    System.out.println(treino);
    if (treino.isPresent())
      return ResponseEntity.ok(treino.get());
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
