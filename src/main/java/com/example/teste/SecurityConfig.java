package com.example.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.teste.filters.AuthorizationFilter;
import com.example.teste.filters.LoginFilter;
import com.example.teste.services.UserDetailsServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	throws Exception { 
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
		.antMatchers(HttpMethod.POST, "/users").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(new LoginFilter("/login",authenticationManager()),	UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new AuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
