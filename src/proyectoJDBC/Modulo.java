package proyectoJDBC;

public class Modulo {
	private String codigoModulo;
	private String nombre;
	private int numeroHoras;
	private String dniProfesor;
	
	public Modulo() {
	}
	
	public Modulo(String codigoModulo, String nombre, int numeroHoras, String dniProfesor) {
		this.codigoModulo = codigoModulo;
		this.nombre = nombre;
		this.numeroHoras = numeroHoras;
		this.dniProfesor = dniProfesor;
	}

	public String getCodigoModulo() {
		return codigoModulo;
	}

	public void setCodigoModulo(String codigoModulo) {
		this.codigoModulo = codigoModulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public String getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(String dniProfesor) {
		this.dniProfesor = dniProfesor;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nCódigo módulo: " + this.codigoModulo;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nNº de Horas: " + this.numeroHoras;
		cadena += "\nDNI Profesor: " + this.dniProfesor;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
