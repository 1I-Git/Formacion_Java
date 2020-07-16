package ws.unai.conexion;

import java.sql.Connection; 
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EstablecerConexion {
	
	/*
	 * Configuracion en a traves de un data source
	 * @see src/main/webapp/META-INF/context.xml
	 * 
     * Constantes para establecer conexion
		private final static String URL = "jdbc:mysql://localhost/formacion_java";
		private final static String USER = "root";
		private final static String PASS = "root";
	*/
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException {
		// Inicializar Conexion a null
		Connection con = null;
				
		// Comprobar que este el .jar de MySQL
		Class.forName("com.mysql.jdbc.Driver");
		
		InitialContext initCtx=new InitialContext();;
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource)envCtx.lookup("jdbc/formacion");
		
		// establecer conexion conexión del pool
		con = dataSource.getConnection(); 
		
		// establecer conexion conexión con Driver Manager
		//con = DriverManager.getConnection(URL, USER, PASS);
		

		return con;
	}
}
