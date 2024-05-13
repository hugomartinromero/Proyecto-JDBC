package proyectoJDBC;

public class Modulo {
	private String codigoModulo;
	private int numeroHoras;
	
	public Modulo() {
	}
	
	public Modulo(String codigoModulo, int numeroHoras) {
		this.codigoModulo = codigoModulo;
		this.numeroHoras = numeroHoras;
	}

	public String getCodigoModulo() {
		return codigoModulo;
	}

	public void setCodigoModulo(String codigoModulo) {
		this.codigoModulo = codigoModulo;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	@Override
	public String toString() {
		return "Modulo [codigoModulo=" + codigoModulo + ", numeroHoras=" + numeroHoras + "]";
	}
}
