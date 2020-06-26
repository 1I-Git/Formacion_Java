package ws.unai.modelo;


public class Lenguaje {
	//Atributos
	
	private int id;
	private String nombre;
	private String color;
	
	//Constructor
	
	public Lenguaje() {
		super();
		this.id = 0;
		this.nombre = "nombre_defautl";
		this.color = "color_default";
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//ToString
	
	@Override
	public String toString() {
		return "Lenguaje [id=" + id + ", nombre=" + nombre + ", color=" + color + "]";
	}
	
	
	
	
}
