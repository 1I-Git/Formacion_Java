package ws.unai.ejemplos.crud.controladores;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.unai.ejemplos.crud.dao.CrudGuitarraDaoImpl;
import ws.unai.ejemplos.crud.modelo.CrudGuitarra;



/**
 * Servlet implementation class CrearGuitarraControler
 */
@WebServlet("/crearGuitarra")
public class CrearGuitarraControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearGuitarraControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//recoger Parametros Form
			
			String nombre = request.getParameter("nombre");
			String marca = request.getParameter("marca");
			String informacion = request.getParameter("informacion");
			String paramPrecio = request.getParameter("precio");
			String imgGuitarra = request.getParameter("img_guitarra");
			String imgMarca = request.getParameter("img_marca");
			
			
			//Parsear Parametros
			float precio = Float.parseFloat( paramPrecio );
			
			//Almacenar datos en la BDD
			CrudGuitarraDaoImpl objDaoGuitarra =  CrudGuitarraDaoImpl.getInstance();
			
			CrudGuitarra g = new CrudGuitarra();
			
			g.setNombre(nombre);
			g.setMarca(marca);
			g.setInformacion(informacion);
			g.setPrecio(precio);
			g.setImg_guitarra(imgGuitarra);
			g.setImg_marca(imgMarca);
			
			//Llamar al metodo Insert
			
			objDaoGuitarra.insert(g);
			
			//Ir a la vista
			request.getRequestDispatcher("ejemploCrud").forward(request, response);
		} catch (Exception e) {
			// TODO:LOg
		}
	}

}
