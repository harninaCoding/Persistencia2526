package modelo.ImplDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import mapper.Mapper;
import modelo.acceso.AccessJdbc;

public class GenericComponentDAOJDBC {
	private final AccessJdbc accessJdbc;

	public GenericComponentDAOJDBC(AccessJdbc accessJdbc) {
		super();
		this.accessJdbc = accessJdbc;
	}
	
	public <T> Collection<T> findAllGeneric(String query,Mapper<ResultSet,T> mapper) {
		ResultSet conjuntoResultados = accessJdbc.execute(query);
		Collection<T> coleccion = new ArrayList<T>();
		try {
			while (conjuntoResultados.next()) {
				coleccion.add(mapper.map(conjuntoResultados));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return coleccion;
	}
}
