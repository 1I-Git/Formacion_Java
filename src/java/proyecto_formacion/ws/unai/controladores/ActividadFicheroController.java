package ws.unai.controladores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ws.unai.conexion.EstablecerConexion;

/**
 * Servlet implementation class ActividadFicheroController
 */
@WebServlet("/actividad-fichero")
public class ActividadFicheroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(FicherosController.class);
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActividadFicheroController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("Inicio");
		//final String PATH_FICHERO = "/home/javaee/eclipse-workspace/supermercado-java/src/main/resources/personas.txt";
		final String PATH_FICHERO = "personas.txt"; // busca el fichero en la carpeta => src/main/resources
		String mensaje = "";
		int numLineas = 0;
		int numInsert = 0;
		int numErroresCampos = 0;
		int numErroresNombresDuplicados = 0;
		long tiempoInicio = System.currentTimeMillis();
		long tiempoFin = 0;
		
		// INSERT INTO usuario (nombre,contrasenia,id_rol) VALUES ('persona','e10adc3949ba59abbe56e057f20f883e',1);
		//final int ID_ROL_USER = 1;
		//final String PASSWORD = "e10adc3949ba59abbe56e057f20f883e"; // 123456 en MD5

		final String SQL = " INSERT INTO usuarios (nombre,apellido,correo,pass,imagen,rol) VALUES ( ? ,'apellido_default',?,'e10adc3949ba59abbe56e057f20f883e','img_default',2); ";
		
		/******** Logica de programacion **********/
		
	
		
		
		try ( Connection conexion = EstablecerConexion.getConnection();
			  PreparedStatement pst = conexion.prepareStatement(SQL);			  
			  BufferedReader br = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(PATH_FICHERO).getFile()));
		  ){
			
			// Cuando establecemos una conexion en Java, siempre es autocomitable
			// Con esta linea le decimos que no lo sea y deberemos hacer un COMMIT para guardar los cambios temporales
			conexion.setAutoCommit(false);
			String linea = br.readLine(); // obviar la 1º linea, que son la cabecera
			LOG.trace("Recorrer linea a linea, despues de saltar la 1º linea");
			
			while( (linea = br.readLine()) != null) {
				String[] campos = linea.split(";");	
				
				try {
					numLineas++;	
					if (campos.length != 6 ) {
						numErroresCampos++;
					}else {
					
						pst.setString(1, campos[0] );
						pst.setString(2, campos[4] );
						LOG.debug(pst);
						int affectedRows = pst.executeUpdate();
						if ( affectedRows != 1 ) {
							numErroresCampos++;
							LOG.warn("FALLO Inser affectedRows != 1");	
						}else {
							numInsert++;
							LOG.trace("Insertada Persona");
						}
						
					}					
				
				// capturar posibles Excepciones para poder seguir dentro del FOR				
				}catch (Exception e) {	
					LOG.warn("Nombre duplicado: " +  campos[0] );
					numErroresNombresDuplicados++;
				}	
				
			}// end while
			
			conexion.commit();
			LOG.trace("Al finalizar, realizar un commit para guardar en bbdd");
			
		}catch (FileNotFoundException e) {
			mensaje = "Lo sentimos pero el fichero no existe en la ruta: <b>" + PATH_FICHERO + "</b>";
			
		}catch (Exception e) {			
			LOG.error(e);
			mensaje = e.getMessage();
			e.printStackTrace();
			
		}finally {
			
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("fichero", PATH_FICHERO);
			request.setAttribute("numero_lineas", numLineas);
			request.setAttribute("numero_insercciones", numInsert);
			request.setAttribute("numero_errores_campos", numErroresCampos);
			request.setAttribute("numero_errores_nombre", numErroresNombresDuplicados);
			
			tiempoFin = System.currentTimeMillis();
			request.setAttribute("tiempo", (tiempoFin - tiempoInicio) );			
			
			request.getRequestDispatcher("/pages/backoffice/resumenFichero.jsp").forward(request, response);
		}
		LOG.trace("Fin");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
