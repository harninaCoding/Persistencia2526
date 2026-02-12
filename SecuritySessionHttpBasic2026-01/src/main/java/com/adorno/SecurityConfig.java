package com.adorno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//archivo de configuracion
@Configuration
//susitutimos la seguridad por defecto por la que configuramos
@EnableWebSecurity
/*es una anotación que se utiliza en aplicaciones Spring
* para habilitar la configuración de seguridad web. habilita filter chain de
* seguridad, lo que permite personalizar la seguridad de la aplicación web. la
* seguridad entiende sesiones, cookies, cabeceras y peticiones HTTP, y se puede
* configurar para controlar el acceso a los recursos de la aplicación.*/
public class SecurityConfig {

	// Spring le pasa HttpSecurity y sobre esta vamos a  agregar filtros de seguridad
	@Bean
	SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) {
		return httpSecurity
				//queremos ser stateless asi que solemos ignorar esta proteccion
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->{
					auth.requestMatchers("/v1/index2").permitAll();
					auth.anyRequest().authenticated();
				})
				.httpBasic(Customizer.withDefaults())
				.build();
	}
}
