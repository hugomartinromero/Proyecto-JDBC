package proyectoJDBC;

public class Profesor extends Persona {
	private boolean administrador;

	public Profesor() {
		super();
	}

	public Profesor(String dni, String nombre, String apellidos, String telefono, String administrador) {
		super(dni, nombre, apellidos, telefono);
		if (administrador.equals("true")) {
			this.administrador = true;
		} else {
			this.administrador = false;
		}
	}

	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(int administrador) {
		this.administrador = (administrador == 0) ? false : true;
	}

	@Override
	public String toString() {
		String cadena = super.toString();
		cadena += "\nAdministrador: " + this.administrador;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
