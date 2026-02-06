package com.adorno.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.mappers.IdentificarVO2IdentificadorDTOMapper;
import com.adorno.mappers.Socio2SocioDTOMapper;

@Configuration
public class MappersConfiguration {

	@Bean 
	public IdentificarVO2IdentificadorDTOMapper getIdentifierMapper() {
		return new IdentificarVO2IdentificadorDTOMapper();
	}
	@Bean
	public Socio2SocioDTOMapper getSocioMapper() {
		return new Socio2SocioDTOMapper();
		
	}
}
