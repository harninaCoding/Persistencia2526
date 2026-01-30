package com.adorno.modelo.repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.entities.Socio;

@SpringBootTest
class SocioRepositoryTest {

	@Autowired
	SocioRepository socioRepository;
	@Autowired
	List<Socio> socios;
	
	
	@Test
	void test() {
//		socioRepository.saveAll(socios);
		Optional<Socio> byId = socioRepository.findById(11l);
		assertFalse(byId.isEmpty());
	}

}
