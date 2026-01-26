package com.adorno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelacionNm03ApplicationTests {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	PartidoRepository partidoRepository;

	@Test
	void contextLoads() {
		Persona entity = new Persona("Ana", "Lopez");
		Persona persona = personaRepository.save(entity);
		Partido partido1 = new Partido("Socuellamos", "Alcantarilla");
		Partido partido = partidoRepository.save(partido1);
		//	funciona en la propietaria de la relacion
		 partido.getPersonas().add(persona);
		// necesitamos persistir para que funcione en la bbdd
		 partidoRepository.save(partido);
		// veremos que pasa

		// Probamos si funcioan desde Persona
		System.out.println();
	}

}
