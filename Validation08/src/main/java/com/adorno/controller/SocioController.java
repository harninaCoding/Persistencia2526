package com.adorno.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.entities.Socio;
import com.adorno.services.SocioService;

@RestController
@RequestMapping("socios")
public class SocioController {

	private final SocioService socioService;

	public SocioController(SocioService socioService) {
		super();
		this.socioService = socioService;
	}

	@GetMapping("todos")
	public List<Socio> getSocios(){
		return  socioService.getAll();
	}
}
