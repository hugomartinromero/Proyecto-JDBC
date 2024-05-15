package proyectoJDBC;

public abstract class Persona {
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected String telefono;
	
	public Persona() {
	}
	
	public Persona(String dni, String nombre, String apellidos, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nDNI: " + this.dni;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nApellidos: " + this.apellidos;
		cadena += "\nTeléfono: " + this.telefono;
		return cadena;
	}
}
