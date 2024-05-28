package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La clase CursoDAO proporciona métodos para acceder y manipular datos relacionados con los cursos en la base de datos.
 */
public class CursoDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "0100";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	/**
     * Constructor de la clase CursoDAO que establece una conexión con la base de datos.
     */
	public CursoDAO() {
		conexion = conectar();
	}

	/**
     * Establece una conexión con la base de datos.
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
     * Busca cursos por nombre en la base de datos.
     * @param nombre El nombre o parte del nombre del curso a buscar.
     * @return Una lista de cursos que coinciden con el nombre especificado.
     */
	public ArrayList<Curso> buscarCursosPorNombre(String nombre) {
        ArrayList<Curso> cursos = new ArrayList<>();
        String query = "SELECT idcursoescolar, nombre, anioinicio, aniofin FROM cursoescolar WHERE nombre LIKE ?";
        String alumnosQuery = "SELECT persona.dni, persona.nombre, persona.apellidos " +
                "FROM matricula " +
                "JOIN alumno ON matricula.alumnodni = alumno.dni " +
                "JOIN persona ON alumno.dni = persona.dni " +
                "WHERE matricula.cursoescolarid = ?";
        String modulosQuery = "SELECT modulo.codigomodulo, modulo.nombre " +
                "FROM moduloscurso " +
                "JOIN modulo ON moduloscurso.codigomodulo = modulo.codigomodulo " +
                "WHERE modulosCurso.idcursoescolar = (SELECT idcursoescolar FROM cursoescolar WHERE nombre = ?)";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, "%" + nombre + "%");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Curso curso = new Curso();
                    curso.setIdCursoEscolar(rs.getInt("idcursoescolar"));
                    curso.setNombre(rs.getString("nombre"));
                    curso.setAnioInicio(rs.getInt("anioinicio"));
                    curso.setAnioFin(rs.getInt("aniofin"));

                    ArrayList<Alumno> alumnos = new ArrayList<>();
                    try (PreparedStatement alumnosStatement = conexion.prepareStatement(alumnosQuery)) {
                        alumnosStatement.setInt(1, curso.getIdCursoEscolar());
                        try (ResultSet alumnosrs = alumnosStatement.executeQuery()) {
                            while (alumnosrs.next()) {
                                Alumno alumno = new Alumno();
                                alumno.setDni(alumnosrs.getString("dni"));
                                alumno.setNombre(alumnosrs.getString("nombre"));
                                alumno.setApellidos(alumnosrs.getString("apellidos"));
                                alumnos.add(alumno);
                            }
                        }
                    }
                    curso.setAlumnos(alumnos);

                    ArrayList<Modulo> modulos = new ArrayList<>();
                    try (PreparedStatement modulosStatement = conexion.prepareStatement(modulosQuery)) {
                        modulosStatement.setString(1, curso.getNombre());
                        try (ResultSet modulosrs = modulosStatement.executeQuery()) {
                            while (modulosrs.next()) {
                                Modulo modulo = new Modulo();
                                modulo.setCodigoModulo(modulosrs.getString("codigomodulo"));
                                modulo.setNombre(modulosrs.getString("nombre"));
                                modulos.add(modulo);
                            }
                        }
                    }
                    curso.setModulos(modulos);

                    cursos.add(curso);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar los cursos por el nombre: " + e.getMessage());
        }

        return cursos;
    }
	
	/**
     * Busca módulos por el DNI del profesor en la base de datos.
     * @param dniProfesor El DNI del profesor.
     * @return Una lista de módulos impartidos por el profesor especificado.
     */
	public ArrayList<Modulo> buscarModulosPorDniProfesor(String dniProfesor) {
		String modulosQuery = "SELECT codigomodulo, nombre, numerohoras, profesordni FROM modulo WHERE profesordni = ?";
		
		ArrayList<Modulo> modulos = new ArrayList<>();
        try (PreparedStatement modulosStatement = conexion.prepareStatement(modulosQuery)) {
            modulosStatement.setString(1, dniProfesor);
            try (ResultSet modulosrs = modulosStatement.executeQuery()) {
                while (modulosrs.next()) {
                    Modulo modulo = new Modulo();
                    modulo.setCodigoModulo(modulosrs.getString("codigomodulo"));
                    modulo.setNombre(modulosrs.getString("nombre"));
                    modulo.setNumeroHoras(modulosrs.getInt("numerohoras"));
                    modulo.setDniProfesor(modulosrs.getString("profesordni"));
                    modulos.add(modulo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar los módulos por el nombre: " + e.getMessage());
        }
        
        return modulos;
	}
}
