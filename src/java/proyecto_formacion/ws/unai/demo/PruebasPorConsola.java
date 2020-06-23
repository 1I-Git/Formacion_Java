package ws.unai.demo;

import java.util.ArrayList;

import ws.unai.dao.LenguajeDaoImpl;
import ws.unai.dao.ProyectoDaoImpl;
import ws.unai.dao.UsuarioDaoImpl;
import ws.unai.modelo.Proyecto;

public class PruebasPorConsola {

	public static void main(String[] args) {
		//Obj Singleton
		UsuarioDaoImpl objDao = UsuarioDaoImpl.getInstance();
		ProyectoDaoImpl objDaoProyecto = ProyectoDaoImpl.getInstance();
		LenguajeDaoImpl objDaoLenguaje = LenguajeDaoImpl.getInstance();
		
		//Mostrar todos los Usuarios
		//objDao.getAll().forEach(System.out::println);
		
		//Mostrar proyectos y lenguajes
		
		ArrayList<Proyecto> proyecto = objDaoProyecto.getLast(8);
		
		for (Proyecto p : proyecto) {
			System.out.println(p.getNombre());
	}
		//Mostrar datos de un usuario si existe
		//System.out.println(objDao.existe("1i@mail.com", "0123"));
	
		
		
		//Mostrar lenguajes
//		ArrayList<Proyecto> lenguajeProyectos = new ArrayList<Proyecto>();
//		lenguajeProyectos = objDaoProyecto.getColorName(8, "Java");
//		lenguajeProyectos.forEach(System.out::println);;
		

	}

}
