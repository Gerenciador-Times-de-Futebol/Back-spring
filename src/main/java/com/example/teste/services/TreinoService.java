package com.example.teste.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.teste.DTO.TreinoDTO;
import com.example.teste.entity.Treino;
import com.example.teste.repositories.TreinoRepository;

@Service
public class TreinoService {

  @Autowired
  TreinoRepository repository;

  @Autowired
  private ModelMapper mapper;

  public TreinoDTO adicionar(Treino treino) {

    return mapper.map(repository.save(treino), TreinoDTO.class);
  }

  public List<TreinoDTO> listarTodos() {
    List<TreinoDTO> list = repository.findAll().stream().map(treino -> mapper.map(treino, TreinoDTO.class))
        .collect(Collectors.toList());

    return list;
  }

  public List<TreinoDTO> buscarPorTipo(String tipo) {

    List<TreinoDTO> treinos = repository.findByTipo(tipo).stream().map(treino -> mapper.map(treino, TreinoDTO.class))
        .collect(Collectors.toList());

    return treinos;
  }

  public Optional<TreinoDTO> atualizar(String uuid, TreinoDTO dto) {
    Optional<Treino> treino = repository.findByUuid(UUID.fromString(uuid));
    if (treino.isEmpty()) {
      return Optional.empty();
    }

    treino.get().setData(dto.getData());
    treino.get().setHorario(dto.getHorario());
    treino.get().setLocal(dto.getLocal());
    treino.get().setTipo(dto.getTipo());

    return Optional.of(mapper.map(repository.save(treino.get()), TreinoDTO.class));
  }

  @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
  public void excluir(String uuid) {
    repository.deleteByUuid(UUID.fromString(uuid));
  }

  public Optional<TreinoDTO> findByUuid(String uuid) {
    Optional<Treino> treino = repository.findByUuid(UUID.fromString(uuid));
    System.out.println();
    if (treino.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(mapper.map(treino.get(), TreinoDTO.class));
  }

}
