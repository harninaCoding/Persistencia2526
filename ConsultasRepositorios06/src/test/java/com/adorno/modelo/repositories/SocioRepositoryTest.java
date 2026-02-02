package com.adorno.modelo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		///
//		Optional<Socio> byId = socioRepository.findById(11l);
//		assertFalse(byId.isEmpty());
		////
//		List<Socio> all = socioRepository.findAll();
//		float saldo = 199f;
//		List<Socio> allBySaldoGreaterThan = socioRepository.findAllBySaldoGreaterThan(saldo);
//		List<Socio> allBySaldoLessThanEqual = socioRepository.findAllBySaldoLessThanEqual(saldo);
//		assertEquals(all.size(),allBySaldoGreaterThan.size()+allBySaldoLessThanEqual.size());
		////
//		List<Socio> allBySaldoLessThanAndNombreStartingWith = socioRepository.findAllBySaldoLessThanAndNombreStartingWith(200, "A");
//		assertEquals(1, allBySaldoLessThanAndNombreStartingWith.size());
		///
//		assertTrue(socioRepository.findFirstByApellidosEndingWith("z").isPresent());
		//esepcificar una fecha concreta
//		LocalDate fecha = LocalDate.of(1999, 1, 1);
//		LocalDate fechad = LocalDate.of(1999, 8, 1);
//		assertTrue(fecha.isBefore(fechad));
	}

	@Test
	void testquery() {
		List<Socio> queryOne = socioRepository.findQueryOne();
		List<Socio> allByApellidosStartingWith = socioRepository.findAllByApellidosStartingWith("S");
		assertEquals(queryOne,allByApellidosStartingWith);
		List<Socio> all = socioRepository.findAll();
		float saldo = 100f;
		String ending = "z";
		List<Socio> allBySaldoGreaterThanAndApellidosEndingWith = socioRepository.findAllBySaldoGreaterThanAndApellidosEndingWith(saldo,ending);
		List<Socio> facingAllBySaldoGreaterThanAndApellidosEndingWith = socioRepository.findFacingAllBySaldoGreaterThanAndApellidosEndingWith(saldo, ending);
		assertEquals(all.size(), allBySaldoGreaterThanAndApellidosEndingWith.size()+facingAllBySaldoGreaterThanAndApellidosEndingWith.size());
	}
}
