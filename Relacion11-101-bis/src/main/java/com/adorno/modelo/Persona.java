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
	public Persona(String nombre, String apellidos, Direccion direccion, Poliza poliza) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.poliza = poliza;
	}
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", poliza="
				+ poliza + "]";
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	
}
