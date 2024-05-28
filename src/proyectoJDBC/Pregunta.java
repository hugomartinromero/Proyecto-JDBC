package proyectoJDBC;

/**
 * La clase Pregunta representa una pregunta en un examen con su enunciado y respuesta correcta.
 */
public class Pregunta {
    private int idPregunta; // ID de la pregunta
    private int idExamen; // ID del examen al que pertenece la pregunta
    private String enunciado; // Enunciado de la pregunta
    private String respuestaCorrecta; // Respuesta correcta de la pregunta

    /**
     * Constructor vacío de la clase Pregunta.
     */
    public Pregunta() {
    }

    /**
     * Constructor de la clase Pregunta.
     *
     * @param enunciado         El enunciado de la pregunta.
     * @param respuestaCorrecta La respuesta correcta de la pregunta.
     */
    public Pregunta(String enunciado, String respuestaCorrecta) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Constructor de la clase Pregunta.
     *
     * @param idPregunta         El ID de la pregunta.
     * @param idExamen           El ID del examen al que pertenece la pregunta.
     * @param enunciado         El enunciado de la pregunta.
     * @param respuestaCorrecta La respuesta correcta de la pregunta.
     */
    public Pregunta(int idPregunta, int idExamen, String enunciado, String respuestaCorrecta) {
        this.idPregunta = idPregunta;
        this.idExamen = idExamen;
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Obtiene el ID de la pregunta.
     *
     * @return El ID de la pregunta.
     */
    public int getIdPregunta() {
        return idPregunta;
    }

    /**
     * Establece el ID de la pregunta.
     *
     * @param idPregunta El ID de la pregunta.
     */
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    /**
     * Obtiene el ID del examen al que pertenece la pregunta.
     *
     * @return El ID del examen.
     */
    public int getIdExamen() {
        return idExamen;
    }

    /**
     * Establece el ID del examen al que pertenece la pregunta.
     *
     * @param idExamen El ID del examen.
     */
    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    /**
     * Obtiene el enunciado de la pregunta.
     *
     * @return El enunciado de la pregunta.
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Establece el enunciado de la pregunta.
     *
     * @param enunciado El enunciado de la pregunta.
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Obtiene la respuesta correcta de la pregunta.
     *
     * @return La respuesta correcta de la pregunta.
     */
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    /**
     * Establece la respuesta correcta de la pregunta.
     *
     * @param respuestaCorrecta La respuesta correcta de la pregunta.
     */
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    /**
     * Retorna una representación en cadena del objeto Pregunta.
     *
     * @return Una cadena que representa el objeto Pregunta.
     */
    @Override
    public String toString() {
        String cadena = "\n------------------------------------------";
        cadena += "\nID Pregunta: " + this.idPregunta;
        cadena += "\nID Examen: " + this.idExamen;
        cadena += "\nEnunciado: " + this.enunciado;
        cadena += "\nRespuesta Correcta: " + this.respuestaCorrecta;
        cadena += "\n------------------------------------------";
        return cadena;
    }
}
