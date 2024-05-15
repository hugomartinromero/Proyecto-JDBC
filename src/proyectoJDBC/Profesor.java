package proyectoJDBC;

public class Profesor extends Persona {
	private String especialidad;

	public Profesor() {
		super();
	}

	public Profesor(String dni, String nombre, String apellidos, String telefono, String especialidad) {
		super(dni, nombre, apellidos, telefono);
		this.especialidad = especialidad;
	}

	public String getespecialidad() {
		return especialidad;
	}

	public void setespecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return super.toString() + "Profesor [especialidad=" + especialidad + "]";
	}
}
