package proyectoJDBC;

import java.util.ArrayList;

/**
 * La clase Examen representa un examen asociado a un módulo.
 */
public class Examen {
    private int idExamen; // ID del examen
    private String codigoModulo; // Código del módulo asociado al examen
    private String titulo; // Título del examen
    private int tema; // Tema del examen
    private ArrayList<Pregunta> preguntas; // Lista de preguntas asociadas al examen

    /**
     * Constructor por defecto de la clase Examen.
     */
    public Examen() {
    }

    /**
     * Constructor de la clase Examen.
     *
     * @param titulo       El título del examen.
     * @param tema         El tema del examen.
     * @param codigoModulo El código del módulo asociado al examen.
     * @param preguntas    Las preguntas asociadas al examen.
     */
    public Examen(String titulo, int tema, String codigoModulo, ArrayList<Pregunta> preguntas) {
        this.titulo = titulo;
        this.tema = tema;
        this.codigoModulo = codigoModulo;
        this.preguntas = preguntas;
    }

    /**
     * Constructor de la clase Examen.
     *
     * @param idExamen     El ID del examen.
     * @param titulo       El título del examen.
     * @param tema         El tema del examen.
     * @param codigoModulo El código del módulo asociado al examen.
     * @param preguntas    Las preguntas asociadas al examen.
     */
    public Examen(int idExamen, String titulo, int tema, String codigoModulo, ArrayList<Pregunta> preguntas) {
        this.idExamen = idExamen;
        this.titulo = titulo;
        this.tema = tema;
        this.codigoModulo = codigoModulo;
        this.preguntas = preguntas;
    }

    /**
     * Obtiene el ID del examen.
     *
     * @return El ID del examen.
     */
    public int getIdExamen() {
        return idExamen;
    }

    /**
     * Establece el ID del examen.
     *
     * @param idExamen El ID del examen a establecer.
     */
    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    /**
     * Obtiene el título del examen.
     *
     * @return El título del examen.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del examen.
     *
     * @param titulo El título del examen a establecer.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el tema del examen.
     *
     * @return El tema del examen.
     */
    public int getTema() {
        return tema;
    }

    /**
     * Establece el tema del examen.
     *
     * @param tema El tema del examen a establecer.
     */
    public void setTema(int tema) {
        this.tema = tema;
    }

    /**
     * Obtiene el código del módulo asociado al examen.
     *
     * @return El código del módulo asociado al examen.
     */
    public String getCodigoModulo() {
        return codigoModulo;
    }

    /**
     * Establece el código del módulo asociado al examen.
     *
     * @param codigoModulo El código del módulo asociado al examen a establecer.
     */
    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    /**
     * Obtiene la lista de preguntas asociadas al examen.
     *
     * @return La lista de preguntas asociadas al examen.
     */
    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    /**
     * Establece la lista de preguntas asociadas al examen.
     *
     * @param preguntas La lista de preguntas asociadas al examen a establecer.
     */
    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * Retorna una representación en cadena del objeto Examen.
     *
     * @return Una cadena que representa el objeto Examen.
     */
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
