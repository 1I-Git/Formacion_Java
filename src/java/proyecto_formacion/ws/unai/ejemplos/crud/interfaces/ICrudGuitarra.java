package ws.unai.ejemplos.crud.interfaces;

import java.util.ArrayList;

import ws.unai.ejemplos.crud.modelo.CrudGuitarra;

public interface ICrudGuitarra {
	
	//Devuelve todos los datos de la BBDD
	ArrayList<CrudGuitarra> getAll();
	
	//Devuelve todos los datos de un obj en concreto por su id
	CrudGuitarra getById(int id) throws Exception;
	
	//Eliminar datos de la BBDD
	CrudGuitarra delete(int id) throws Exception;
	
	//Guardar datos en la BBDD
	CrudGuitarra insert(CrudGuitarra pojo) throws Exception;
	
	//Actualizar datos de la BBDD
	CrudGuitarra update(CrudGuitarra pojo) throws Exception;
}
