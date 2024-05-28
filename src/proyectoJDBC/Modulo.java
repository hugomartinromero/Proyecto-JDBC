package proyectoJDBC;

/**
 * La clase Modulo representa un módulo de un curso escolar.
 */
public class Modulo {
    private String codigoModulo; // Código del módulo
    private String nombre; // Nombre del módulo
    private int numeroHoras; // Número de horas del módulo
    private String dniProfesor; // DNI del profesor que imparte el módulo

    /**
     * Constructor vacío de la clase Modulo.
     */
    public Modulo() {
    }

    /**
     * Constructor de la clase Modulo.
     *
     * @param codigoModulo El código del módulo.
     * @param nombre       El nombre del módulo.
     * @param numeroHoras  El número de horas del módulo.
     * @param dniProfesor  El DNI del profesor que imparte el módulo.
     */
    public Modulo(String codigoModulo, String nombre, int numeroHoras, String dniProfesor) {
        this.codigoModulo = codigoModulo;
        this.nombre = nombre;
        this.numeroHoras = numeroHoras;
        this.dniProfesor = dniProfesor;
    }

    /**
     * Obtiene el código del módulo.
     *
     * @return El código del módulo.
     */
    public String getCodigoModulo() {
        return codigoModulo;
    }

    /**
     * Establece el código del módulo.
     *
     * @param codigoModulo El código del módulo a establecer.
     */
    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    /**
     * Obtiene el nombre del módulo.
     *
     * @return El nombre del módulo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del módulo.
     *
     * @param nombre El nombre del módulo a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de horas del módulo.
     *
     * @return El número de horas del módulo.
     */
    public int getNumeroHoras() {
        return numeroHoras;
    }

    /**
     * Establece el número de horas del módulo.
     *
     * @param numeroHoras El número de horas del módulo a establecer.
     */
    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    /**
     * Obtiene el DNI del profesor que imparte el módulo.
     *
     * @return El DNI del profesor que imparte el módulo.
     */
    public String getDniProfesor() {
        return dniProfesor;
    }

    /**
     * Establece el DNI del profesor que imparte el módulo.
     *
     * @param dniProfesor El DNI del profesor que imparte el módulo a establecer.
     */
    public void setDniProfesor(String dniProfesor) {
        this.dniProfesor = dniProfesor;
    }

    /**
     * Retorna una representación en cadena del objeto Modulo.
     *
     * @return Una cadena que representa el objeto Modulo.
     */
    @Override
    public String toString() {
        String cadena = "\n------------------------------------------";
        cadena += "\nCódigo módulo: " + this.codigoModulo;
        cadena += "\nNombre: " + this.nombre;
        cadena += "\nNº de Horas: " + this.numeroHoras;
        cadena += "\nDNI Profesor: " + this.dniProfesor;
        cadena += "\n------------------------------------------";
        return cadena;
    }
}
