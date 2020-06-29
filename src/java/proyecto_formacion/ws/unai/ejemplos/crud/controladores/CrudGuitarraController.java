package ws.unai.ejemplos.crud.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ws.unai.ejemplos.crud.dao.CrudGuitarraDaoImpl;

/**
 * Servlet implementation class CrudGuitarraController
 */
@WebServlet("/ejemploCrud")
public class CrudGuitarraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final CrudGuitarraDaoImpl objDaoGuitarra = CrudGuitarraDaoImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudGuitarraController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Mostrar toda la informacion de la tabla guitarras
		request.setAttribute("guitarras", objDaoGuitarra.getAll());
		//Mandar a la vista Principal(index.jsp)
		request.getRequestDispatcher("/pages/ejemplos/CrudGuitarra.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
