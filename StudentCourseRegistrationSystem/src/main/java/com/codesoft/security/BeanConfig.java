package com.codesoft.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {
	
	//@Autowired
	//private UserDetailsServiceimpl userDetailsService;
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public AuthenticationManager providerManager() {
//	DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
//	authenticationProvider.setUserDetailsService(userDetailsService);
//	authenticationProvider.setPasswordEncoder(encoder());
//	return new ProviderManager(authenticationProvider);
	
	//}
}
