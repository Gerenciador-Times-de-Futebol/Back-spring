package com.example.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.teste.entity.Player;

@RepositoryRestResource(exported=false)
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	Player findByNome(String nome);
	public void deleteByNome(String nome);

}
