package com.example.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.DTO.UsersDTO;
import com.example.teste.entity.Users;
import com.example.teste.repositories.UserRepository;
import com.example.teste.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    UserRepository userRepository;
    @Autowired
    UsersService usersService;
    
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/search/byEmail")
    public UsersDTO getByEmail(@Param("email") String email) {
        return usersService.findByEmail(email);
    }

    @PostMapping
    public ResponseEntity<UsersDTO> save(@RequestBody Users users) {
        UsersDTO user = usersService.save(users);
        if(user == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

    }
    
    @PutMapping(value="/{email}")
	public ResponseEntity<UsersDTO> atualizar(@PathVariable String email,
			@RequestBody UsersDTO dto) {
    	UsersDTO user = usersService.atualizar(email, dto);
		return ResponseEntity.ok(user);
	}

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<String> deleteByEmail(@PathVariable String email) {
        UsersDTO user = new UsersDTO();
        user.setEmail(email);
        try{
            usersService.deleteByEmail(user);
            return new ResponseEntity<>(email, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
