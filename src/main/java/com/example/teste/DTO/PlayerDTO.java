package com.example.teste.DTO;

import java.util.Date;

public class PlayerDTO {
	
	private int camisa;
	private String nome;
	private String posicao;
	private int idade;
	private Date termino_contrato;
	private String vinculo;
	private double salario;
	
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

}
