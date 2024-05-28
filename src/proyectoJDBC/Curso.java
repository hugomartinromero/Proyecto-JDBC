package proyectoJDBC;

import java.util.ArrayList;
import java.util.Collections;

/**
 * La clase Curso representa un curso escolar con su información básica, incluyendo el nombre, año de inicio,
 * año de fin, módulos asociados y alumnos matriculados.
 */
public class Curso {
    private int idCursoEscolar; // ID del curso escolar
    private String nombre; // Nombre del curso
    private int anioInicio; // Año de inicio del curso
    private int anioFin; // Año de fin del curso
    private ArrayList<Modulo> modulos; // Lista de módulos asociados al curso
    private ArrayList<Alumno> alumnos; // Lista de alumnos matriculados en el curso

    /**
     * Constructor vacío de la clase Curso.
     */
    public Curso() {
    }

    /**
     * Constructor de la clase Curso con parámetros para nombre, año de inicio y año de fin.
     *
     * @param nombre     El nombre del curso.
     * @param anioInicio El año de inicio del curso.
     * @param anioFin    El año de fin del curso.
     */
    public Curso(String nombre, int anioInicio, int anioFin) {
        this.nombre = nombre;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }

    /**
     * Constructor de la clase Curso con parámetros para ID de curso escolar, nombre, año de inicio, año de fin
     * y una lista de alumnos matriculados.
     *
     * @param idCursoEscolar El ID del curso escolar.
     * @param nombre         El nombre del curso.
     * @param anioInicio     El año de inicio del curso.
     * @param anioFin        El año de fin del curso.
     * @param alumnos        La lista de alumnos matriculados en el curso.
     */
    public Curso(int idCursoEscolar, String nombre, int anioInicio, int anioFin, ArrayList<Alumno> alumnos) {
        this.idCursoEscolar = idCursoEscolar;
        this.nombre = nombre;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.alumnos = alumnos;
    }

    /**
     * Obtiene el ID del curso escolar.
     *
     * @return El ID del curso escolar.
     */
    public int getIdCursoEscolar() {
        return idCursoEscolar;
    }

    /**
     * Establece el ID del curso escolar.
     *
     * @param idCursoEscolar El ID del curso escolar a establecer.
     */
    public void setIdCursoEscolar(int idCursoEscolar) {
        this.idCursoEscolar = idCursoEscolar;
    }

    /**
     * Obtiene el nombre del curso.
     *
     * @return El nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del curso.
     *
     * @param nombre El nombre del curso a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el año de inicio del curso.
     *
     * @return El año de inicio del curso.
     */
    public int getAnioInicio() {
        return anioInicio;
    }

    /**
     * Establece el año de inicio del curso.
     *
     * @param anioInicio El año de inicio del curso a establecer.
     */
    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }

    /**
     * Obtiene el año de fin del curso.
     *
     * @return El año de fin del curso.
     */
    public int getAnioFin() {
        return anioFin;
    }

    /**
     * Establece el año de fin del curso.
     *
     * @param anioFin El año de fin del curso a establecer.
     */
    public void setAnioFin(int anioFin) {
        this.anioFin = anioFin;
    }

    /**
     * Obtiene la lista de módulos asociados al curso.
     *
     * @return La lista de módulos asociados al curso.
     */
    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    /**
     * Establece la lista de módulos asociados al curso.
     *
     * @param modulos La lista de módulos a establecer.
     */
    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }

    /**
     * Obtiene la lista de alumnos matriculados en el curso.
     *
     * @return La lista de alumnos matriculados en el curso.
     */
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    /**
     * Establece la lista de alumnos matriculados en el curso.
     *
     * @param alumnos La lista de alumnos a establecer.
     */
    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Retorna una representación en cadena del objeto Curso.
     *
     * @return Una cadena que representa el objeto Curso.
     */
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
