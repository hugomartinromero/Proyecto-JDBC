package proyectoJDBC;

/**
 * La clase RespuestasAlumno representa las respuestas dadas por un alumno a una pregunta en un examen.
 */
public class RespuestasAlumno {
    private String dniAlumno; // El DNI del alumno que responde
    private int idPregunta; // El ID de la pregunta a la que se responde
    private String respuestaDada; // La respuesta dada por el alumno

    /**
     * Constructor vacío de la clase RespuestasAlumno.
     */
    public RespuestasAlumno() {
    }

    /**
     * Constructor de la clase RespuestasAlumno.
     *
     * @param idAlumno     El DNI del alumno que responde.
     * @param idPregunta    El ID de la pregunta a la que se responde.
     * @param respuestaDada La respuesta dada por el alumno.
     */
    public RespuestasAlumno(String idAlumno, int idPregunta, String respuestaDada) {
        this.dniAlumno = idAlumno;
        this.idPregunta = idPregunta;
        this.respuestaDada = respuestaDada;
    }

    /**
     * Obtiene el DNI del alumno que responde.
     *
     * @return El DNI del alumno.
     */
    public String getIdAlumno() {
        return dniAlumno;
    }

    /**
     * Establece el DNI del alumno que responde.
     *
     * @param idAlumno El DNI del alumno.
     */
    public void setIdAlumno(String idAlumno) {
        this.dniAlumno = idAlumno;
    }

    /**
     * Obtiene el ID de la pregunta a la que se responde.
     *
     * @return El ID de la pregunta.
     */
    public int getIdPregunta() {
        return idPregunta;
    }

    /**
     * Establece el ID de la pregunta a la que se responde.
     *
     * @param idPregunta El ID de la pregunta.
     */
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    /**
     * Obtiene la respuesta dada por el alumno.
     *
     * @return La respuesta dada por el alumno.
     */
    public String getRespuestaDada() {
        return respuestaDada;
    }

    /**
     * Establece la respuesta dada por el alumno.
     *
     * @param respuestaDada La respuesta dada por el alumno.
     */
    public void setRespuestaDada(String respuestaDada) {
        this.respuestaDada = respuestaDada;
    }

    /**
     * Retorna una representación en cadena del objeto RespuestasAlumno.
     *
     * @return Una cadena que representa el objeto RespuestasAlumno.
     */
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
