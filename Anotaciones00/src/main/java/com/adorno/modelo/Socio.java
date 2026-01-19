package com.adorno.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Socio {
	// si pongo solo @Id yo tengo que poner el valor
	// pero la idea de este id es que sea para uso interno de la bbdd
	@Id
	// es preferible que sea de generacion automatica
	@GeneratedValue(strategy = GenerationType.AUTO)
	// El problema es que al ser de funcionamiento interno, no deberiamos usarlo
	// para consultas externas
	private Long id;
	// al convertir la propiedad en unica, vale como clave alternativa, @Column son
	// ordenes de formato de la bbdd
	@Column(unique = true)
	private Long numSocio;
	@Column(length = 20)
	private String nombre;
	// cuando quiero especificar el nombre de la column que ya existe en una bbdd
	// legacy
	@Column(name = "apellidos")
	private String miApellido;
	// objeto java inumutable para usar grandes numeros (en vez de Long)
	private BigInteger enteroVerdadero;
	// Para usar numero reales con precision absoluta
	// Precision es digitos en total y scale digitos en decimales (maximos)
	@Column(precision = 7, scale = 2)
	private BigDecimal realVerdadero;
	// mal, no cabe
	//@Column(precision = 1, scale = 1)
	//private double doble = 5.66;
}
