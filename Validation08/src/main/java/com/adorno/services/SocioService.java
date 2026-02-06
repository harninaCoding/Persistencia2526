package com.adorno.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adorno.entities.Socio;
import com.adorno.repositories.SocioRepository;

@Service
public class SocioService {

	private final SocioRepository socioRepository;

	public SocioService(SocioRepository socioRepository) {
		super();
		this.socioRepository = socioRepository;
	}

	public List<Socio> getAll() {
		return socioRepository.findAll();
	}
}
