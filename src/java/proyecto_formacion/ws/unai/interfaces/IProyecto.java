package ws.unai.interfaces;

import java.util.ArrayList;

import ws.unai.modelo.Proyecto;

public interface IProyecto {
	//Devolver todos los Proyectos
	
	ArrayList<Proyecto>getAll();
	
	//Devolver los ultimos Proyectos
	
	ArrayList<Proyecto>getLast(int numProyectos);
	
	//Devolver los ultimos Proyectos con el color y el nombre del lenguaje
	
	ArrayList<Proyecto>getColorName(int numProyectos , String lenguaje);
}
