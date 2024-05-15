package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	public PersonaDAO() {
		conexion = conectar();
	}

	private Connection conectar() {
		Connection con = null;
		String url = "jdbc:mysql://" + MAQUINA + "/" + BD;
		
		try {
			con = DriverManager.getConnection(url, USUARIO, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos.");
		}
		
		return con;
	}

	public Alumno buscarAlumno(String dni) {
	    if (conexion != null) {
	        try {
	            Alumno alumnoActual = null;
	            boolean alumnoEncontrado = false;
	            
	            PreparedStatement verificacionAlumno = conexion.prepareStatement("SELECT campo1, campo2, campo3, campo4, campo5 FROM alumno WHERE dni = ?");
	            verificacionAlumno.setString(1, dni);

	            ResultSet alumno = verificacionAlumno.executeQuery();
	            if (alumno.next()) {
	                String campo1 = alumno.getString(1);
	                String campo2 = alumno.getString(2);
	                String campo3 = alumno.getString(3);
	                String campo4 = alumno.getString(4);
	                String campo5 = alumno.getString(5);
	                alumnoActual = new Alumno(campo1, campo2, campo3, campo4, campo5);
	                alumnoEncontrado = true;
	            }
	            
	            if (alumnoEncontrado && alumnoActual != null) {
	                System.out.println("La persona con dni " + dni + " se ha encontrado.");
	                return alumnoActual;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error en la conexión.");
	        }
	    }
	    
	    return null;
	}
	
	public Profesor buscarProfesor(String dni) {
	    if (conexion != null) {
	        try {
	            Profesor profesorActual = null;
	            boolean profesorEncontrado = false;
	            
	            PreparedStatement verificacionProfesor = conexion.prepareStatement("SELECT campo1, campo2, campo3, campo4, campo5 FROM profesor WHERE dni = ?");
	            verificacionProfesor.setString(1, dni);

	            ResultSet profesor = verificacionProfesor.executeQuery();
	            if (profesor.next()) {
	                String campo1 = profesor.getString(1);
	                String campo2 = profesor.getString(2);
	                String campo3 = profesor.getString(3);
	                String campo4 = profesor.getString(4);
	                String campo5 = profesor.getString(5);
	                profesorActual = new Profesor(campo1, campo2, campo3, campo4, campo5);
	                profesorEncontrado = true;
	            }
	            
	            if (profesorEncontrado && profesorActual != null) {
	                System.out.println("La persona con dni " + dni + " se ha encontrado.");
	                return profesorActual;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error en la conexión.");
	        }
	    }
	    
	    return null;
	}

}
