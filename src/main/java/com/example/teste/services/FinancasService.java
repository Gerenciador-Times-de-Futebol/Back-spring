package com.example.teste.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.teste.DTO.FinancasDTO;
import com.example.teste.entity.Financas;
import com.example.teste.repositories.FinancasRepository;

@Service
public class FinancasService {

	@Autowired
	FinancasRepository repository;

	@Autowired
	private ModelMapper mapper;
	
	public FinancasDTO adicionar(Financas financas) {
		return mapper.map(repository.save(financas), FinancasDTO.class);
	}
	
	public List<FinancasDTO> listarTodos() {
		List<FinancasDTO> list = new ArrayList<FinancasDTO>();
		for (Financas financas: repository.findAll()) {
			list.add(mapper.map(financas, FinancasDTO.class));
		}
		
		return list;
	}
	
	public FinancasDTO buscarPorNome(String nome) {
		Financas financas = repository.findByNome(nome);
		FinancasDTO dto = mapper.map(financas, FinancasDTO.class);
		return dto;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public Financas atualizar(String nome, FinancasDTO dto) {
		Financas financas = repository.findByNome(nome);
		
		financas.setNome(dto.getNome());
		financas.setDataFinancas(dto.getDataFinancas());
		financas.setTipo(dto.getTipo());
		financas.setValor(dto.getValor());
		
		return repository.save(financas);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void excluir(FinancasDTO dto) {
		repository.deleteByNome(dto.getNome());
	}
}
