package com.example.teste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.teste.entity.Users;
import com.example.teste.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users currentUser = repository.findByEmail(email);
		UserDetails user = new org.springframework.security.core
		          .userdetails.User(email, currentUser.getSenha(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
		return user;
	}

}
