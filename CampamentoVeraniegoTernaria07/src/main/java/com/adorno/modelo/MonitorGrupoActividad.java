package com.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MonitorGrupoActividadKey.class)
public class MonitorGrupoActividad {
	//al ser una entity trabajamos con objetos
	@Id
	@ManyToOne
	private Grupo grupo;
	@Id
	@ManyToOne
	private Actividad actividad;
	@ManyToOne
	private Monitor monitor;
	
	@Override
	public String toString() {
		return"MonitorGrupoActividad [grupoId=" + grupo.getId() + ", actividadId=" + actividad.getId() + ", monitorId="
        + monitor.getId() + "]";
	}
}
