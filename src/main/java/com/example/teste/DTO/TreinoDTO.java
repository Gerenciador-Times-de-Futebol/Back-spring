package com.example.teste.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreinoDTO {
  String tipo;
  LocalDate data;
  LocalDateTime horario;
  String local;
  UUID uuid;
}