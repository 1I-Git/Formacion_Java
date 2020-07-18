package ws.unai.modelo;

public class Rol {
	
	public static final int ADMINISTRADOR = 1;
	public static final int USUARIO = 2;
	
	private int id;
	private String rol;
	
	//Constructores
	public Rol() {
		super();
		this.id = 1;
		this.rol = "";
	}
	
	public Rol( int id ) {
		this();
		this.id = id;		
	}
	
	//Getter&Setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + rol + "]";
	}
	
}
