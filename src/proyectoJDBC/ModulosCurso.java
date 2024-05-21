package proyectoJDBC;

public class ModulosCurso {
	private int codigoModulo;
	private int idCursoEscolar;
	
	public ModulosCurso() {
	}
	
	public ModulosCurso(int codigoModulo, int idCursoEscolar) {
		this.codigoModulo = codigoModulo;
		this.idCursoEscolar = idCursoEscolar;
	}

	public int getCodigoModulo() {
		return codigoModulo;
	}

	public void setCodigoModulo(int codigoModulo) {
		this.codigoModulo = codigoModulo;
	}

	public int getIdCursoEscolar() {
		return idCursoEscolar;
	}

	public void setIdCursoEscolar(int idCursoEscolar) {
		this.idCursoEscolar = idCursoEscolar;
	}
	
	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nCódigo módulo: " + this.codigoModulo;
		cadena += "\nID Curso Escolar: " + this.idCursoEscolar;
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
