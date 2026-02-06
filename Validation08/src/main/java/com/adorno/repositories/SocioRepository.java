package com.adorno.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adorno.entities.Socio;

@Repository
public class SocioRepository {

	public List<Socio> socios = new ArrayList<>();
	
	public List<Socio> findAll(){
		return socios;
	}

}
