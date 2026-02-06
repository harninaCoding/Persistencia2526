package com.adorno.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adorno.dtos.SocioDTO;
import com.adorno.entities.Socio;
import com.adorno.mappers.Socio2SocioDTOMapper;
import com.adorno.repositories.SocioRepository;

@Service
public class SocioService {

	private final SocioRepository socioRepository;
	private final Socio2SocioDTOMapper mapper;

	public SocioService(SocioRepository socioRepository, Socio2SocioDTOMapper mapper) {
		super();
		this.socioRepository = socioRepository;
		this.mapper = mapper;
	}

	public List<Socio> getAll() {
		return socioRepository.findAll();
	}

	public boolean add(SocioDTO socio) {
		Socio socioEntity = mapper.mapToEntity(socio);
		if (!socioRepository.existsByIdentificador(socioEntity.getIdentificador())) {
			socioRepository.save(socioEntity);
			return true;
		}
		return false;
	}
}
