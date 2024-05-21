package proyectoJDBC;

public class Preguntas {
	private int idPregunta;
	private int idExamen;
	private String enunciado;
	private String respuestaCorrecta;
	
	public Preguntas() {
	}
	
	public Preguntas(int idPregunta, int idExamen, String enunciado, String respuestaCorrecta) {
		super();
		this.idPregunta = idPregunta;
		this.idExamen = idExamen;
		this.enunciado = enunciado;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
	
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID Pregunta: " + this.idPregunta;
		cadena += "\nID Examen: " + this.idExamen;
		cadena += "\nEnunciado: " + this.enunciado;
		cadena += "\nRespuesta Correcta: " + this.respuestaCorrecta;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
