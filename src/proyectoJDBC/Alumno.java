package proyectoJDBC;

public class Alumno extends Persona {
	private String fechaNacimiento;

	public Alumno(String fechaNacimiento) {
		super();
		this.fechaNacimiento = fechaNacimiento;
	}

	public Alumno() {
		super();
	}

	public Alumno(String dni, String nombre, String apellidos, String telefono, String fechaNacimiento) {
		super(dni, nombre, apellidos, telefono);
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return super.toString() + "Alumno [fechaNacimiento=" + fechaNacimiento + "]";
	}
}
