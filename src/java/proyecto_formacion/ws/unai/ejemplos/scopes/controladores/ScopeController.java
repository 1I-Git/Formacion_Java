package ws.unai.ejemplos.scopes.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeController
 */
@WebServlet("/scope-pagecontext")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScopeController() {
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
		
		ServletContext sc = request.getServletContext();
		sc.setAttribute("ejemplo_usuarios_conectados", 5023);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("ejemplo_tiempo_conectado", 23 );

		request.setAttribute("ejemplo_nombre", "Ander en Reuqest");
		
		
		sc.setAttribute("ejemplo_igual", "Aplicacion");
		session.setAttribute("ejemplo_igual", "session");
		request.setAttribute("ejemplo_igual", "request");
		
		request.getRequestDispatcher("pages/ejemplos/scopes.jsp").forward(request, response);
	}

}
