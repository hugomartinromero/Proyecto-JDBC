package proyectoJDBC;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		ProfesorDAO profesorDAO = new ProfesorDAO();
		CursoDAO cursoDAO = new CursoDAO();
		ExamenDAO examenDAO = new ExamenDAO();
		
		System.out.println(examenDAO.buscarExamenesPorAsignatura("Programación"));
		System.out.println(examenDAO.buscarExamenPorTema(1));
		
		
	}
}
