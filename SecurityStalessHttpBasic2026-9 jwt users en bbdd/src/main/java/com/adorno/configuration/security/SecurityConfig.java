package com.adorno.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.adorno.configuration.security.jwt.JWTUtils;
import com.adorno.configuration.security.jwt.filters.JwtAuthenticationFilter;
import com.adorno.configuration.security.jwt.filters.JwtAuthorizationFilter;
import com.adorno.services.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
	private final JWTUtils jwtUtils;
	private final JwtAuthorizationFilter jwtAuthorizationFilter;
	private final UserDetailsServiceImpl userDetailsServiceImpl;

	public SecurityConfig(JWTUtils jwtUtils, JwtAuthorizationFilter jwtAuthorizationFilter,
			UserDetailsServiceImpl userDetailsServiceImpl) {
		super();
		this.jwtUtils = jwtUtils;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) {

		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
		jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		///////////////////////////////////
		return httpSecurity
				.csrf(config -> config.disable())
				.authorizeHttpRequests(auth -> {
						auth.requestMatchers("/users/hello").permitAll();
						auth.anyRequest().authenticated();
						})
				.sessionManagement(sess -> {
					sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				})
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) {
		AuthenticationManagerBuilder sharedObject = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		sharedObject.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
		return sharedObject.build();
	}
}
