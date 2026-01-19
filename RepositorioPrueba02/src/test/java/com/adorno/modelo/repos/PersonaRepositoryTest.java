package com.adorno.modelo.repos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PersonaRepositoryTest {
	
	//Para decirle a Spring que me inyecte la instancia de PersonaRepository
	@Autowired
	PersonaRepository personaRepository;

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
