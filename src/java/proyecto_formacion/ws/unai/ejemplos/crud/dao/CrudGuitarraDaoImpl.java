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
		private final String SQL_GET_BY_ID = "SELECT * FROM guitarras WHERE id = ? ;";
		private final String SQL_DELETE = " DELETE FROM guitarras WHERE id = ? ; ";
		private final String SQL_INSERT = " INSERT INTO guitarras (nombre, marca, informacion, precio, img_guitarra, img_marca) VALUES ( ?, ?, ?, ?, ?, ?) ; ";
		
		
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
			CrudGuitarra guitarra = new CrudGuitarra();
			
			try(
					Connection con = EstablecerConexion.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);
					
					) {
				
					pst.setInt(1, id);
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()) {
						mapper(rs);
					} else {
						throw new Exception("Id incorrecto");
					}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return guitarra;
		}

		@Override
		public CrudGuitarra delete(int id) throws Exception {
			//Pasar id del obj a eliminar
			CrudGuitarra guitarra = getById(id);
			
			try (
					Connection con = EstablecerConexion.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_DELETE);
					) {
					pst.setInt(1, id);
					int filasAfectadas = pst.executeUpdate();
					
					if (filasAfectadas != 1) {
						throw new Exception("No se puede eliminar");
					}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return guitarra;
		}

		@Override
		public CrudGuitarra insert(CrudGuitarra pojo) throws Exception {
			
			try(
					Connection con = EstablecerConexion.getConnection();
					PreparedStatement pst = con.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
					
					) {
				
				pst.setString(1, pojo.getNombre());
				pst.setString(2, pojo.getMarca());
				pst.setString(3, pojo.getInformacion());
				pst.setFloat(4, pojo.getPrecio());
				pst.setString(5, pojo.getImg_guitarra());
				pst.setString(6, pojo.getImg_marca());
				pst.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return pojo;
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
			float precio = rs.getFloat("precio");
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
