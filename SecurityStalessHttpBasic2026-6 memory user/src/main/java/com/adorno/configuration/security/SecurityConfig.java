package com.adorno.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SecurityConfig {

//	private final UserDetailsService getUserDetailsService;
//
//	SecurityConfig(UserDetailsService getUserDetailsService) {
//		this.getUserDetailsService = getUserDetailsService;
//	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		return httpSecurity.csrf(config -> config.disable()).authorizeHttpRequests(auth -> {
			auth.requestMatchers("/users/hello").permitAll();
			auth.anyRequest().authenticated();
		})
				// Lo siguiente hace tres cosas:
				// 1.- Evita crear cookies de session
				// 2.- evita guardar en RAM
				// 3.- pedir el passport en cada endpoint
				.sessionManagement(sess -> {
					sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				}).httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	UserDetailsService getUserDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		UserDetails userDetails = User.withUsername("Dios").password("1234").roles().build();
		manager.createUser(userDetails);
		return manager;
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return PlainTextPasswordEncoder.getInstance();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) {
		AuthenticationManagerBuilder sharedObject = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		sharedObject.userDetailsService(getUserDetailsService()).passwordEncoder(passwordEncoder);
		return sharedObject.build();
	}
}
