package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	public ProfesorDAO() {
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

	public Profesor buscarProfesorPorDni(String dni) {
		Profesor profesor = new Profesor();
		String query = "SELECT persona.dni, persona.nombre, persona.apellidos, persona.telefono, profesor.administrador "
				+ "FROM profesor " + "JOIN persona ON profesor.dni = persona.dni " + "WHERE persona.dni LIKE ?";

		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setString(1, "%" + dni + "%");
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					profesor.setDni(rs.getString("dni"));
					profesor.setNombre(rs.getString("nombre"));
					profesor.setApellidos(rs.getString("apellidos"));
					profesor.setTelefono(rs.getString("telefono"));
					profesor.setAdministrador(rs.getInt("administrador"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar el profesor por el DNI: " + e.getMessage());
		}

		return profesor;
	}

	public ArrayList<Profesor> buscarProfesoresPorNombre(String nombre) {
		ArrayList<Profesor> profesors = new ArrayList<>();
		String query = "SELECT persona.dni, persona.nombre, persona.apellidos, persona.telefono, profesor.administrador "
				+ "FROM profesor " + "JOIN persona ON profesor.dni = persona.dni " + "WHERE persona.nombre LIKE ?";

		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setString(1, nombre + "%");
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Profesor profesor = new Profesor();
					profesor.setDni(rs.getString("dni"));
					profesor.setNombre(rs.getString("nombre"));
					profesor.setApellidos(rs.getString("apellidos"));
					profesor.setTelefono(rs.getString("telefono"));
					profesor.setAdministrador(rs.getInt("administrador"));
					profesors.add(profesor);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar los profesors por el nombre: " + e.getMessage());
		}

		return profesors;
	}

	public void crearProfesor(Profesor profesor) {
		String insertPersonaQuery = "INSERT INTO persona (dni, nombre, apellidos, telefono) VALUES (?, ?, ?, ?)";
		String insertProfesorQuery = "INSERT INTO profesor (dni, administrador) VALUES (?, ?)";

		try (PreparedStatement personaStatement = conexion.prepareStatement(insertPersonaQuery);
				PreparedStatement profesorStatement = conexion.prepareStatement(insertProfesorQuery)) {
			personaStatement.setString(1, profesor.getDni());
			personaStatement.setString(2, profesor.getNombre());
			personaStatement.setString(3, profesor.getApellidos());
			personaStatement.setString(4, profesor.getTelefono());
			personaStatement.executeUpdate();

			profesorStatement.setString(1, profesor.getDni());
			profesorStatement.setString(2, profesor.getAdministrador());
			profesorStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al crear el profesor: " + e.getMessage());
		}
	}

	public void modificarProfesor(Profesor profesor, String campo, String valorCampo) {
		String updatePersonaQuery = "UPDATE persona SET " + campo + " = ? WHERE dni = ?";
		String updateProfesorQuery = "UPDATE profesor SET " + campo + " = ? WHERE dni = ?";

		try {
			if ("administrador".equals(campo)) {
				try (PreparedStatement profesorStatement = conexion.prepareStatement(updateProfesorQuery)) {
					profesorStatement.setString(1, valorCampo);
					profesorStatement.setString(2, profesor.getDni());
					profesorStatement.executeUpdate();
				}
			} else {
				try (PreparedStatement personaStatement = conexion.prepareStatement(updatePersonaQuery)) {
					personaStatement.setString(1, valorCampo);
					personaStatement.setString(2, profesor.getDni());
					personaStatement.executeUpdate();
				}
			}
			System.out.println("Profesor modificado correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al modificar el profesor: " + e.getMessage());
		}
	}

	public void eliminarProfesor(Profesor profesor) {
		String deleteProfesorQuery = "DELETE FROM profesor WHERE dni = ?";
		String deletePersonaQuery = "DELETE FROM persona WHERE dni = ?";
		String updateModuloQuery = "UPDATE modulo SET profesordni = null WHERE profesordni = ?";

		try (PreparedStatement moduloStatement = conexion.prepareStatement(updateModuloQuery);
				PreparedStatement profesorStatement = conexion.prepareStatement(deleteProfesorQuery);
				PreparedStatement personaStatement = conexion.prepareStatement(deletePersonaQuery)) {

			moduloStatement.setString(1, profesor.getDni());
			moduloStatement.executeUpdate();

			profesorStatement.setString(1, profesor.getDni());
			profesorStatement.executeUpdate();

			personaStatement.setString(1, profesor.getDni());
			personaStatement.executeUpdate();

			System.out.println("Profesor eliminado con éxito.");
		} catch (SQLException e) {
			System.out.println("Error al eliminar el profesor: " + e.getMessage());
		}
	}
}
