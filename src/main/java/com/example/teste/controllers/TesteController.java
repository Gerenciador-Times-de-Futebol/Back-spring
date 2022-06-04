package com.example.teste.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

  @GetMapping("/teste")
  public String teste(
    @RequestParam(value = "nome", defaultValue = "world") String nome
  ) {
    return String.format("%s fez o primeiro programa com spring", nome);
  }
}
