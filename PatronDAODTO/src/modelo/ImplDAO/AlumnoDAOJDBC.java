package modelo.ImplDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import mapper.AlumnoMapper;
import modelo.AbstractDAO.AlumnoDAO;
import modelo.Entity.Alumno;
import modelo.acceso.AccessJdbc;

public class AlumnoDAOJDBC implements AlumnoDAO {
	private AccessJdbc accessJdbc;

	public AlumnoDAOJDBC(AccessJdbc accessJdbc) {
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
		ResultSet conjuntoResultados = accessJdbc.execute("SELECT * FROM alumnos");
		Collection<Alumno> alumnos = new ArrayList<>();
		AlumnoMapper alumnoMapper = new AlumnoMapper();
		try {
			while (conjuntoResultados.next()) {
				alumnos.add(alumnoMapper.map(conjuntoResultados));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return alumnos;
	}

	@Override
	public Optional<Alumno> findById(String id) {
		String query = "SELECT * FROM alumnos WHERE Matricula like '" + id + "'";
		ResultSet conjuntoResultados = accessJdbc.execute(query);
		AlumnoMapper alumnoMapper = new AlumnoMapper();
		try {
			if(conjuntoResultados.next()) {
				return Optional.ofNullable(alumnoMapper.map(conjuntoResultados));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
