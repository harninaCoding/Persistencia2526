package modelo.ImplDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import mapper.Mapper;
import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.PersonaDAO;
import modelo.acceso.AccessJdbc;

public class DAOFactoryJDBC extends DaoFactory {
	private AccessJdbc accessJdbc;
	
	public DAOFactoryJDBC() throws ClassNotFoundException, SQLException {
		super();
		// EStos parametros pueden ser pasado por parametros o configurados en otro
		// sitio
		accessJdbc = new AccessJdbc("ejemplo", "harnina", "zzzz");
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaDAOJdbc(accessJdbc);
	}

	@Override
	public AlumnoDAOJDBC getAlumnoDAO() {
		return new AlumnoDAOJDBC(accessJdbc);
	}

}
