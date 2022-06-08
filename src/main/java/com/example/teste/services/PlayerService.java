package com.example.teste.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.teste.DTO.PlayerDTO;
import com.example.teste.entity.Player;
import com.example.teste.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository repository;

	@Autowired
	private ModelMapper mapper;
	
	public PlayerDTO adicionar(Player player) {
		return mapper.map(repository.save(player), PlayerDTO.class);
	}
	
	public List<PlayerDTO> listarTodos() {
		List<PlayerDTO> list = new ArrayList<PlayerDTO>();
		for (Player player: repository.findAll()) {
			list.add(mapper.map(player, PlayerDTO.class));
		}
		
		return list;
	}
	
	public PlayerDTO buscarPorNome(String nome) {
		Player player = repository.findByNome(nome);
		PlayerDTO dto = mapper.map(player, PlayerDTO.class);
		return dto;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public PlayerDTO atualizar(String nome, PlayerDTO dto) {
		Player player = repository.findByNome(nome);
		
		player.setCamisa(dto.getCamisa());
		player.setIdade(dto.getIdade());
		player.setNome(dto.getNome());
		player.setPosicao(dto.getPosicao());
		player.setSalario(dto.getSalario());
		player.setTermino_contrato(dto.getTermino_contrato());
		player.setVinculo(dto.getVinculo());
		
		return mapper.map(repository.save(player), PlayerDTO.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void excluir(PlayerDTO dto) {
		repository.deleteByNome(dto.getNome());
	}
	
}
