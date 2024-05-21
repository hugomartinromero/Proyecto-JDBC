package proyectoJDBC;

public class RespuestasAlumno {
	private String idAlumno;
	private int idPregunta;
	private String respuestaDada;
	private double nota;
	
	public RespuestasAlumno() {
	}
	
	public RespuestasAlumno(String idAlumno, int idPregunta, String respuestaDada, double nota) {
		this.idAlumno = idAlumno;
		this.idPregunta = idPregunta;
		this.respuestaDada = respuestaDada;
		this.nota = nota;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getRespuestaDada() {
		return respuestaDada;
	}

	public void setRespuestaDada(String respuestaDada) {
		this.respuestaDada = respuestaDada;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID Alumno: " + this.idAlumno;
		cadena += "\nID Pregunta: " + this.idPregunta;
		cadena += "\nRespuesta Alumno: " + this.respuestaDada;
		cadena += "\nNota: " + this.nota;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
