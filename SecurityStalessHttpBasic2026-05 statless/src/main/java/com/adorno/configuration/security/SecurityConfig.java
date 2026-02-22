package com.adorno.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		return httpSecurity
					.csrf(config -> config.disable())
					.authorizeHttpRequests(auth->{
						auth.requestMatchers("/users/hello").permitAll();
						auth.anyRequest().authenticated();
					})
					//Lo siguiente hace tres cosas:
					//1.- Evita crear cookies de session
					//2.- evita guardar en RAM
					//3.- pedir el passport en cada endpoint
					.sessionManagement(sess -> {
						sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
					})
					.httpBasic(Customizer.withDefaults()).build();
	}
}
