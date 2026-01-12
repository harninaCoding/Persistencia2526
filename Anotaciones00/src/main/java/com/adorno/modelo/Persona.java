package com.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {
	@Id
	private Long id;
	private String nombre;
	private String apellidos;
}
