package com.adorno.mappers;

import com.adorno.dtos.SocioDTO;
import com.adorno.entities.Socio;

public class Socio2SocioDTOMapper implements Mapper<Socio, SocioDTO> {


	private IdentificarVO2IdentificadorDTOMapper mapper= new IdentificarVO2IdentificadorDTOMapper();

	@Override
	public Socio mapToEntity(SocioDTO s) {
		return new Socio(
				mapper.mapToEntity(s.identificador()),
				s.nombre(),s.edad()
				);
	}

	@Override
	public SocioDTO mapToDTO(Socio t) {
		return new SocioDTO(mapper.mapToDTO(t.getIdentificador()), t.getNombre(), t.getEdad());
	}

}
