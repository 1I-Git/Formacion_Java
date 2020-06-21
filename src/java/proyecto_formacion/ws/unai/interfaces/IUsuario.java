package ws.unai.interfaces;

import java.util.ArrayList;

import ws.unai.modelo.Usuario;

public interface IUsuario {
	//Devuelve todos los Usuarios
	
	ArrayList<Usuario>getAll();
	
	//Buscar si el Usuario Existe en la BDD
	
	Usuario existe(String correo, String pass);
	
	
}
