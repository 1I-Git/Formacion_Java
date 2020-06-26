package ws.unai.listenner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ws.unai.dao.LenguajeDaoImpl;
import ws.unai.dao.ProyectoDaoImpl;

/**
 * Application Lifecycle Listener implementation class InicioAppListenner
 *
 */
@WebListener
public class InicioAppListenner implements ServletContextListener {
	//OBJ DAO
	private static final ProyectoDaoImpl objDaoProyecto = ProyectoDaoImpl.getInstance();
	private static final LenguajeDaoImpl objDaoLenguaje = LenguajeDaoImpl.getInstance();
	
    /**
     * Default constructor. 
     */
    public InicioAppListenner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // Se usa para ejecutar cosas cuando se para la app
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // Al arrancar la aplicacion
    	
    	// Este contexto es para toda la Aplicacion y es accesible desde cualñquier JSP o Servlet    	
    	ServletContext contextoAplicacion = sce.getServletContext();
    	
    	//Mostrar todos los Proyectos
    	contextoAplicacion.setAttribute("proyectos", objDaoProyecto.getAll() );
    	
    	//Mostrar todos los lenguajes
    	contextoAplicacion.setAttribute("lenguajes", objDaoLenguaje.getAll() );
    	
    	
    }
	
}
