package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculaDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	public MatriculaDAO() {
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
	
	public void matricularAlumno(Alumno alumno, Curso curso) {
        if (curso == null) {
            System.out.println("El curso no existe.");
            return;
        }
        if (alumno == null) {
            System.out.println("El alumno no existe.");
            return;
        }

        if (alumnoEstaMatriculado(alumno, curso)) {
            System.out.println("El alumno ya está matriculado en este curso.");
            return;
        }

        String query = "INSERT INTO matricula (alumnodni, cursoescolarid) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, alumno.getDni());
            statement.setInt(2, curso.getIdCursoEscolar());
            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Alumno matriculado con éxito en el curso.");
            } else {
                System.out.println("No se pudo matricular al alumno en el curso.");
            }
        } catch (SQLException e) {
            System.out.println("Error al matricular al alumno: " + e.getMessage());
        }
    }

	private boolean alumnoEstaMatriculado(Alumno alumno, Curso curso) {
	    String query = "SELECT COUNT(*) FROM matricula WHERE alumnodni = ? AND cursoescolarid = ?";
	    
	    try (PreparedStatement statement = conexion.prepareStatement(query)) {
	        statement.setString(1, alumno.getDni());
	        statement.setInt(2, curso.getIdCursoEscolar());
	        try (ResultSet rs = statement.executeQuery()) {
	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al verificar si el alumno está matriculado: " + e.getMessage());
	    }
	    return false;
	}
}
