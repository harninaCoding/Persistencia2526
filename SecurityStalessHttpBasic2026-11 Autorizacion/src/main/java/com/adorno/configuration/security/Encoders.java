package com.adorno.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Encoders {

	@Bean
	PasswordEncoder getPasswordEncoder() {
		// contrasena encriptada, dicen que es seguro, ya tu sabes
		return new BCryptPasswordEncoder();
	}
}
