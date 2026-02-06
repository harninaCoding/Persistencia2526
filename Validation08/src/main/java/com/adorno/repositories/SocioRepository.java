package com.adorno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.entities.IdentificadorVO;
import com.adorno.entities.Socio;


@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {

	
	public boolean existsByIdentificador(IdentificadorVO identificador);

}
