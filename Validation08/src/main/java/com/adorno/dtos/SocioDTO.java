package com.adorno.dtos;

import com.adorno.entities.IdentificadorVO;

public record SocioDTO(
		 IdentificadorVO identificador,
		 String nombre,
		 int edad
		) {

}
