package com.adorno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.MonitorGrupoActividad;
import com.adorno.modelo.MonitorGrupoActividadKey;

public interface MonitorGrupoActividadRepository extends JpaRepository<MonitorGrupoActividad, MonitorGrupoActividadKey> {

}
