package com.adorno.mappers;

import com.adorno.dtos.SocioDTO;
import com.adorno.entities.Socio;

public class Socio2SocioDTOMapper implements Mapper<Socio, SocioDTO> {


	@Override
	public Socio mapToEntity(SocioDTO s) {
		return new Socio;
	}

	@Override
	public SocioDTO mapToDTO(Socio t) {
		// TODO Auto-generated method stub
		return null;
	}

}
