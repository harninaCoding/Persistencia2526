package com.adorno;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PedidoRepositoryTest {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	PedidoRepository pedidoRepository;

	@Test
	void test() {
		//explicando lo de la transaction
		Persona entity = new Persona(1l,"Juan","Perez");
		//te aseguras de que persistido es el objeto correspondiente
		//asociado a una tupla de la bbdd
		Persona persistido=personaRepository.save(entity);
		Pedido save = pedidoRepository.save(new Pedido(1l,LocalDate.now(),0,persistido));
		Optional<Persona> byIdentificadorExterno = personaRepository.findByIdentificadorExterno(1l);
		//para hacer la busqueda el objeto persona debe estar persistido
		List<Pedido> byPersona = pedidoRepository.findByPersona(byIdentificadorExterno.get());
		System.out.println();
	}
	
	@Test
	void testBidireccional() {
		//yo puedo obtener la lista de pedido mediante la persona
		Persona entity = new Persona(2l,"Juan","Perez");
		//te aseguras de que persistido es el objeto correspondiente
		//asociado a una tupla de la bbdd
		Persona persistido=personaRepository.save(entity);
		//esto es una transaccion: empieza aqui
		Pedido save = pedidoRepository.save(new Pedido(2l,LocalDate.now(),0,persistido));
		///termina aqui
		/// //esto es una transaccion: empieza aqui
		Optional<Persona> optional = personaRepository.findByIdentificadorExterno(2l);
		///termina aqui
		Persona persona = optional.get();
		//en la bidrireccionalidad la consulta sobre los pedidos de una persona es un paso
		//Si no os salen pedidos, dentro de la persona, es porque, por defecto, las relaciones
		//son LAZY. En este caso no tiene acceso porque persona esta detach, o sea, no esta 
		//conectado con la bbdd
		persona.getPedidos();
		System.out.println();
	}

}
