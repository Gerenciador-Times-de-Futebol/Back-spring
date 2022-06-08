package com.example.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.teste.entity.Employee;

@RepositoryRestResource(exported=false)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByNome(String nome);
	public void deleteByNome(String nome);

}
