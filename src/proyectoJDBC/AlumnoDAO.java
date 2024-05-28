package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnoDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	public AlumnoDAO() {
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

	public Alumno buscarAlumnoPorDni(String dni) {
		Alumno alumno = new Alumno();
		String query = "SELECT persona.dni, persona.nombre, persona.apellidos, persona.telefono, alumno.fechanacimiento "
				+ "FROM alumno " + "JOIN persona ON alumno.dni = persona.dni " + "WHERE persona.dni LIKE ?";

		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setString(1, dni);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					alumno.setDni(rs.getString("dni"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellidos(rs.getString("apellidos"));
					alumno.setTelefono(rs.getString("telefono"));
					alumno.setFechaNacimiento(rs.getString("fechanacimiento"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar el alumno por el DNI: " + e.getMessage());
		}

		return alumno;
	}

	public ArrayList<Alumno> buscarAlumnosPorNombre(String nombre) {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		String query = "SELECT persona.dni, persona.nombre, persona.apellidos, persona.telefono, alumno.fechanacimiento "
				+ "FROM alumno " + "JOIN persona ON alumno.dni = persona.dni " + "WHERE persona.nombre LIKE ?";

		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setString(1, nombre + "%");
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Alumno alumno = new Alumno();
					alumno.setDni(rs.getString("dni"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellidos(rs.getString("apellidos"));
					alumno.setTelefono(rs.getString("telefono"));
					alumno.setFechaNacimiento(rs.getString("fechanacimiento"));
					alumnos.add(alumno);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar los alumnos por el nombre: " + e.getMessage());
		}

		return alumnos;
	}

	public void crearAlumno(Alumno alumno) {
		String insertPersonaQuery = "INSERT INTO persona (dni, nombre, apellidos, telefono) VALUES (?, ?, ?, ?)";
		String insertAlumnoQuery = "INSERT INTO alumno (dni, fechanacimiento) VALUES (?, ?)";

		try (PreparedStatement personaStatement = conexion.prepareStatement(insertPersonaQuery);
				PreparedStatement alumnoStatement = conexion.prepareStatement(insertAlumnoQuery)) {
			personaStatement.setString(1, alumno.getDni());
			personaStatement.setString(2, alumno.getNombre());
			personaStatement.setString(3, alumno.getApellidos());
			personaStatement.setString(4, alumno.getTelefono());
			personaStatement.executeUpdate();

			alumnoStatement.setString(1, alumno.getDni());
			alumnoStatement.setString(2, alumno.getFechaNacimiento());
			alumnoStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al crear el alumno: " + e.getMessage());
		}
	}

	public void modificarAlumno(Alumno alumno, String campo, String valorCampo) {
		String updatePersonaQuery = "UPDATE persona SET " + campo + " = ? WHERE dni = ?";
		String updateAlumnoQuery = "UPDATE alumno SET " + campo + " = ? WHERE dni = ?";

		try {
			if ("fechaNacimiento".equals(campo)) {
				try (PreparedStatement alumnoStatement = conexion.prepareStatement(updateAlumnoQuery)) {
					alumnoStatement.setString(1, valorCampo);
					alumnoStatement.setString(2, alumno.getDni());
					alumnoStatement.executeUpdate();
				}
			} else {
				try (PreparedStatement personaStatement = conexion.prepareStatement(updatePersonaQuery)) {
					personaStatement.setString(1, valorCampo);
					personaStatement.setString(2, alumno.getDni());
					personaStatement.executeUpdate();
				}
			}
			System.out.println("Alumno modificado correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al modificar el alumno: " + e.getMessage());
		}
	}

	public void eliminarAlumno(Alumno alumno) {
		String deleteAlumnoQuery = "DELETE FROM alumno WHERE dni = ?";
		String deletePersonaQuery = "DELETE FROM persona WHERE dni = ?";
		String deleteMatriculaQuery = "DELETE FROM matricula WHERE alumnodni = ?";

		try (PreparedStatement matriculaStatement = conexion.prepareStatement(deleteMatriculaQuery);
				PreparedStatement alumnoStatement = conexion.prepareStatement(deleteAlumnoQuery);
				PreparedStatement personaStatement = conexion.prepareStatement(deletePersonaQuery)) {

			matriculaStatement.setString(1, alumno.getDni());
			matriculaStatement.executeUpdate();

			alumnoStatement.setString(1, alumno.getDni());
			alumnoStatement.executeUpdate();

			personaStatement.setString(1, alumno.getDni());
			personaStatement.executeUpdate();

			System.out.println("Alumno eliminado con éxito.");
		} catch (SQLException e) {
			System.out.println("Error al eliminar el alumno: " + e.getMessage());
		}
	}
}
