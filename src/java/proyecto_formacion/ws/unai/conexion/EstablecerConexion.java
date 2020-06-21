package ws.unai.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablecerConexion {

	// Constantes para establecer conexion
	private final static String URL = "jdbc:mysql://localhost/formacion_java";
	private final static String USER = "root";
	private final static String PASS = "root";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// Comprobar que este el .jar de MySQL
		Class.forName("com.mysql.jdbc.Driver");
		// Establecer Conexion
		Connection con = null;

		con = DriverManager.getConnection(URL, USER, PASS);

		return con;
	}
}
