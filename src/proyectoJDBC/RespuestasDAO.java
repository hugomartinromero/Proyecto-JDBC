package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La clase RespuestasDAO proporciona métodos para interactuar con la tabla de respuestas de la base de datos.
 */
public class RespuestasDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	/**
     * Constructor de la clase RespuestasDAO que establece la conexión con la base de datos.
     */
	
	public RespuestasDAO() {
		conexion = conectar();
	}

	/**
     * Establece la conexión con la base de datos.
     * @return La conexión establecida.
     */
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
	
	/**
     * Inserta una respuesta dada por un alumno en la base de datos.
     * @param respuestaAlumno La respuesta dada por el alumno.
     */
	public void insertarRespuestaAlumno(RespuestasAlumno respuestaAlumno) {
        String query = "INSERT INTO respuestasAlumno (alumnodni, preguntaid, respuestadada) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, respuestaAlumno.getIdAlumno());
            statement.setInt(2, respuestaAlumno.getIdPregunta());
            statement.setString(3, respuestaAlumno.getRespuestaDada());
            statement.executeUpdate();
            System.out.println("Respuesta del alumno insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar respuesta del alumno: " + e.getMessage());
        }
    }

	/**
     * Busca las respuestas dadas por un alumno en la base de datos.
     * @param idAlumno El DNI del alumno.
     * @return Una lista de respuestas dadas por el alumno.
     */
    public ArrayList<RespuestasAlumno> buscarRespuestasPorAlumno(String idAlumno) {
    	ArrayList<RespuestasAlumno> respuestasAlumno = new ArrayList<>();
        String query = "SELECT alumnodni, preguntaid, respuestadada FROM respuestasAlumno WHERE alumnodni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, idAlumno);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    RespuestasAlumno respuesta = new RespuestasAlumno(
                            resultSet.getString("alumnodni"),
                            resultSet.getInt("preguntaid"),
                            resultSet.getString("respuestadada")
                    );
                    respuestasAlumno.add(respuesta);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar respuestas del alumno: " + e.getMessage());
        }
        
        return respuestasAlumno;
	}
}
