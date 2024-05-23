package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	public CursoDAO() {
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

	public ArrayList<Curso> buscarCursosPorNombre(String nombre) {
		ArrayList<Curso> cursos = new ArrayList<>();
		String query = "SELECT idcursoescolar, nombre, anioinicio, aniofin " + "FROM cursoescolar " + "WHERE nombre LIKE ?";

		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setString(1, "%" + nombre + "%");
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Curso curso = new Curso();
					curso.setIdCursoEscolar(rs.getInt("idcursoescolar"));
					curso.setNombre(rs.getString("nombre"));
					curso.setAnioInicio(rs.getInt("anioinicio"));
					curso.setAnioFin(rs.getInt("aniofin"));
					cursos.add(curso);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar los cursos por el nombre: " + e.getMessage());
		}

		return cursos;
	}

}
