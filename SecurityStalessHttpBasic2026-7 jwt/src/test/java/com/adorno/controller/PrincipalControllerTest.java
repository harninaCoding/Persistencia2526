package com.adorno.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import jakarta.transaction.Transactional;

@SpringBootTest
/// Permite usar MockMvc en un test de integración
@AutoConfigureMockMvc(addFilters = false)
//Limpia la base de datos después de cada test para no ensuciar
@Transactional
class PrincipalControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
