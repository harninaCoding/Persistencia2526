package com.adorno.modelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.Persona;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {}
