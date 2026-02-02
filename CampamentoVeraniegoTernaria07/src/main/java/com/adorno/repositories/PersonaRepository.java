package com.adorno.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	public Optional<Persona> findByDNI(String dni);

}
