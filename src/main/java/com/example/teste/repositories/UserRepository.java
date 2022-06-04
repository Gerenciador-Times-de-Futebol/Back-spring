package com.example.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.teste.entity.Users;

@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    public void deleteByEmail(String email);
}
    

