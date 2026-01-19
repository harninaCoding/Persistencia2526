package com.adorno.modelo.repos;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.entities.Direccion;
import com.adorno.modelo.entities.Persona;
import com.adorno.modelo.entities.Poliza;

@SpringBootTest
class PersonaRepositoryTest {

	// Para decirle a Spring que me inyecte la instancia de PersonaRepository
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DireccionRepository direccionRepository;

	@Test
	void test() {
		Direccion direccion = new Direccion("sol", 1);
		Poliza poliza = new Poliza(1l, LocalDate.now());
		//primer error intentar grabar un objeto que no existe en la bbdd
		//en este caso direccion
		//direccion no tiene id hasta que no se graba en la bbdd (persiste) y ese id es necesario para 
		//que funcione como clave externa en Persona
		direccion = direccionRepository.save(direccion);
		Persona persona = new Persona("luis", "panfleto", direccion, poliza);
		personaRepository.save(persona);
	}
}
