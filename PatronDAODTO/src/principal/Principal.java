package principal;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

import modelo.AbstractDAO.AlumnoDAO;
import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.PersonaDAO;
import modelo.Entity.Alumno;
import modelo.Entity.Persona;
import modelo.ImplDAO.DAOFactoryJDBC;

public class Principal {

	public static void main(String[] args) {
		try {
			DaoFactory daoFactory = new DAOFactoryJDBC();
//			PersonaDAO personaDAO=daoFactory.getPersonaDAO();
//			Collection<Persona> findAll = personaDAO.findAll();
//			findAll.forEach(System.out::println);
			AlumnoDAO alumnoDAO = daoFactory.getAlumnoDAO();
//			Collection<Alumno> all = alumnoDAO.findAll();
//			all.forEach(System.out::println);
			Optional<Alumno> byId = alumnoDAO.findById("9999,00");
			if (byId.isPresent()) {
				System.out.println(byId);
			}
			System.out.println(byId.orElse(new Alumno()));
			System.out.println("acabe");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
