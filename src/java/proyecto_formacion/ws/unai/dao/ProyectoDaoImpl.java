package ws.unai.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

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
										  " p.id     'p_id', " +	
										  " p.nombre     'p_nombre', " +
										  " p.descripcion     'p_descripcion', " +
										  " p.enlace     'p_enlace', " +
										  " l.id     'l_id', " +
										  " l.nombre     'l_nombre', " +
										  " l.color     'l_color' " +
										  "FROM proyectos p , lenguajes l, proyectos_tiene_lenguajes ptl " + 
										  "WHERE p.id = ptl.id_proyecto AND l.id = ptl.id_lenguajes " + 
										  "ORDER BY Rand() LIMIT ?  ;";
	
	
	private final String SQL_GET_ALL_WITH_LENGUAJE = "SELECT " +
													  " p.id     'pro_id', " +	
													  " p.nombre     'pro_nombre', " +
													  " p.descripcion     'pro_descripcion', " +
													  " p.enlace     'pro_enlace', " +
													  " l.id     'len_id', " +
													  " l.nombre     'len_nombre', " +
													  " l.color     'len_color' " +
													  "FROM proyectos p , lenguajes l, proyectos_tiene_lenguajes ptl " + 
													  "WHERE p.id = ptl.id_proyecto AND l.id = ptl.id_lenguajes " + 
													  "ORDER BY p.nombre ASC LIMIT ?  ;";

	private final String SQL_GET_LENGUAJE_PROJECTS = "SELECT " +
													  " p.id     'pro_id', " +	
													  " p.nombre     'pro_nombre', " +
													  " p.descripcion     'pro_descripcion', " +
													  " p.enlace     'pro_enlace', " +
													  " l.id     'len_id', " +
													  " l.nombre     'len_nombre', " +
													  " l.color     'len_color' " +
													  "FROM proyectos p , lenguajes l, proyectos_tiene_lenguajes ptl " + 
													  "WHERE p.id = ptl.id_proyecto AND l.id = ptl.id_lenguajes AND l.nombre = ? " + 
													  "ORDER BY p.nombre ASC LIMIT ?  ;";
	
	
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
				String enlace = rs.getString("enlace");

				// Meter datos de las variables en OBJ
				Proyecto p = new Proyecto();

				p.setId(id);
				p.setNombre(nombre);
				p.setDescripcion(descripcion);
				p.setEnlace(enlace);

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
					int idProyecto = rs.getInt("p_id");
					String nombreProyecto = rs.getString("p_nombre");
					String descripcionProyecto = rs.getString("p_descripcion");
					String enlaceProyecto = rs.getString("p_enlace");
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
					p.setEnlace(enlaceProyecto);
					
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
	
	
	
	// Devolver proyecto con sus lenguajes 
	@Override
	public ArrayList<Proyecto> getAllWhithLenguajes(int limite) {
		//La clave es un Integer con el id del lenguaje
		HashMap<Integer, Proyecto> registros = new HashMap<Integer, Proyecto>();
		
		try (
				// Establecer Conexion & Preparar la sentencia SQL
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL_WITH_LENGUAJE);
				
				) {
			
				//Pasar valor a la sentencia SQL 
				pst.setInt(1, limite);
				
				try(ResultSet rs = pst.executeQuery();) {
					
					while (rs.next()) {
						
						int idProyecto = rs.getInt("pro_id"); //Key del hasmap
						
						//Recuperar proyecto del hasmap
						Proyecto p = registros.get(idProyecto);
						
						//Comprobar si es null y rellenarlo evitando duplicados
						
						if (p == null) {
							p = new Proyecto();
							
							p.setId(idProyecto);
							p.setNombre(rs.getString("pro_nombre"));
							p.setDescripcion(rs.getString("pro_descripcion"));
							p.setEnlace(rs.getString("pro_enlace"));
							
						}
						//Crerar obj tipo lenguaje y rellenarlo
						Lenguaje l = new Lenguaje();
						
						l.setId(rs.getInt("len_id"));
						l.setNombre(rs.getString("len_nombre"));
						l.setColor(rs.getString("len_color"));
						
						//recuperar los lenguajes y añadir uno nuevo dentro del proyecto
						p.getLenguajes().add(l);
						
						//guardar en el hasmap el proyecto
						registros.put(idProyecto, p);
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//nuevo arraylist con los valores del hasmap
		return new ArrayList<Proyecto>(registros.values());
	}
	
	//Mostrar proyectos de un lenguaje
	
	@Override
	public ArrayList<Proyecto> getLenguaje(int limite, String lenguaje) {
		//La clave es un Integer con el id del lenguaje
		HashMap<Integer, Proyecto> registros = new HashMap<Integer, Proyecto>();
		
		try (
				// Establecer Conexion & Preparar la sentencia SQL
				Connection con = EstablecerConexion.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_LENGUAJE_PROJECTS);
				
				) {
			
				//Pasar valor a la sentencia SQL 
				pst.setString(1, lenguaje);
				pst.setInt(2, limite);
				
				
				try(ResultSet rs = pst.executeQuery();) {
					
					while (rs.next()) {
						
						int idProyecto = rs.getInt("pro_id"); //Key del hasmap
						
						//Recuperar proyecto del hasmap
						Proyecto p = registros.get(idProyecto);
						
						//Comprobar si es null y rellenarlo evitando duplicados
						
						if (p == null) {
							p = new Proyecto();
							
							p.setId(idProyecto);
							p.setNombre(rs.getString("pro_nombre"));
							p.setDescripcion(rs.getString("pro_descripcion"));
							p.setEnlace(rs.getString("pro_enlace"));
							
						}
						//Crerar obj tipo lenguaje y rellenarlo
						Lenguaje l = new Lenguaje();
						
						l.setId(rs.getInt("len_id"));
						l.setNombre(rs.getString("len_nombre"));
						l.setColor(rs.getString("len_color"));
						
						//recuperar los lenguajes y añadir uno nuevo dentro del proyecto
						p.getLenguajes().add(l);
						
						//guardar en el hasmap el proyecto
						registros.put(idProyecto, p);
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//nuevo arraylist con los valores del hasmap
		return new ArrayList<Proyecto>(registros.values());
	}
	
	
	


}
