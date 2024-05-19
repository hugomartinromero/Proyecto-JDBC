package proyectoJDBC;

public class Modulo {
	private int codigoModulo;
	private int numeroHoras;
	
	public Modulo() {
	}
	
	public Modulo(int codigoModulo, int numeroHoras) {
		this.codigoModulo = codigoModulo;
		this.numeroHoras = numeroHoras;
	}

	public int getCodigoModulo() {
		return codigoModulo;
	}

	public void setCodigoModulo(int codigoModulo) {
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
