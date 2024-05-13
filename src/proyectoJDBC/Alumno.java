package proyectoJDBC;

import java.time.LocalDate;

public class Alumno extends Persona {
	private LocalDate fechaNacimiento;

	public Alumno(LocalDate fechaNacimiento) {
		super();
		this.fechaNacimiento = fechaNacimiento;
	}

	public Alumno() {
		super();
	}

	public Alumno(String dni, String nombre, String apellidos, String telefono, LocalDate fechaNacimiento) {
		super(dni, nombre, apellidos, telefono);
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return super.toString() + "Alumno [fechaNacimiento=" + fechaNacimiento + "]";
	}
}
