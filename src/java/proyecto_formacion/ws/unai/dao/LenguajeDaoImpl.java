package ws.unai.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ws.unai.conexion.EstablecerConexion;
import ws.unai.interfaces.ILenguaje;
import ws.unai.modelo.Lenguaje;

public class LenguajeDaoImpl implements ILenguaje {

	// Constructo
	public LenguajeDaoImpl() {
		super();
	}
	
	// Patron Singleton

		private static LenguajeDaoImpl INSTANCE = null;

		public static synchronized LenguajeDaoImpl getInstance() {

			if (INSTANCE == null) {
				INSTANCE = new LenguajeDaoImpl();
			}

			return INSTANCE;
		}
		
		//Sentencias SQL
		private final String SQL_GET_ALL = "SELECT * FROM lenguajes ORDER BY id ASC LIMIT 500 ;";
		
		
		//Metodos de la intefaz
		@Override
		public ArrayList<Lenguaje> getAll() {
			ArrayList<Lenguaje> lenguajes = new ArrayList<Lenguaje>();

			try (
					// Establecer Conexion & Ejecutar la sentencia SQL
					Connection con = EstablecerConexion.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
					ResultSet rs = pst.executeQuery();

			) {

				// Recorrer el ResultSet
				while (rs.next()) {
					// Guardar Obj del mapper en el Array
					lenguajes.add(mapper(rs));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return lenguajes;
		}
		
		private Lenguaje mapper(ResultSet rs) throws SQLException {
			// Guardar datos en las variables
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String color = rs.getString("color");

			// Meter datos de las variables en OBJ
			Lenguaje l = new Lenguaje();

			l.setId(id);
			l.setNombre(nombre);
			l.setColor(color);
			
			return l;
		}
}
