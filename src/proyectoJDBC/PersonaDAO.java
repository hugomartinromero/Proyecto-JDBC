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

				PreparedStatement verificacionAlumno = conexion.prepareStatement("SELECT dni, nombre, apellidos, telefono, fechaNacimiento FROM alumno WHERE dni = ?");
				verificacionAlumno.setString(1, dni);

				ResultSet alumno = verificacionAlumno.executeQuery();
				if (alumno.next()) {
					String dniAlumno = alumno.getString(1);
					String nombreAlumno = alumno.getString(2);
					String apellidosAlumno = alumno.getString(3);
					String telefonoAlumno = alumno.getString(4);
					String fechaNacimientoAlumno = alumno.getString(5);
					
					Alumno alumnoActual = new Alumno(dniAlumno, nombreAlumno, apellidosAlumno, telefonoAlumno, fechaNacimientoAlumno);
					
					return alumnoActual;
				} else {
					System.out.println("No se encontró ninguna persona con dni " + dni);
				}
			} catch (SQLException e) {
				System.out.println("Error en la conexión: " + e.getMessage());

			}
		} else {
			System.out.println("No se ha podido conectar.");
		}
		return null;
	}

	public Profesor buscarProfesor(String dni) {
		if (conexion != null) {
			try {

				PreparedStatement verificacionProfesor = conexion.prepareStatement("SELECT dni, nombre, apellidos, telefono, administrador FROM profesor WHERE dni = ?");
				verificacionProfesor.setString(1, dni);

				ResultSet profesor = verificacionProfesor.executeQuery();
				if (profesor.next()) {
					String dniProfesor = profesor.getString(1);
					String nombreProfesor = profesor.getString(2);
					String apellidosProfesor = profesor.getString(3);
					String telefonoProfesor = profesor.getString(4);
					String administradorProfesor = profesor.getString(5);
					
					Profesor profesorActual = new Profesor(dniProfesor, nombreProfesor, apellidosProfesor, telefonoProfesor, administradorProfesor);
					
					return profesorActual;
				} else {
					System.out.println("No se encontró ninguna persona con dni " + dni);
				}
			} catch (SQLException e) {
				System.out.println("Error en la conexión: " + e.getMessage());

			}
		} else {
			System.out.println("No se ha podido conectar.");
		}
		return null;
	}

}
