package com.example.teste.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teste.DTO.CompromissoDTO;
import com.example.teste.entity.Compromisso;
import com.example.teste.repositories.CompromissoRepository;

@Service
public class CompromissoService {

  @Autowired
  CompromissoRepository repository;

  @Autowired
  private ModelMapper mapper;

  public CompromissoDTO adicionar(Compromisso compromisso) {

    return mapper.map(repository.save(compromisso), CompromissoDTO.class);
  }

  public List<CompromissoDTO> listarTodos() {
    List<CompromissoDTO> list = repository.findAll().stream()
        .map(compromisso -> mapper.map(compromisso, CompromissoDTO.class))
        .collect(Collectors.toList());

    return list;
  }

  public Optional<CompromissoDTO> atualizar(String uuid, CompromissoDTO dto) {
    Optional<Compromisso> compromisso = repository.findByUuid(UUID.fromString(uuid));
    if (compromisso.isEmpty()) {
      return Optional.empty();
    }

    compromisso.get().setData(dto.getData());
    compromisso.get().setHorario(dto.getHorario());
    compromisso.get().setLocal(dto.getLocal());
    compromisso.get().setAnfitriao(dto.getAnfitriao());
    compromisso.get().setTorneio(dto.getTorneio());
    compromisso.get().setVisitante(dto.getVisitante());

    return Optional.of(mapper.map(repository.save(compromisso.get()), CompromissoDTO.class));
  }

  public void excluir(String uuid) {
    repository.deleteByUuid(UUID.fromString(uuid));
  }

  public Optional<CompromissoDTO> findByUuid(String uuid) {
    Optional<Compromisso> compromisso = repository.findByUuid(UUID.fromString(uuid));
    System.out.println();
    if (compromisso.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(mapper.map(compromisso.get(), CompromissoDTO.class));
  }

}
