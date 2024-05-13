package proyectoJDBC;

public class Examen {
	private String idExamen;
	private String titulo;
	private int numeroPreguntas;
	private int fechaRealizacion;
	
	public Examen() {
	}
	
	public Examen(String idExamen, String titulo, int numeroPreguntas, int fechaRealizacion) {
		this.idExamen = idExamen;
		this.titulo = titulo;
		this.numeroPreguntas = numeroPreguntas;
		this.fechaRealizacion = fechaRealizacion;
	}

	public String getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(String idExamen) {
		this.idExamen = idExamen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumeroPreguntas() {
		return numeroPreguntas;
	}

	public void setNumeroPreguntas(int numeroPreguntas) {
		this.numeroPreguntas = numeroPreguntas;
	}

	public int getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(int fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	@Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", titulo=" + titulo + ", numeroPreguntas=" + numeroPreguntas
				+ ", fechaRealizacion=" + fechaRealizacion + "]";
	}
}
