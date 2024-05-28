package proyectoJDBC;

/**
 * La clase Profesor representa a un profesor, heredando de la clase Persona.
 */
public class Profesor extends Persona {
    private boolean administrador; // Indica si el profesor es administrador (true) o no (false)

    /**
     * Constructor vacío de la clase Profesor.
     */
    public Profesor() {
        super();
    }

    /**
     * Constructor de la clase Profesor.
     *
     * @param dni            El DNI del profesor.
     * @param nombre         El nombre del profesor.
     * @param apellidos      Los apellidos del profesor.
     * @param telefono       El número de teléfono del profesor.
     * @param administrador Indica si el profesor es administrador (true) o no (false).
     */
    public Profesor(String dni, String nombre, String apellidos, String telefono, String administrador) {
        super(dni, nombre, apellidos, telefono);
        if (administrador.equals("true")) {
            this.administrador = true;
        } else {
            this.administrador = false;
        }
    }

    /**
     * Obtiene el estado de administrador del profesor.
     * 
     * @return true si el profesor es administrador, false si no lo es.
     */
    public boolean getAdministrador() {
        return administrador;
    }

    /**
     * Establece si el profesor es administrador o no.
     *
     * @param administrador 0 si no es administrador, 1 si lo es.
     */
    public void setAdministrador(int administrador) {
        this.administrador = (administrador == 0) ? false : true;
    }

    /**
     * Retorna una representación en cadena del objeto Profesor.
     *
     * @return Una cadena que representa el objeto Profesor.
     */
    @Override
    public String toString() {
        String cadena = super.toString();
        cadena += "\nAdministrador: " + this.administrador;
        cadena += "\n------------------------------------------";
        return cadena;
    }
}
