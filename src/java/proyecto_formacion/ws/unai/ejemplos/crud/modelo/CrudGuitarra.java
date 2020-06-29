package ws.unai.ejemplos.crud.modelo;

public class CrudGuitarra {
	
	// Variables
	
	private int id;
	private int precio;
	private String nombre;
	private String marca;
	private String informacion;
	private String img_guitarra;
	private String img_marca;
	
	//Constructores
	
	public CrudGuitarra() {
		super();
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getImg_guitarra() {
		return img_guitarra;
	}

	public void setImg_guitarra(String img_guitarra) {
		this.img_guitarra = img_guitarra;
	}

	public String getImg_marca() {
		return img_marca;
	}

	public void setImg_marca(String img_marca) {
		this.img_marca = img_marca;
	}
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	//ToString
	
	@Override
	public String toString() {
		return "CrudGuitarra [id=" + id + ", precio=" + precio + ", nombre=" + nombre + ", marca=" + marca
				+ ", informacion=" + informacion + ", img_guitarra=" + img_guitarra + ", img_marca=" + img_marca + "]";
	}
	

	

	
	
	

}
