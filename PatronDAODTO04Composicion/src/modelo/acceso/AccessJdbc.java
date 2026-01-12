package modelo.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessJdbc {
	//Estos datos de configuracion deben estar en otro sitio
	private String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private String URL_BASEDATOS = "jdbc:mysql://localhost:3307";
	private String BBDD = "";
	private Connection conexion = null;
	private boolean accesible = false;

	public AccessJdbc(String bBDD, String user, String password) throws ClassNotFoundException, SQLException {
		super();
		this.BBDD = bBDD;
		Class.forName(CONTROLADOR);
		conexion = DriverManager.getConnection(URL_BASEDATOS + "/" + this.BBDD, user, password);
		accesible = true;
	}

	public ResultSet execute(String query) {
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
			return conjuntoResultados;
		}
		return null;
	}

}
