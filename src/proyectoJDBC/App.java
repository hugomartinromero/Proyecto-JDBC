package proyectoJDBC;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		CursoDAO cursoDAO = new CursoDAO();
		ExamenDAO examenDAO = new ExamenDAO();
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		ProfesorDAO profesorDAO = new ProfesorDAO();
		RespuestasDAO respuestasDAO = new RespuestasDAO();

		System.out.println("Introduce tu DNI: ");
		String dniActual = sc.nextLine();

		Alumno alumnoActual = alumnoDAO.buscarAlumnoPorDni(dniActual);
		Profesor profesorActual = profesorDAO.buscarProfesorPorDni(dniActual);

		if (alumnoActual.getDni() != null) {
			System.out.println("¿Eres " + alumnoActual.getNombre() + " " + alumnoActual.getApellidos() + "?");
		}

		if (profesorActual.getDni() != null) {
			System.out.println("¿Eres " + profesorActual.getNombre() + " " + profesorActual.getApellidos() + "?");
		}

		String opcion = sc.nextLine();

		if (esSi(opcion)) {
			if (alumnoActual.getDni() != null) {
				int opcionAlumno;

				do {
					System.out.println("1. Modificar alumno.");
					System.out.println("2. Matricularse en un curso.");
					System.out.println("3. Anular matrícula.");
					System.out.println("4. Listar información.");
					System.out.println("5. Realizar examen.");
					System.out.println("6. Salir.");
					System.out.println("Introduce una opción (1-6).");
					opcionAlumno = sc.nextInt();

					switch (opcionAlumno) {
					case 1:
						modificarAlumno(alumnoActual);
						break;
					case 2:
						matricularAlumno(alumnoActual);
						break;
					}
				} while (opcionAlumno != 6);
			}
		}
	}

	private static void modificarAlumno(Alumno alumnoActual) {
		Scanner sc = new Scanner(System.in);

		AlumnoDAO alumnoDAO = new AlumnoDAO();

		String[] campo = { "nombre", "apellidos", "telefono", "fechaNacimiento" };

		int opcion;

		do {
			System.out.println("¿Qué quieres modificar?");
			System.out.println("1. Nombre.");
			System.out.println("2. Apellidos.");
			System.out.println("3. Teléfono.");
			System.out.println("4. Fecha de nacimiento.");
			System.out.println("5. Salir.");

			opcion = sc.nextInt();
			sc.nextLine();

			System.out.println("Escribe el nuevo " + campo[opcion - 1] + ".");
			String valorNuevo = sc.nextLine();

			alumnoDAO.modificarAlumno(alumnoActual, campo[opcion - 1], valorNuevo);
		} while (opcion != 5);
	}

	private static void matricularAlumno(Alumno alumnoActual) {
		// TODO Auto-generated method stub

	}

	public static boolean esSi(String opcion) {
		if (opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("sí") || opcion.equalsIgnoreCase("s")) {
			return true;
		}
		return false;
	}
}
