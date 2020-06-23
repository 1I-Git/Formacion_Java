package ws.unai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ws.unai.conexion.EstablecerConexion;
import ws.unai.interfaces.IProyecto;
import ws.unai.modelo.Lenguaje;
import ws.unai.modelo.Proyecto;

public class ProyectoDaoImpl implements IProyecto {

	// Constructor

	public ProyectoDaoImpl() {
		super();

	}

	// Patron Singleton

	private static ProyectoDaoImpl INSTANCE = null;

	public static synchronized ProyectoDaoImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProyectoDaoImpl();
		}

		return INSTANCE;
	}

	// Sentencias SQL

	private final String SQL_GET_ALL = "SELECT * FROM proyectos ORDER BY id DESC LIMIT 500 ;";
	
	private final String SQL_GET_LAST = "SELECT " +
										  " p.id     'pro_id', " +	
										  " p.nombre     'pro_nombre', " +
										  " p.descripcion     'pro_descripcion', " +
										  " l.id     'len_id', " +
										  " l.nombre     'len_nombre', " +
										  " l.color     'len_color' " +
										  "FROM proyectos p , lenguajes l, proyectos_tiene_lenguajes ptl " + 
										  "WHERE p.id = ptl.id_proyecto AND l.id = ptl.id_lenguajes " + 
										  "ORDER BY Rand() LIMIT ?  ;";
	
	private final String SQL_GET_LENGUAJE = "SELECT" + 
											  " p.id     'p_id', " + 
											  " p.nombre     'p_nombre', " + 
											  " p.descripcion     'p_descripcion', " + 
											  " l.id     'l_id', " + 
											  " l.nombre     'l_nombre' , " + 
											  " l.color     'l_color' " + 
											  "FROM proyectos p , lenguajes l, proyectos_tiene_lenguajes ptl " + 
											  "WHERE p.id = ptl.id_proyecto AND l.id = ptl.id_lenguajes AND l.nombre = ? " + 
											  "ORDER BY p.id ASC LIMIT ?  ;";

	// Metodos de la Interface

	// Mostrar todos los proyectos
	@Override
	public ArrayList<Proyecto> getAll() {
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();

		try (
				// Establecer Conexion & Ejecutar la sentencia SQL
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();

		) {

			// Recorrer el ResultSet
			while (rs.next()) {
				// Guardar datos en las variables
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");

				// Meter datos de las variables en OBJ
				Proyecto p = new Proyecto();

				p.setId(id);
				p.setNombre(nombre);
				p.setDescripcion(descripcion);

				// Guardar Obj en el Array
				proyectos.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return proyectos;
	}

	// Devolver los ultimos proyectos
	@Override
	public ArrayList<Proyecto> getLast(int numProyectos) {
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();

		try (
				// Establecer Conexion & Preparar la sentencia SQL
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_LAST);

		) {
			//Pasar valor a la sentencia SQL 
			pst.setInt(1, numProyectos);
			
			//Intetar Ejecutar la Query
			try(ResultSet rs = pst.executeQuery();) {
					
				// Recorrer el ResultSet
				while (rs.next()) {
					// Guardar datos en las variables ****Cambiar Nombres**
					int idProyecto = rs.getInt("pro_id");
					String nombreProyecto = rs.getString("pro_nombre");
					String descripcionProyecto = rs.getString("pro_descripcion");
					int idLenguaje = rs.getInt("len_id");
					String nombreLenguaje = rs.getString("len_nombre");
					String colorLenguaje = rs.getString("len_color");

					// Meter datos de las variables en OBJ
					Proyecto p = new Proyecto();
					Lenguaje l = new Lenguaje();
					
					//Añadir al obj Proyecto
					p.setId(idProyecto);
					p.setNombre(nombreProyecto);
					p.setDescripcion(descripcionProyecto);
					
					//Añadir al obj Lenguaje
					l.setId(idLenguaje);
					l.setNombre(nombreLenguaje);
					l.setColor(colorLenguaje);
					
					//Añadir Lenguaje al Proyecto
					p.setLenguaje(l);
					// Guardar Obj en el Array
					proyectos.add(p);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return proyectos;
	}
	
	//Devolver los ultimos Proyectos con el color y el nombre del lenguaje
	@Override
	public ArrayList<Proyecto> getColorName(int numProyectos, String lenguaje) {
		ArrayList<Proyecto> proyectoLenguaje = new ArrayList<Proyecto>();
		
		try (
				// Establecer Conexion & Preparar la sentencia SQL
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_LENGUAJE);

		) {
			//Pasar valor a la sentencia SQL 
			pst.setString(1, lenguaje);
			pst.setInt(2, numProyectos);
			
			
			//Intetar Ejecutar la Query
			try(ResultSet rs = pst.executeQuery();) {
					
				// Recorrer el ResultSet
				while (rs.next()) {
					// Guardar datos en las variables ****Cambiar Nombres**
					int idProyecto = rs.getInt("p_id");
					String nombreProyecto = rs.getString("p_nombre");
					String descripcionProyecto = rs.getString("p_descripcion");
					int idLenguaje = rs.getInt("l_id");
					String nombreLenguaje = rs.getString("l_nombre");
					String colorLenguaje = rs.getString("l_color");

					// Meter datos de las variables en OBJ
					Proyecto p = new Proyecto();
					Lenguaje l = new Lenguaje();
					
					//Añadir al obj Proyecto
					p.setId(idProyecto);
					p.setNombre(nombreProyecto);
					p.setDescripcion(descripcionProyecto);
					
					//Añadir al obj Lenguaje
					l.setId(idLenguaje);
					l.setNombre(nombreLenguaje);
					l.setColor(colorLenguaje);
					
					//Añadir Lenguaje al Proyecto
					p.setLenguaje(l);
					// Guardar Obj en el Array
					proyectoLenguaje.add(p);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return proyectoLenguaje;
	}
	


}
