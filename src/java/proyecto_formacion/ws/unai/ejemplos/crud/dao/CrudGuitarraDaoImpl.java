package ws.unai.ejemplos.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ws.unai.conexion.EstablecerConexion;
import ws.unai.ejemplos.crud.interfaces.ICrudGuitarra;
import ws.unai.ejemplos.crud.modelo.CrudGuitarra;

public class CrudGuitarraDaoImpl implements ICrudGuitarra {
	
	//Constructor
	
	public CrudGuitarraDaoImpl() {
		super();
	}
	
	// Patron Singleton
		private static CrudGuitarraDaoImpl INSTANCE = null;

		public static synchronized CrudGuitarraDaoImpl getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new CrudGuitarraDaoImpl();
			}
			return INSTANCE;
		}
		
		//Sentencias SQL
		
		private final String SQL_GET_ALL = "SELECT * FROM guitarras LIMIT 500;";
		
		//Metodos de la intefaz ICrudGuitarra
		@Override
		public ArrayList<CrudGuitarra> getAll() {
			ArrayList<CrudGuitarra> guitarras = new ArrayList<CrudGuitarra>();
			
			try(
					//Establecer Conexion, preparar SQL y Ejecutarla
					Connection con = EstablecerConexion.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
					ResultSet rs = pst.executeQuery();
					
					) {
					
					while (rs.next()) {
						guitarras.add(mapper(rs));
					}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return guitarras;
		}

		@Override
		public CrudGuitarra getById(int id) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CrudGuitarra delete(int id) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CrudGuitarra insert(CrudGuitarra pojo) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CrudGuitarra update(CrudGuitarra pojo) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		//Funcion mapper para evitar repetir codigo
		
		private CrudGuitarra mapper(ResultSet rs) throws SQLException { 
			//Guardar informacion de la BBDD en variables
			int id = rs.getInt("id");
			int precio = rs.getInt("precio");
			String nombre = rs.getString("nombre");
			String marca = rs.getString("marca");
			String informacion = rs.getString("informacion");
			String img_guitarra = rs.getString("img_guitarra");
			String img_marca = rs.getString("img_marca");
			
			// Meter datos de las variables en OBJ
			
			CrudGuitarra g = new CrudGuitarra();
			g.setId(id);
			g.setPrecio(precio);
			g.setNombre(nombre);
			g.setMarca(marca);
			g.setInformacion(informacion);
			g.setImg_guitarra(img_guitarra);
			g.setImg_marca(img_marca);
			
			return g;
		}
	
	
}
