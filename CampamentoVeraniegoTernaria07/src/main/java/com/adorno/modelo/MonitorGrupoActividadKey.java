package com.adorno.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MonitorGrupoActividadKey implements Serializable {
	private static final long serialVersionUID = 1L;
	//pongo long porque es el tipo de la clave
	private Long grupo;
	private Long actividad;
}
