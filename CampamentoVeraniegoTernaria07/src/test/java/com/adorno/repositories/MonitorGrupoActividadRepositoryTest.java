package com.adorno.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.adorno.modelo.Actividad;
import com.adorno.modelo.Grupo;
import com.adorno.modelo.Monitor;
import com.adorno.modelo.MonitorGrupoActividad;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class MonitorGrupoActividadRepositoryTest {
	@Autowired
	MonitorGrupoActividadRepository monitorGrupoActividadRepository;
	@Autowired
	GrupoRepository grupoRepository;
	@Autowired
	MonitorRepository monitorRepository;
	@Autowired
	ActividadRepository actividadRepository;
	// El mecanismo que hace la transacciones
	@Autowired
	EntityManager entityManager;

	@Transactional
	@Commit
	@Test
	void test() {
		Grupo grupo = new Grupo("uno");
		grupo = grupoRepository.save(grupo);
		Grupo grupo2 = new Grupo("dos");
		grupo2 = grupoRepository.save(grupo2);
		Monitor monitor = new Monitor("jhonny Jimenez");
		monitor = monitorRepository.save(monitor);
		Monitor monitor2 = new Monitor("Esteban Jimenez");
		monitor2 = monitorRepository.save(monitor2);
		Actividad actividad = new Actividad("salto de puente");
		actividad = actividadRepository.save(actividad);
		MonitorGrupoActividad monitorGrupoActividad = new MonitorGrupoActividad(grupo, actividad, monitor);
		monitorGrupoActividadRepository.save(monitorGrupoActividad);
		// forzando un fallo
		// probando si me duplica la clave compuesta (esta deberia fallar porque monitor
		// no es clave)
		// OJO save no significa insertar, significa sincronizar con la base de datos
		// osea, si la clave se repite, lo que hace es un update del atributo no clave
		monitorGrupoActividad = new MonitorGrupoActividad(grupo2, actividad, monitor2);
//		monitorGrupoActividadRepository.save(monitorGrupoActividad);
		// persist debe obligar a la bbdd a crear un segundo registro con esto
		try {
			entityManager.persist(monitorGrupoActividad);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// y con esto ya se fuerza el fallo
		// Como debo hacerlo en un service? si no quiero usar transactional?
		// debo comprobar con codigo si existe la clave antes de insertar. y evitar la
		// insercion.
		// ten en cuenta que debemos usar claves internas y externas.
	}

}
