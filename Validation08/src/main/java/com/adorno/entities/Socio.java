package com.adorno.entities;

import com.adorno.dtos.SocioDTO;

import jakarta.persistence.Embedded;
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
	//si es vo no puedes usar de Validation
//	@Size(min = 7, max = 7)
	@Embedded
	private IdentificadorVO identificador;
	@NonNull
	@Size(min = 2, max = 30)
	private String nombre;
	@Positive
	@NonNull
	@Max(value = 120)
	private int edad;

}
