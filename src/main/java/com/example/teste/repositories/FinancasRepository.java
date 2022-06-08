package com.example.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.teste.entity.Financas;

@RepositoryRestResource(exported=false)
public interface FinancasRepository extends JpaRepository<Financas, Long>{

	Financas findByNome(String nome);
	public void deleteByNome(String nome);
}
