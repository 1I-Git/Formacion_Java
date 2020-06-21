package ws.unai.demo;

import ws.unai.dao.UsuarioDaoImpl;

public class PruebasPorConsola {

	public static void main(String[] args) {
		//Obj Singleton
		UsuarioDaoImpl objDao = UsuarioDaoImpl.getInstance();
		//Mostrar todos los Usuarios
		objDao.getAll().forEach(System.out::println);
		
		//Mostrar datos de un usuario si existe
		System.out.println(objDao.existe("1i@mail.com", "0123"));
		

	}

}
