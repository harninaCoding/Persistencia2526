package com.adorno.repositories;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Persona;
import com.adorno.repositories.PersonaRepository;

@SpringBootTest
class PersonaRepositoryTest {
	
	@Autowired PersonaRepository personaRepository;

	@Test
	void test() {
		Persona p=new Persona("12345678A","Juan Perez");
		personaRepository.save(p);
		Persona otro=new Persona("12345678A","Elias Jimenez");
		//try() solo en recursos autocloseables
		try{
			personaRepository.save(otro);
			fail("Deberia haber saltado una excepcion por duplicar DNI");
		}catch(Exception e) {
			e.printStackTrace();
            System.out.println("Ha saltado la excepcion por duplicar DNI como se esperaba");
        }
	}

}
