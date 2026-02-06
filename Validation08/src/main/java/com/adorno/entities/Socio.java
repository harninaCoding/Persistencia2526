package com.adorno.entities;

import com.adorno.dtos.SocioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	// un valor de 7 caracteres, los dos primeros letras y los ultimos cinco
	// numeros. El numero a partir de 00120
	@NonNull
	@Size(min = 7, max = 7)
	private IdentificadorVO identificador;
	@Size(min = 2, max = 30)
	private String nombre;
	@Positive
	@Max(value = 120)
	private int edad;

	public Socio(SocioDTO dto) {
		this.identificador = dto.identificador();
////		yo no lo hago asi pero os lo podeis encontrar
	}

}
