package com.example.teste.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.teste.DTO.EmployeeDTO;
import com.example.teste.entity.Employee;
import com.example.teste.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	@Autowired
	private ModelMapper mapper;
	
	public EmployeeDTO adicionar(Employee employee) {
		return mapper.map(repository.save(employee), EmployeeDTO.class);
	}
	
	public List<EmployeeDTO> listarTodos() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		for (Employee employee: repository.findAll()) {
			list.add(mapper.map(employee, EmployeeDTO.class));
		}
		
		return list;
	}
	
	public EmployeeDTO buscarPorNome(String nome) {
		Employee employee = repository.findByNome(nome);
		EmployeeDTO dto = mapper.map(employee, EmployeeDTO.class);
		return dto;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public EmployeeDTO atualizar(String nome, EmployeeDTO dto) {
		Employee employee = repository.findByNome(nome);
		
		employee.setData_nascimento(dto.getData_nascimento());
		employee.setDepartamento(dto.getDepartamento());
		employee.setFuncao(dto.getFuncao());
		employee.setNome(dto.getNome());
		employee.setSalario(dto.getSalario());
		
		return mapper.map(repository.save(employee), EmployeeDTO.class);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void excluir(EmployeeDTO dto) {
		repository.deleteByNome(dto.getNome());
	}

}
