package proyectoJDBC;

/**
 * La clase Alumno representa a un alumno, heredando de la clase Persona.
 */
public class Alumno extends Persona {
    private String fechaNacimiento; // Fecha de nacimiento del alumno

    /**
     * Constructor por defecto de la clase Alumno.
     */
    public Alumno() {
        super();
    }

    /**
     * Constructor parametrizado de la clase Alumno.
     * 
     * @param dni             DNI del alumno.
     * @param nombre          Nombre del alumno.
     * @param apellidos       Apellidos del alumno.
     * @param telefono        Teléfono del alumno.
     * @param fechaNacimiento Fecha de nacimiento del alumno.
     */
    public Alumno(String dni, String nombre, String apellidos, String telefono, String fechaNacimiento) {
        super(dni, nombre, apellidos, telefono);
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la fecha de nacimiento del alumno.
     * 
     * @return La fecha de nacimiento del alumno.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del alumno.
     * 
     * @param fechaNacimiento La fecha de nacimiento a establecer.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Retorna una representación en cadena del objeto Alumno.
     * 
     * @return Una cadena que representa el objeto Alumno.
     */
    @Override
    public String toString() {
        String cadena = super.toString();
        cadena += "\nFecha de nacimiento: " + this.fechaNacimiento;
        cadena += "\n------------------------------------------";
        return cadena;
    }
}
