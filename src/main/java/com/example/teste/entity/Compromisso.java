package com.example.teste.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compromisso")
public class Compromisso {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Long id;

  @Type(type = "org.hibernate.type.UUIDCharType")
  UUID uuid = UUID.randomUUID();

  @Column(unique = true)
  LocalDate data;
  LocalDateTime horario;
  String anfitriao;
  String visitante;
  String local;
  String torneio;
}
