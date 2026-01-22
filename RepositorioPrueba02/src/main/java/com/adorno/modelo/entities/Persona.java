package com.adorno.modelo.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//Solo hace el nonargsConstructor y RequiredArgsConstructor
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="personaje")
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
	//cuando la politica de integridad referencial, que por defecto es restrict, se puede modelar
	//como cascade y para que tipos de cascade
	//fetch cmo queremos que ejecute la consulta en el caso de una relacion
	//opr ejemplo en un 1:n si queremos que traiga todos los objetos N relacionados con el 1. usamos
	//EAGER. si no queremos que traiga esos objetos hasta que no se soliciten con get(), se usa LAZY
	// por defcto es LAZY. Cuidado porque solo se respeta dentro de una transaccion.
	//Si termina la transaccion xrepo.find...(); y ha sido lazy ya no tenemos acceso a la parte del N
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional = false )
	@NonNull
	//todo lo que sea *colum* es una orden a la BBDD
	@JoinColumn(name="direccioncilla")
	private Direccion direccion;
	@Embedded
	@NonNull
	private Poliza poliza;

	
}
