package com.example.teste.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.teste.entity.Compromisso;

@RepositoryRestResource(exported = false)
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {

  public void deleteByUuid(UUID uuid);

  public Optional<Compromisso> findByUuid(UUID uuid);
}