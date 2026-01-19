package com.adorno.modelo;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellidos;
	//En este caso Persona es la propietaria de la relacion. porque alberga el elemento de la relacion
	@OneToOne
	private Direccion direccion;
	@Embedded
	private Poliza poliza;
}
