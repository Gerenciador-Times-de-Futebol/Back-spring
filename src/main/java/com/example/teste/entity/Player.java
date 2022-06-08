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
@Table (name = "players")
public class Player {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	Long id;
	
	@Column(unique=true)
	int camisa;
	
	@Column(unique=true)
	@NotBlank (message = "O nome não pode ser nulo")
	String nome;
	String posicao;
	int idade;
	Date termino_contrato;
	String vinculo;
	double salario;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCamisa() {
		return camisa;
	}
	
	public void setCamisa(int camisa) {
		this.camisa = camisa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPosicao() {
		return posicao;
	}
	
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Date getTermino_contrato() {
		return termino_contrato;
	}

	public void setTermino_contrato(Date termino_contrato) {
		this.termino_contrato = termino_contrato;
	}

	public String getVinculo() {
		return vinculo;
	}
	
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
