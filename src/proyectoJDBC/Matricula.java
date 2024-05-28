package proyectoJDBC;

/**
 * La clase Matricula representa la matrícula de un alumno en un curso escolar.
 */
public class Matricula {
    private String dniAlumno; // DNI del alumno matriculado
    private String idCursoEscolar; // ID del curso escolar en el que se matriculó el alumno

    /**
     * Constructor por defecto de la clase Matricula.
     */
    public Matricula() {
    }

    /**
     * Constructor de la clase Matricula con parámetros.
     *
     * @param dniAlumno       El DNI del alumno.
     * @param idCursoEscolar  El ID del curso escolar.
     */
    public Matricula(String dniAlumno, String idCursoEscolar) {
        this.dniAlumno = dniAlumno;
        this.idCursoEscolar = idCursoEscolar;
    }

    /**
     * Obtiene el DNI del alumno matriculado.
     *
     * @return El DNI del alumno matriculado.
     */
    public String getDniAlumno() {
        return dniAlumno;
    }

    /**
     * Establece el DNI del alumno matriculado.
     *
     * @param dniAlumno El DNI del alumno matriculado a establecer.
     */
    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    /**
     * Obtiene el ID del curso escolar en el que se matriculó el alumno.
     *
     * @return El ID del curso escolar en el que se matriculó el alumno.
     */
    public String getIdCursoEscolar() {
        return idCursoEscolar;
    }

    /**
     * Establece el ID del curso escolar en el que se matriculó el alumno.
     *
     * @param idCursoEscolar El ID del curso escolar a establecer.
     */
    public void setIdCursoEscolar(String idCursoEscolar) {
        this.idCursoEscolar = idCursoEscolar;
    }

    /**
     * Retorna una representación en cadena del objeto Matricula.
     *
     * @return Una cadena que representa el objeto Matricula.
     */
    @Override
    public String toString() {
        String cadena = "\n------------------------------------------";
        cadena += "\nID DNI Alumno: " + this.dniAlumno;
        cadena += "\nID Curso Escolar: " + this.idCursoEscolar;
        cadena += "\n------------------------------------------";
        return cadena;
    }
}
