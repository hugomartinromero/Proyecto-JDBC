package proyectoJDBC;

import java.util.ArrayList;

public class Profesor extends Persona {
	private ArrayList<String> especialidades;

	public Profesor() {
		super();
	}

	public Profesor(String dni, String nombre, String apellidos, String telefono, ArrayList<String> especialidades) {
		super(dni, nombre, apellidos, telefono);
		this.especialidades = especialidades;
	}

	public ArrayList<String> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(ArrayList<String> especialidades) {
		this.especialidades = especialidades;
	}

	@Override
	public String toString() {
		return super.toString() + "Profesor [especialidades=" + especialidades + "]";
	}
}
