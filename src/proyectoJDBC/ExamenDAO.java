package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * La clase ExamenDAO proporciona métodos para acceder a la base de datos y realizar operaciones relacionadas con los exámenes.
 */
public class ExamenDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	/**
     * Constructor de la clase ExamenDAO que establece la conexión con la base de datos.
     */
	public ExamenDAO() {
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
     * Busca un examen por su ID en la base de datos.
     * @param id El ID del examen a buscar.
     * @return El examen encontrado.
     */
	public Examen buscarExamenPorId(int id) {
		Examen examen = new Examen();
		String query = "SELECT idexamen, titulo, tema, codigoModulo FROM examen WHERE idexamen = ?";
		String preguntasQuery = "SELECT idpregunta, enunciado, respuestacorrecta FROM preguntas WHERE examenid = ?";

		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					examen.setIdExamen(rs.getInt("idexamen"));
					examen.setTitulo(rs.getString("titulo"));
					examen.setTema(rs.getInt("tema"));
					examen.setCodigoModulo(rs.getString("codigoModulo"));
					
					ArrayList<Pregunta> preguntas = new ArrayList<>();
	                try (PreparedStatement preguntasStatement = conexion.prepareStatement(preguntasQuery)) {
	                    preguntasStatement.setInt(1, examen.getIdExamen());
	                    try (ResultSet rsPreguntas = preguntasStatement.executeQuery()) {
	                        while (rsPreguntas.next()) {
	                            Pregunta pregunta = new Pregunta();
	                            pregunta.setIdPregunta(rsPreguntas.getInt("idpregunta"));
	                            pregunta.setEnunciado(rsPreguntas.getString("enunciado"));
	                            pregunta.setRespuestaCorrecta(rsPreguntas.getString("respuestacorrecta"));
	                            preguntas.add(pregunta);
	                        }
	                    }
	                }
	                examen.setPreguntas(preguntas);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar el examen por el tema: " + e.getMessage());
		}

		return examen;
	}
	
	/**
     * Busca un examen por su tema en la base de datos.
     * @param tema El tema del examen a buscar.
     * @return El examen encontrado.
     */
	public Examen buscarExamenPorTema(int tema) {
		Examen examen = new Examen();
		String query = "SELECT idexamen, titulo, tema, codigoModulo FROM examen WHERE tema = ?";
		String preguntasQuery = "SELECT idpregunta, enunciado, respuestacorrecta FROM preguntas WHERE examenid = ?";

		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setInt(1, tema);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					examen.setIdExamen(rs.getInt("idexamen"));
					examen.setTitulo(rs.getString("titulo"));
					examen.setTema(rs.getInt("tema"));
					examen.setCodigoModulo(rs.getString("codigoModulo"));
					
					ArrayList<Pregunta> preguntas = new ArrayList<>();
	                try (PreparedStatement preguntasStatement = conexion.prepareStatement(preguntasQuery)) {
	                    preguntasStatement.setInt(1, examen.getIdExamen());
	                    try (ResultSet rsPreguntas = preguntasStatement.executeQuery()) {
	                        while (rsPreguntas.next()) {
	                            Pregunta pregunta = new Pregunta();
	                            pregunta.setIdPregunta(rsPreguntas.getInt("idpregunta"));
	                            pregunta.setEnunciado(rsPreguntas.getString("enunciado"));
	                            pregunta.setRespuestaCorrecta(rsPreguntas.getString("respuestacorrecta"));
	                            preguntas.add(pregunta);
	                        }
	                    }
	                }
	                examen.setPreguntas(preguntas);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar el examen por el tema: " + e.getMessage());
		}

		return examen;
	}
	
	/**
     * Busca exámenes por el nombre de un módulo en la base de datos.
     * @param nombre El nombre del módulo.
     * @return La lista de exámenes encontrados.
     */
	public ArrayList<Examen> buscarExamenesPorModulo(String nombre) {
		ArrayList<Examen> examenes = new ArrayList<>();
		String selectQuery = "SELECT idexamen, titulo, tema, codigoModulo FROM examen "
				+ "WHERE codigoModulo = (SELECT codigoModulo FROM modulo WHERE nombre = ?)";
		String preguntasQuery = "SELECT idpregunta, enunciado, respuestacorrecta FROM preguntas WHERE examenid = ?";

		try (PreparedStatement statement = conexion.prepareStatement(selectQuery)) {
			statement.setString(1, nombre);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Examen examen = new Examen();
					examen.setIdExamen(rs.getInt("idexamen"));
					examen.setTitulo(rs.getString("titulo"));
					examen.setTema(rs.getInt("tema"));
					examen.setCodigoModulo(rs.getString("codigoModulo"));
					
					ArrayList<Pregunta> preguntas = new ArrayList<>();
	                try (PreparedStatement preguntasStatement = conexion.prepareStatement(preguntasQuery)) {
	                    preguntasStatement.setInt(1, examen.getIdExamen());
	                    try (ResultSet rsPreguntas = preguntasStatement.executeQuery()) {
	                        while (rsPreguntas.next()) {
	                            Pregunta pregunta = new Pregunta();
	                            pregunta.setIdPregunta(rsPreguntas.getInt("idpregunta"));
	                            pregunta.setEnunciado(rsPreguntas.getString("enunciado"));
	                            pregunta.setRespuestaCorrecta(rsPreguntas.getString("respuestacorrecta"));
	                            preguntas.add(pregunta);
	                        }
	                    }
	                }
	                examen.setPreguntas(preguntas);
	                
					examenes.add(examen);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al listar exámenes por asignatura: " + e.getMessage());
		}

		return examenes;
	}

	/**
     * Crea un nuevo examen en la base de datos.
     * @param examen El examen a crear.
     */
	public void crearExamen(Examen examen) {
        String insertExamenQuery = "INSERT INTO examen (titulo, tema, codigoModulo) VALUES (?, ?, ?)";
        String insertPreguntaQuery = "INSERT INTO preguntas (examenid, enunciado, respuestacorrecta) VALUES (?, ?, ?)";
        String obtenerExamenIdQuery = "SELECT idexamen FROM examen ORDER BY idexamen DESC LIMIT 1";

        try {
            PreparedStatement examenStatement = conexion.prepareStatement(insertExamenQuery);
            examenStatement.setString(1, examen.getTitulo());
            examenStatement.setInt(2, examen.getTema());
            examenStatement.setString(3, examen.getCodigoModulo());
            examenStatement.executeUpdate();

            int examenId = -1;
            try (PreparedStatement obtenerIdStatement = conexion.prepareStatement(obtenerExamenIdQuery);
                 ResultSet resultSet = obtenerIdStatement.executeQuery()) {
                if (resultSet.next()) {
                    examenId = resultSet.getInt("idexamen");
                }
            }

            if (examenId == -1) {
                throw new SQLException("No se pudo obtener el ID del examen generado.");
            }

            for (Pregunta pregunta : examen.getPreguntas()) {
                PreparedStatement preguntaStatement = conexion.prepareStatement(insertPreguntaQuery);
                preguntaStatement.setInt(1, examenId);
                preguntaStatement.setString(2, pregunta.getEnunciado());
                preguntaStatement.setString(3, pregunta.getRespuestaCorrecta());
                preguntaStatement.executeUpdate();
            }

            System.out.println("Examen creado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear el examen: " + e.getMessage());
        }
    }
}
