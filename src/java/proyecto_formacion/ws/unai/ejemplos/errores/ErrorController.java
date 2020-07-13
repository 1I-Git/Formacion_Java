package ws.unai.ejemplos.errores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ErrorController
 */
@WebServlet("/error")
public class ErrorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor = request.getParameter("valor");
		Boolean bol = false;
		Object o = null;
		
		if ("true".equalsIgnoreCase(valor)) {
			bol = true;
			request.setAttribute("bol", bol);
			request.setAttribute("valor", valor);
			request.setAttribute("objError", o.toString());
		}
		request.setAttribute("bol", bol);
		request.getRequestDispatcher("pages/ejemplos/generarError.jsp").forward(request, response);
	}

}
