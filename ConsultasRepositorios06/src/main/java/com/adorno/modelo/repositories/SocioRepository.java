package com.adorno.modelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.entities.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {

}
