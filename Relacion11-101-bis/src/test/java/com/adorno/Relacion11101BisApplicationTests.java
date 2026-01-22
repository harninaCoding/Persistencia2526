package com.adorno;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Direccion;
import com.adorno.modelo.Persona;
import com.adorno.modelo.Poliza;
import com.adorno.modelo.repositories.DireccionRepository;
import com.adorno.modelo.repositories.PersonaRepository;

@SpringBootTest
class Relacion11101BisApplicationTests {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DireccionRepository direccionRepository;

	@Test
	void contextLoads() {
		// Para decirle a Spring que me inyecte la instancia de PersonaRepository

		Direccion direccion = new Direccion("sol", 1);
		Poliza poliza = new Poliza(1l, LocalDate.now());
		// primer error intentar grabar un objeto que no existe en la bbdd
		// en este caso direccion
		// direccion no tiene id hasta que no se graba en la bbdd (persiste) y ese id es
		// necesario para
		// que funcione como clave externa en Persona
		direccion = direccionRepository.save(direccion);
		Persona persona = new Persona("luis", "panfleto", direccion, poliza);
		personaRepository.save(persona);
		List<Persona> all = personaRepository.findAll();
		System.out.println(all);
		//Porque es bueno, a veces la direccionalidad
		Optional<Direccion> byId = direccionRepository.findById(1l);
		Direccion direccion2 = byId.get();
		System.out.println(direccion2.getPersona());
		Persona persona2 = personaRepository.findById(1L).get();
		System.out.println(persona2.getDireccion());
	}

}
