package ws.unai.modelo;

public class Usuario {
	//Atributos
	
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String pass;
	private String imagen;
	private Rol rol;
	
	//Constructores
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "name_default";
		this.apellido = "apellido_default";
		this.correo = "correo_default";
		this.pass = "pass_default";
		this.imagen = "no_image";
		this.rol = new Rol();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	//ToString
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", pass="
				+ pass + ", imagen=" + imagen + ", rol=" + rol + "]";
	}
	
	
	

	
	
	
	
	
	
	
}
