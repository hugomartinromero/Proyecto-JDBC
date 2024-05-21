package proyectoJDBC;

public class Examen {
	private String idExamen;
	private String titulo;
	private int tema;
	private String fechaRealizacion;
	private int codigoModulo;

	public Examen() {
	}
	
	public Examen(String idExamen, String titulo, int tema, String fechaRealizacion, int codigoModulo) {
		this.idExamen = idExamen;
		this.titulo = titulo;
		this.tema = tema;
		this.fechaRealizacion = fechaRealizacion;
		this.codigoModulo = codigoModulo;
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

	public int getCodigoModulo() {
		return codigoModulo;
	}

	public void setCodigoModulo(int codigoModulo) {
		this.codigoModulo = codigoModulo;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID Examen: " + this.idExamen;
		cadena += "\nTítulo: " + this.titulo;
		cadena += "\nTema: " + this.tema;
		cadena += "\nFecha de realización: " + this.fechaRealizacion;
		cadena += "\nCódigo módulo: " + this.codigoModulo;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
