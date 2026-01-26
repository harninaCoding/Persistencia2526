package com.adorno;

import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Para crear una clave que si permita la busqueda del elemento sin usar el id
	//Basic no afecta  a la bbdd
	@Basic(optional = false)
	// caracteristicas que si son de la bbdd
	@Column(nullable = false, unique = true)
	private Long identificadorExterno;
	private String nombre;
	private String apellidos;
	
	
	public Persona(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	

	public Persona() {
		super();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Persona [id=" + identificadorExterno + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellidos, identificadorExterno, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos)
				&& Objects.equals(identificadorExterno, other.identificadorExterno)
				&& Objects.equals(nombre, other.nombre);
	}

}
