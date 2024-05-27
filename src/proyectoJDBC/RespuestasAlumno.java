package proyectoJDBC;

public class RespuestasAlumno {
	private String dniAlumno;
	private int idPregunta;
	private String respuestaDada;
	private double nota;
	
	public RespuestasAlumno() {
	}
	
	public RespuestasAlumno(String idAlumno, int idPregunta, String respuestaDada, double nota) {
		this.dniAlumno = idAlumno;
		this.idPregunta = idPregunta;
		this.respuestaDada = respuestaDada;
		this.nota = nota;
	}

	public String getIdAlumno() {
		return dniAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.dniAlumno = idAlumno;
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
		cadena += "\nDNI Alumno: " + this.dniAlumno;
		cadena += "\nID Pregunta: " + this.idPregunta;
		cadena += "\nRespuesta Alumno: " + this.respuestaDada;
		cadena += "\nNota: " + this.nota;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
