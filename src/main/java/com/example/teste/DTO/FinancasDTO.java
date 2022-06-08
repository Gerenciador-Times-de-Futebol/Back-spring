package com.example.teste.DTO;

import java.util.Date;

public class FinancasDTO {
	
	String nome;
	double valor;
	String tipo;
	Date dataFinancas;
	
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
