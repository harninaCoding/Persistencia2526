package com.adorno.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.dtos.SocioDTO;
import com.adorno.entities.Socio;
import com.adorno.services.SocioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("socios")
public class SocioController {

	private final SocioService socioService;

	public SocioController(SocioService socioService) {
		super();
		this.socioService = socioService;
	}

	@PostMapping("nuevo")
	public boolean addSocio(@Valid @RequestBody SocioDTO socio) {
		return socioService.add(socio);
		
	}
	@GetMapping("todos")
	public List<Socio> getSocios(){
		return  socioService.getAll();
	}
}
