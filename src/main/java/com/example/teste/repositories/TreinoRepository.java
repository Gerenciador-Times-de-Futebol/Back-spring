package com.example.teste.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.teste.entity.Treino;

@RepositoryRestResource(exported = false)
public interface TreinoRepository extends JpaRepository<Treino, Long> {

  public List<Treino> findByTipo(String tipo);

  public void deleteByUuid(UUID uuid);

  public Optional<Treino> findByUuid(UUID uuid);
}
