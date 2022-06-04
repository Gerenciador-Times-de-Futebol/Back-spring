package com.example.teste.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.teste.DTO.UsersDTO;
import com.example.teste.entity.Users;
import com.example.teste.repositories.UserRepository;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UsersDTO findByEmail(String email) {
        Users user = userRepository.findByEmail(email);
        return modelMapper.map(user, UsersDTO.class);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public UsersDTO save(Users users) {
        Users user = new Users();
        user.setEmail(users.getEmail());
        user.setNome(users.getNome());
        user.setSenha(users.getSenha());
        user.setUuid(users.getUuid());
        return modelMapper.map(userRepository.save(user), UsersDTO.class);

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteByEmail(UsersDTO users) {
        userRepository.deleteByEmail(users.getEmail());
    }
}
