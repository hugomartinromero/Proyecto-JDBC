package proyectoJDBC;

public class CursoEscolar {
	private int idCursoEscolar;
	private String nombre;
	private int anioInicio;
	private int anioFin;
	
	public CursoEscolar() {
	}
	
	public CursoEscolar(int idCursoEscolar, String nombre, int anioInicio, int anioFin) {
		this.idCursoEscolar = idCursoEscolar;
		this.nombre = nombre;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
	}

	public int getIdCursoEscolar() {
		return idCursoEscolar;
	}

	public void setIdCursoEscolar(int idCursoEscolar) {
		this.idCursoEscolar = idCursoEscolar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnioInicio() {
		return anioInicio;
	}

	public void setAnioInicio(int anioInicio) {
		this.anioInicio = anioInicio;
	}

	public int getAnioFin() {
		return anioFin;
	}

	public void setAnioFin(int anioFin) {
		this.anioFin = anioFin;
	}

	@Override
	public String toString() {
		return "CursoEscolar [idCursoEscolar=" + idCursoEscolar + ", nombre=" + nombre + ", anioInicio=" + anioInicio
				+ ", anioFin=" + anioFin + "]";
	}
}
