package com.example.teste.DTO;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsersDTO {
    private String email;
    private String nome;
    private UUID uuid;
}
