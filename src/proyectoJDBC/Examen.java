package proyectoJDBC;

import java.util.ArrayList;

public class Examen {
	private int idExamen;
	private String codigoModulo;
	private String titulo;
	private int tema;
	private ArrayList<Pregunta> preguntas;

	public Examen() {
	}

	public Examen(String titulo, int tema, String codigoModulo, ArrayList<Pregunta> preguntas) {
		this.titulo = titulo;
		this.tema = tema;
		this.codigoModulo = codigoModulo;
		this.preguntas = preguntas;
	}

	public Examen(int idExamen, String titulo, int tema, String codigoModulo, ArrayList<Pregunta> preguntas) {
		this.idExamen = idExamen;
		this.titulo = titulo;
		this.tema = tema;
		this.codigoModulo = codigoModulo;
		this.preguntas = preguntas;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
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

	public String getCodigoModulo() {
		return codigoModulo;
	}

	public void setCodigoModulo(String codigoModulo) {
		this.codigoModulo = codigoModulo;
	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		String cadena = "\n------------------------------------------";
		cadena += "\nID Examen: " + this.idExamen;
		cadena += "\nCódigo módulo: " + this.codigoModulo;
		cadena += "\nTítulo: " + this.titulo;
		cadena += "\nTema: " + this.tema;
		cadena += "\nPreguntas: ";
		if (preguntas != null) {
			for (Pregunta pregunta : preguntas) {
				if (pregunta != null) {
					cadena += "\n\t" + pregunta.getEnunciado();
					cadena += "\n\t" + pregunta.getRespuestaCorrecta();
				}
			}
		} else {
			cadena += "\nNo hay preguntas.";
		}
		cadena += "\n------------------------------------------";
		return cadena;
	}
}
