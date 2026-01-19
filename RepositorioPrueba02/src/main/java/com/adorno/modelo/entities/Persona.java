package com.adorno.modelo.entities;

import java.io.Serializable;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

//Solo hace el nonargsConstructor y RequiredArgsConstructor
@Data
@Entity
public class Persona implements Serializable{
	//Cada cambio en Persona crea una forma de serializacion diferente. Por eso es importante
	//estaclecer la version. Si hacemos un cambio en un campo de la clase deberiamos cambiar el serialVersion
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String nombre;
	@NonNull
	private String apellidos;
	//En este caso Persona es la propietaria de la relacion. porque alberga el elemento de la relacion
	@OneToOne
	@NonNull
	private Direccion direccion;
	@Embedded
	@NonNull
	private Poliza poliza;

	
}
