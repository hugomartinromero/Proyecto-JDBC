package proyectoJDBC;

/**
 * La clase abstracta Persona representa una persona genérica con atributos básicos.
 */
public abstract class Persona {
    protected String dni; // DNI de la persona
    protected String nombre; // Nombre de la persona
    protected String apellidos; // Apellidos de la persona
    protected String telefono; // Teléfono de la persona

    /**
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param dni       El DNI de la persona.
     * @param nombre    El nombre de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param telefono  El teléfono de la persona.
     */
    public Persona(String dni, String nombre, String apellidos, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return El DNI de la persona.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni El DNI de la persona a establecer.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Los apellidos de la persona a establecer.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el teléfono de la persona.
     *
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     *
     * @param telefono El teléfono de la persona a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Retorna una representación en cadena del objeto Persona.
     *
     * @return Una cadena que representa el objeto Persona.
     */
    @Override
    public String toString() {
        String cadena = "\n------------------------------------------";
        cadena += "\nDNI: " + this.dni;
        cadena += "\nNombre: " + this.nombre;
        cadena += "\nApellidos: " + this.apellidos;
        cadena += "\nTeléfono: " + this.telefono;
        return cadena;
    }
}
