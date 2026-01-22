package com.adorno.modelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.Direccion;


@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
