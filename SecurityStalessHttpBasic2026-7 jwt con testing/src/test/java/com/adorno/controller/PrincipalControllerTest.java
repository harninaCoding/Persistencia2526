package com.adorno.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.adorno.model.LoginRequest;
import com.adorno.model.dtos.UserCreateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

@SpringBootTest
/// Permite usar MockMvc en un test de integración
@AutoConfigureMockMvc(addFilters = true)
//Limpia la base de datos después de cada test para no ensuciar
@Transactional
class PrincipalControllerTest {
	@Autowired
	private MockMvc mockMvc;

	private String token;

	@Test
	void testLogin02() throws UnsupportedEncodingException, Exception {
		////////////////////// 1º Haciendo Login con DIOS
		// Este es un objeto para poder crear el string creado por nosotros
		LoginRequest login = new LoginRequest("Dios", "123AAA.www4");
		// convierte el objeto en un string correcto
		String json = new ObjectMapper().writeValueAsString(login);
		// llmada al login
		String response = mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk())
				// aqui se recoge el body
				.andReturn().getResponse().getContentAsString();
		// asi extraigo el token
		String token = com.jayway.jsonpath.JsonPath.read(response, "$.token");
		assertNotNull(token);

		///////////////////// 2º Creando un nuevo usuario Teo para poder encontrarlo despues
		String string = "Teo";
		String email = "yo@yo.es";
		String password = "123AAA.www4";
		response = mockMvc
				.perform(post("/users/new").header("Authorization", "Bearer " + token)
						.contentType(MediaType.APPLICATION_JSON)
						// Observa que entra con la forma que tenga en el endpoint
						.content(new ObjectMapper()
								.writeValueAsString(new UserCreateDTO(email, string, password, "ADMIN"))))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		/////////////////////////////////////3º Para probar si tengo acceso con el token
		response = mockMvc.perform(get("/users/helloSecured").header("Authorization", "Bearer " + token))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertNotNull(response);
		
		/////////////////////////////////4º para probar si no tengo acceso a un endpoint que el filtro no me permite
		response = mockMvc.perform(get("/users/hello").header("Authorization", "Bearer " + token))
				.andExpect(status().isForbidden()).andReturn().getResponse().getContentAsString();
		assertTrue(response.isEmpty());

		////////////////////////// 5º Buscar a Teo para saber si se creo bien
//		String string = "Teo";
//		String email = "yo@yo.es";
//		String password = "123AAA.www4";
		response = mockMvc
				.perform(get("/users/user").param("username", string).header("Authorization", "Bearer " + token)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		// obtener un campo del json
		String name = com.jayway.jsonpath.JsonPath.read(response, "$.username");
		assertEquals(string, name);
		String responseEmail = com.jayway.jsonpath.JsonPath.read(response, "$.email");
		assertEquals(email, responseEmail);

		////////////// 6º error si intento repetir username porque rompe toda la sesion de
		////////////// hibernate para el resto del test
//		try {
//			response = mockMvc
//					.perform(post("/users/new").header("Authorization", "Bearer " + token)
//							.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper()
//									// Observa que entra con la forma que tenga en el endpoint
//									.writeValueAsString(new UserCreateDTO(email, string, password, "ADMIN"))))
//					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//			fail();
//		} catch (Exception e) {
//			assertTrue(true);
//		}
		///////////////////// 7º compruebo si he dado de alta al nuevo con login
		login = new LoginRequest(string, password);
		// convierte el objeto en un string correcto
		json = new ObjectMapper().writeValueAsString(login);
		// llmada al login
		response = mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk())
				// aqui se recoge el body
				.andReturn().getResponse().getContentAsString();
		// asi extraigo el token
		token = com.jayway.jsonpath.JsonPath.read(response, "$.token");
		assertNotNull(token);

	}

}
