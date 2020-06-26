package ws.unai.interfaces;

import java.util.ArrayList;

import ws.unai.modelo.Proyecto;

public interface IProyecto {
	//Devolver todos los Proyectos
	
	public ArrayList<Proyecto>getAll();
	
	//Devolver los ultimos Proyectos
	
	public ArrayList<Proyecto>getLast(int numProyectos);
	
	//Devolver los Proyectos con sus respectivos lenguajes
	
	public ArrayList<Proyecto>getAllWhithLenguajes(int limite);
	
	//Devolver los Proyectos de un mismo lenguaje
	
	public ArrayList<Proyecto>getLenguaje(int limite, String lenguaje);
}
