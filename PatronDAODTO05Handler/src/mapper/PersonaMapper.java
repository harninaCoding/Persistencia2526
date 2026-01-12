package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Persona;

public class PersonaMapper implements Mapper<ResultSet, Persona> {

	@Override
	public Persona map(ResultSet s) {
		try {
			Object object1 = s.getObject(1);
			Integer i = (Integer) object1;
			Long id = i.longValue();
			Object object3 = s.getObject(2);
			String nombre = (String) object3;
			Object object5 = s.getObject(3);
			String apellidos = (String) object3;
			return new Persona(id, nombre,apellidos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
