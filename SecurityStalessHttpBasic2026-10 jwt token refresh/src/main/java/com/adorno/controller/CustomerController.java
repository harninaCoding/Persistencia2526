package com.adorno.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.services.AccessService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("v1")
public class CustomerController {
	private final AccessService accessService;

	public CustomerController(AccessService accessService) {
		super();
		this.accessService = accessService;
	}

	// Aqui aplicamos la seguridad
	@GetMapping("index")
	public String index() {
		return "hello secured";
	}

//	aqui no seguridad
	@GetMapping("index2")
	public String index2() {
		return "hello unsecured";
	}

	@PostMapping("refresh")
	public ResponseEntity<?> refresh(HttpServletRequest request) {
		return accessService.refreshToken(request);
	}
}
