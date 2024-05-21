package proyectoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModulosCursoDAO {
	private Connection conexion;

	private final String USUARIO = "root";
	private final String PASSWORD = "root";
	private final String MAQUINA = "localhost";
	private final String BD = "proyectoJDBC";

	public ModulosCursoDAO() {
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
}
