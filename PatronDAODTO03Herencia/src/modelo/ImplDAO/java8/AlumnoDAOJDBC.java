package modelo.ImplDAO.java8;

import java.util.Collection;

import mapper.AlumnoMapper;
import modelo.AbstractDAO.AlumnoDAO;
import modelo.Entity.Alumno;
import modelo.acceso.AccessJdbc;

public class AlumnoDAOJDBC  implements AlumnoDAO,GenericDAOJDBC {
	private final AccessJdbc accessJdbc;
	
	public AlumnoDAOJDBC(AccessJdbc accessJdbc) {
		super();
		this.accessJdbc = accessJdbc;
	}

	@Override
	public void create(Alumno entidad) {
		// TODO Auto-generated method stub
		
	}
	
	/////////////////////////////////////////////////////////////////////////
	/// Problemon
	///
	 /**
	  * Guay porque funciona. mal porque rompemos DRY al tener que implementar, casi lo mismo,
	  * en todos los DAOS solucion en DRY DAO ALumno
	*/

	@Override
	public Collection<Alumno> findAll() {
		return findAllGeneric(accessJdbc,"SELECT * FROM alumnos", new AlumnoMapper());
	}

	@Override
	public Alumno findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
