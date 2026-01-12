package modelo.ImplDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import mapper.AlumnoMapper;
import modelo.AbstractDAO.AlumnoDAO;
import modelo.Entity.Alumno;
import modelo.acceso.AccessJdbc;

public class AlumnoDAOJDBC implements AlumnoDAO {
	private final DAOFactoryJDBC daoFactoryJDBC;

	public AlumnoDAOJDBC(DAOFactoryJDBC daoFactoryJDBC) {
		super();
		this.daoFactoryJDBC = daoFactoryJDBC;
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
		return daoFactoryJDBC.findAllGeneric("SELECT * FROM alumnos", new AlumnoMapper());
	}

	@Override
	public Alumno findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
