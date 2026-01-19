package com.adorno.modelo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.entities.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
