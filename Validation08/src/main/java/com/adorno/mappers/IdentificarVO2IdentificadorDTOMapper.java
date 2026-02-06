package com.adorno.mappers;

import com.adorno.entities.IdentificadorVO;

public class IdentificarVO2IdentificadorDTOMapper implements Mapper<IdentificadorVO,String> {

	@Override
	public IdentificadorVO mapToEntity(String s) {
		return new IdentificadorVO(s);
	}

	@Override
	public String mapToDTO(IdentificadorVO t) {
		return t.getIdentificador();
	}

}
