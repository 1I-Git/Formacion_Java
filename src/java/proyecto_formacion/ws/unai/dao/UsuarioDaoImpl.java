package ws.unai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ws.unai.conexion.EstablecerConexion;
import ws.unai.interfaces.IUsuario;
import ws.unai.modelo.Rol;
import ws.unai.modelo.Usuario;

public class UsuarioDaoImpl implements IUsuario {
	
	private final static Logger LOG = Logger.getLogger(UsuarioDaoImpl.class);
	
	// Constructor

	public UsuarioDaoImpl() {
		super();
	}

	// Patron Singleton

	private static UsuarioDaoImpl INSTANCE = null;

	public static synchronized UsuarioDaoImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDaoImpl();
		}

		return INSTANCE;
	}
	
	//Sentencias SQL
	
	private final String SQL_GET_ALL = "SELECT * FROM usuarios ORDER BY id DESC LIMIT 500;";
	private final String SQL_EXISTE = "SELECT u.id, u.nombre, u.apellido, u.correo, u.pass, u.imagen, u.rol, r.id_rol, r.rol AS 'nombre_rol' " + 
									  "FROM usuarios u, roles r " + 
									  "WHERE u.correo = ? AND u.pass = ? AND u.rol = r.id_rol; ";
	
	//Metodos de la interface
	
	//Obtener todos los Usuarios
	@Override
	public ArrayList<Usuario> getAll() {
		// Inicializar ArrayList
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try(
				//Establecer Conexion & Ejecutar la sentencia SQL
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst =  con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery(); 
				) {
				//Recorrer ResultSet
				while (rs.next()) {
					//Guardar resultados en variables
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String correo = rs.getString("correo");
					String pass = rs.getString("pass");
					String imagen = rs.getString("imagen");
					
					//Crear Obj y meter los datos
					Usuario u = new Usuario();
					u.setNombre(nombre);
					u.setApellido(apellido);
					u.setCorreo(correo);
					u.setPass(pass);
					u.setImagen(imagen);
					
					//Guardar Obj en el array
					usuarios.add(u);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	//Comprobar si el correo y la Pass existen en la BDD
	@Override
	public Usuario existe(String correo, String pass) {
		// Inicializar con null OBJ
		Usuario u = null;
		
		try(
				//Establecer Conexion y preparar SQL
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst =  con.prepareStatement(SQL_EXISTE);
				) {
				
				//Pasar datos a la sentencia SQL
				pst.setString(1, correo);
				pst.setString(2, pass);
				//Ejecutar SQL
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
					//Inicializar el Obj
					u = new Usuario();
					
					//Guardar en el Obj los datos de ese Usuario
					u.setId(rs.getInt("id"));
					u.setNombre(rs.getString("nombre"));
					u.setApellido(rs.getString("apellido"));
					u.setCorreo(rs.getString("correo"));
					u.setPass(rs.getString("pass"));
					u.setImagen(rs.getString("imagen"));
					
					//Guardar datos del Rol
					Rol rol = new Rol();
					rol.setId(rs.getInt("id_rol"));
					rol.setRol(rs.getString("nombre_rol"));
					
					//Setear Rol del Usuario
					u.setRol(rol);
				}
				
		} catch (Exception e) {
			LOG.error(e);
		}
		return u;
	}
	
	
}
