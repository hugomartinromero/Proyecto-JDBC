package proyectoJDBC;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoDAOTest {

	@Test
    public void testBuscarAlumnoPorDniExistente() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        
        String dniExistente = "11111111A";
        
        assertNotNull(alumnoDAO.buscarAlumnoPorDni(dniExistente).getDni());
    }
    
    @Test
    public void testBuscarAlumnoPorDniNoExistente() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        
        String dniNoExistente = "99999999Z";
        
        assertNull(alumnoDAO.buscarAlumnoPorDni(dniNoExistente).getDni());
    }
    
    @Test
    public void testCrearAlumno() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        
        String dni = "43121233P";
        String nombre = "Jorgito";
        String apellidos = "Suárez";
        String telefono = "123456789";
        String fechaNacimiento = "2000-01-01";
        
        Alumno nuevoAlumno = new Alumno(dni, nombre, apellidos, telefono, fechaNacimiento);
        
        alumnoDAO.crearAlumno(nuevoAlumno);
        
        assertEquals(nuevoAlumno.getDni(), alumnoDAO.buscarAlumnoPorDni(dni).getDni());
    }
}
