package ws.unai.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ws.unai.dao.LenguajeDaoImpl;
import ws.unai.dao.ProyectoDaoImpl;
import ws.unai.dao.UsuarioDaoImpl;
import ws.unai.modelo.Lenguaje;
import ws.unai.modelo.Proyecto;
import ws.unai.modelo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoger parametro
		String parametroNombre = request.getParameter("nombre");
		//ObjDao
		ProyectoDaoImpl objDaoProyecto = ProyectoDaoImpl.getInstance();
		
		ArrayList<Proyecto> lenguajeProyectos = new ArrayList<Proyecto>();
		
		lenguajeProyectos = objDaoProyecto.getColorName(8, parametroNombre);
		
		//Mandar datos a la vista
		request.setAttribute("lenguajeProyectos", lenguajeProyectos );
		request.setAttribute("parametro", parametroNombre );
		
		//Mandar a la vista Principal(index.jsp)
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Recuperar Datos del formulario
			String correo = request.getParameter("correo");
			String pass = request.getParameter("pass");
			
			//OBJ del Dao
			UsuarioDaoImpl objDaoUsuario =  UsuarioDaoImpl.getInstance();
			ProyectoDaoImpl objDaoProyecto = ProyectoDaoImpl.getInstance();
			LenguajeDaoImpl objDaoLenguaje = LenguajeDaoImpl.getInstance();
					
			//Guardar datos del usuario en un Obj
			Usuario usuario = objDaoUsuario.existe(correo, pass);
			
			if (usuario != null) {
				
				// Inicializar Sesion
				HttpSession session = request.getSession();

				// Sesiones
				session.setMaxInactiveInterval(60 * 5); // 5 minutos sin peticiones, se invalida la session del usuario.
				session.setAttribute("id_usuario", usuario.getId());
				session.setAttribute("nombre_usuario", usuario.getNombre());
				session.setAttribute("apellido_usuario", usuario.getApellido());
				session.setAttribute("correo_usuario", usuario.getCorreo());
				session.setAttribute("pass_usuario", usuario.getPass());
				
				//Mostrar todos los lenguajes de un proyecto
				
				ArrayList<Proyecto> proyectoLenguajes = objDaoProyecto.getAllWhithLenguajes(500);
				
				request.setAttribute("proyectoLenguajes", proyectoLenguajes);
				
				//Mandar a la vista Principal(index.jsp)
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else {
				request.getRequestDispatcher("pages/login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
