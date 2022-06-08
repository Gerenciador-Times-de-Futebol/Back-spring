package com.example.teste.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "financas")
public class Financas {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	Long id;
	
	@Column(unique=true)
	@NotBlank (message = "O nome não pode ser nulo")
	String nome;
	double valor;
	String tipo;
	Date dataFinancas;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public Date getDataFinancas() {
		return dataFinancas;
	}
	
	public void setDataFinancas(Date dataFinancas) {
		this.dataFinancas = dataFinancas;
	}
	
}
