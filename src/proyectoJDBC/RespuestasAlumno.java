package proyectoJDBC;

public class RespuestasAlumno {
	private String dniAlumno;
	private int idPregunta;
	private String respuestaDada;
	
	public RespuestasAlumno() {
	}
	
	public RespuestasAlumno(String idAlumno, int idPregunta, String respuestaDada) {
		this.dniAlumno = idAlumno;
		this.idPregunta = idPregunta;
		this.respuestaDada = respuestaDada;
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

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nDNI Alumno: " + this.dniAlumno;
		cadena += "\nID Pregunta: " + this.idPregunta;
		cadena += "\nRespuesta Alumno: " + this.respuestaDada;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
