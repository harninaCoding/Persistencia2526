package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import modelo.Entity.Alumno;

public class AlumnoMapper implements Mapper<ResultSet, Alumno> {

	@Override
	public Alumno map(ResultSet s) {
		try {
			String matricula =String.valueOf(s.getObject(1));
			String nombre = (String) s.getObject(2);
			String apellidos = (String) s.getObject(3);
			String sexo = (String) s.getObject(4);
			LocalDate nacimiento=new String2LocalDateMapper().map( (String)  s.getObject(5));
			return new Alumno(matricula, apellidos, nombre, sexo, nacimiento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
