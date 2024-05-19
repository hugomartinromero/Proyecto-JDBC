package proyectoJDBC;

public class Examen {
	private int idExamen;
	private String titulo;
	private int tema;
	private String fechaRealizacion;
	
	public Examen() {
	}
	
	public Examen(int idExamen, String titulo, int tema, String fechaRealizacion) {
		this.idExamen = idExamen;
		this.titulo = titulo;
		this.tema = tema;
		this.fechaRealizacion = fechaRealizacion;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public String getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	@Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", titulo=" + titulo + ", tema=" + tema
				+ ", fechaRealizacion=" + fechaRealizacion + "]";
	}
}
