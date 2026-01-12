package modelo.ImplDAO.java8;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import mapper.Mapper;
import modelo.acceso.AccessJdbc;

public interface GenericDAOJDBC {
	
	public default <T> Collection<T> findAllGeneric(AccessJdbc accessJdbc, String query,Mapper<ResultSet,T> mapper) {
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
