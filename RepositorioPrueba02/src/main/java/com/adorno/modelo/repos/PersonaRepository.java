package com.adorno.modelo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.entities.Direccion;
import com.adorno.modelo.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	public Optional<Persona> findByDireccion(Direccion direccion);
}
