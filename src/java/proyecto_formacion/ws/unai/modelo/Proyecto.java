package ws.unai.modelo;

public class Proyecto {
	//Atributos
	
	private int id;
	private String nombre;
	private String descripcion;
	private Lenguaje lenguaje;
	
	//Constructores
	
	public Proyecto() {
		super();
		this.id = 0;
		this.nombre = "nombre_default";
		this.descripcion = "descripcion_default";
		this.lenguaje = new Lenguaje();
	}
	
	//Getter&Setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Lenguaje getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(Lenguaje lenguaje) {
		this.lenguaje = lenguaje;
	}
	
	//ToString
	
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", lenguaje=" + lenguaje
				+ "]";
	}

	
	
	
	
	
}
