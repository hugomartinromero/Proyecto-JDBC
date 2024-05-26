package proyectoJDBC;

import java.util.ArrayList;
import java.util.Collections;

public class Curso {
	private int idCursoEscolar;
	private String nombre;
	private int anioInicio;
	private int anioFin;
	private ArrayList<Modulo> modulos;
	private ArrayList<Alumno> alumnos;
	
	public Curso() {
	}
	
	public Curso(String nombre, int anioInicio, int anioFin) {
		this.nombre = nombre;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
	}
	
	public Curso(int idCursoEscolar, String nombre, int anioInicio, int anioFin, ArrayList<Alumno> alumnos) {
		this.idCursoEscolar = idCursoEscolar;
		this.nombre = nombre;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
		this.alumnos = alumnos;
	}

	public int getIdCursoEscolar() {
		return idCursoEscolar;
	}

	public void setIdCursoEscolar(int idCursoEscolar) {
		this.idCursoEscolar = idCursoEscolar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnioInicio() {
		return anioInicio;
	}

	public void setAnioInicio(int anioInicio) {
		this.anioInicio = anioInicio;
	}

	public int getAnioFin() {
		return anioFin;
	}

	public void setAnioFin(int anioFin) {
		this.anioFin = anioFin;
	}

	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID Curso Escolar: " + this.idCursoEscolar;
		cadena += "\nNombre: " + this.nombre;
		cadena += "\nAño inicio: " + this.anioInicio;
		cadena += "\nAño fin: " + this.anioFin;
		cadena += "\nMódulos: ";
		if (modulos != null) {
			for (Modulo modulo : modulos) {
				if (modulo != null) {
					cadena += "\n\t" + modulo.getNombre();
				}
			}
		} else {
			cadena += "\nNo hay módulos.";
		}
		Collections.sort(alumnos, (a1, a2) -> a1.getApellidos().compareTo(a2.getApellidos()));
		cadena += "\nAlumnos matriculados: ";
		if (alumnos != null) {
			for (Alumno alumno : alumnos) {
				if (alumno != null) {
					cadena += "\n\t" + alumno.getDni() + ": " + alumno.getApellidos() + ", " + alumno.getNombre();
				}
			}
		} else {
			cadena += "\nNo hay alumnos matriculados.";
		}
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
