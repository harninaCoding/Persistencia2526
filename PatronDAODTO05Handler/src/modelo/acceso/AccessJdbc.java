package modelo.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import handler.Handler;

public class AccessJdbc {
	// Estos datos de configuracion deben estar en otro sitio
	private String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private String URL_BASEDATOS = "jdbc:mysql://localhost:3307";
	private String BBDD = "";
	private boolean accesible = false;
	private String user;
	private String password;

	public AccessJdbc(String bBDD, String user, String password) throws ClassNotFoundException, SQLException {
		super();
		this.BBDD = bBDD;
		Class.forName(CONTROLADOR);
		this.user = user;
		this.password = password;
		accesible = true;
	}

	public <T> T execute(String query,Handler<T> handler) {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL_BASEDATOS + "/" + this.BBDD, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSetMetaData metaDatos = null;
		if (accesible) {
			ResultSet conjuntoResultados = null;
			Statement instruccion = null;
			try {
				instruccion = conexion.createStatement();
				conjuntoResultados = instruccion.executeQuery(query);
				metaDatos = conjuntoResultados.getMetaData();
			} catch (SQLException e) {
				return null;
			}
			return handler.transform(conjuntoResultados);
		}
		return null;
	}

}
