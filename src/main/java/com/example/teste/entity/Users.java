package com.example.teste.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    private String nome;
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
    private UUID uuid;

    public Users() {
        this.uuid = UUID.randomUUID();
    }

}
