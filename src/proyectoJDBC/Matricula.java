package proyectoJDBC;

public class Matricula {
	private String dniAlumno;
	private String idCursoEscolar;
	
	public Matricula() {
	}
	
	public Matricula(String dniAlumno, String idCursoEscolar) {
		this.dniAlumno = dniAlumno;
		this.idCursoEscolar = idCursoEscolar;
	}

	public String getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public String getIdCursoEscolar() {
		return idCursoEscolar;
	}

	public void setIdCursoEscolar(String idCursoEscolar) {
		this.idCursoEscolar = idCursoEscolar;
	}
	
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID DNI Alumno: " + this.dniAlumno;
		cadena += "\nID Curso Escolar: " + this.idCursoEscolar;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
