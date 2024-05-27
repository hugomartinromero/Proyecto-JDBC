package proyectoJDBC;

import java.util.ArrayList;
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
		
		System.out.println("Introduce tu DNI:");
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
					case 3:
						anularMatricula(alumnoActual);
						break;
					case 4:
						listar();
						break;
					case 5:
						realizarExamen(alumnoActual);
						break;
					default:
						System.out.println("Opción incorrecta.");
						break;
					}
				} while (opcionAlumno != 6);
			}
		}
	}

	private static void modificarAlumno(Alumno alumnoActual) {
		Scanner sc = new Scanner(System.in);

		AlumnoDAO alumnoDAO = new AlumnoDAO();

		String[] campo = {"nombre", "apellidos", "telefono", "fechaNacimiento"};

		int opcion;

		do {
			System.out.println("¿Qué quieres modificar?");
			System.out.println("1. Nombre.");
			System.out.println("2. Apellidos.");
			System.out.println("3. Teléfono.");
			System.out.println("4. Fecha de nacimiento.");
			System.out.println("5. Salir.");
			System.out.println("Introduce una opción (1-5).");

			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1, 2, 3, 4:
				System.out.println("Escribe el nuevo " + campo[opcion - 1] + ".");
				String valorNuevo = sc.nextLine();

				alumnoDAO.modificarAlumno(alumnoActual, campo[opcion - 1], valorNuevo);
				break;
			case 5:
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (opcion != 5);
	}

	private static void matricularAlumno(Alumno alumnoActual) {
		Scanner sc = new Scanner(System.in);

		CursoDAO cursoDAO = new CursoDAO();
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		
		String curso;
		Curso cursoMatricula;

		do {
			System.out.println("¿En qué curso te quieres matricular?");
			curso = sc.nextLine();
			
			cursoMatricula = cursoDAO.buscarCursosPorNombre(curso).get(0);
		} while (!cursoMatricula.getNombre().equalsIgnoreCase(curso));
		
		matriculaDAO.matricularAlumno(alumnoActual, cursoMatricula);
	}

	private static void anularMatricula(Alumno alumnoActual) {
		Scanner sc = new Scanner(System.in);

		CursoDAO cursoDAO = new CursoDAO();
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		
		String curso;
		Curso cursoMatricula;

		do {
			System.out.println("¿En qué curso quieres anular tu matricula?");
			curso = sc.nextLine();
			
			cursoMatricula = cursoDAO.buscarCursosPorNombre(curso).get(0);
		} while (!cursoMatricula.getNombre().equalsIgnoreCase(curso));
		
		matriculaDAO.anularMatricula(alumnoActual, cursoMatricula);
	}

	private static void listar() {
		Scanner sc = new Scanner(System.in);

		AlumnoDAO alumnoDAO = new AlumnoDAO();
		CursoDAO cursoDAO = new CursoDAO();
		ExamenDAO examenDAO = new ExamenDAO();
		ProfesorDAO profesorDAO = new ProfesorDAO();

		int opcion;
		
		do {
			System.out.println("1. Listar alumnos.");
			System.out.println("2. Listar profesores.");
			System.out.println("3. Listar cursos.");
			System.out.println("4. Listar examenes.");
			System.out.println("5. Salir.");
			System.out.println("Introduce una opción (1-5):");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				listarAlumnos(alumnoDAO);
				break;
			case 2:
				listarProfesores(profesorDAO);
				break;
			case 3:
				listarCursos(cursoDAO);
				break;
			case 4:
				listarExamenes(examenDAO);
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (opcion != 5);

	}

	private static void listarAlumnos(AlumnoDAO alumnoDAO) {
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;

		do {
			System.out.println("¿Quieres buscar por DNI o por nombre? (Escribe 'salir' para salir).");
			String opcion = sc.nextLine();
			
			switch (opcion) {
			case "dni", "DNI" :
				System.out.println("Escribe el DNI del alumno.");
				String dni = sc.nextLine();
				
				System.out.println(alumnoDAO.buscarAlumnoPorDni(dni));
				break;
			case "nombre", "Nombre" :
				System.out.println("Escribe el nombre del alumno.");
				String nombre = sc.nextLine();
				
				System.out.println(alumnoDAO.buscarAlumnosPorNombre(nombre));
				break;
			case "salir" :
				salir = true;
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (!salir);
	}

	private static void listarProfesores(ProfesorDAO profesorDAO) {
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;

		do {
			System.out.println("¿Quieres buscar por DNI o por nombre? (Escribe 'salir' para salir).");
			String opcion = sc.nextLine();
			
			switch (opcion) {
			case "dni", "DNI" :
				System.out.println("Escribe el DNI del profesor.");
				String dni = sc.nextLine();
				
				System.out.println(profesorDAO.buscarProfesorPorDni(dni));
				break;
			case "nombre", "Nombre" :
				System.out.println("Escribe el nombre del profesor.");
				String nombre = sc.nextLine();
				
				System.out.println(profesorDAO.buscarProfesoresPorNombre(nombre));
				break;
			case "salir" :
				salir = true;
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (!salir);
	}

	private static void listarCursos(CursoDAO cursoDAO) {
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;

		do {
			System.out.println("Escribe el nombre del curso o 'salir' para salir.");
			String nombre = sc.nextLine();
			
			switch (nombre) {
			case "salir" :
				salir = true;
				break;
			default:
				System.out.println(cursoDAO.buscarCursosPorNombre(nombre));
				break;
			}
		} while (!salir);
	}

	private static void listarExamenes(ExamenDAO examenDAO) {
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;

		do {
			System.out.println("¿Quieres buscar por tema, por módulo o por id? (Escribe 'salir' para salir).");
			String opcion = sc.nextLine();
			
			switch (opcion) {
			case "tema", "Tema" :
				System.out.println("Escribe el tema.");
				int tema = sc.nextInt();
				sc.nextLine();
				
				System.out.println(examenDAO.buscarExamenPorTema(tema));
				break;
			case "modulo", "módulo", "Modulo", "Módulo" :
				System.out.println("Escribe el nombre del módulo.");
				String nombre = sc.nextLine();
				
				System.out.println(examenDAO.buscarExamenesPorModulo(nombre));
				break;
			case "id", "Id", "ID" :
				System.out.println("Escribe el id del examen.");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.println(examenDAO.buscarExamenPorId(id));
				break;
			case "salir" :
				salir = true;
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (!salir);
	}

	private static void realizarExamen(Alumno alumnoActual) {
		Scanner sc = new Scanner(System.in);
		
		ExamenDAO examenDAO = new ExamenDAO();
		RespuestasDAO respuestasDAO = new RespuestasDAO();
		
		listarExamenes(examenDAO);
		System.out.println("Escribe el id del examen que quieras realizar.");
		int id = sc.nextInt();
		sc.nextLine();
		
		Examen examen = examenDAO.buscarExamenPorId(id);
		
		for (int i = 0; i < examen.getPreguntas().size(); i++) {
			System.out.println(examen.getPreguntas().get(i).getEnunciado());
			String respuesta = sc.nextLine();
			
			RespuestasAlumno respuestaAlumno = new RespuestasAlumno(alumnoActual.getDni(), examen.getPreguntas().get(i).getIdPregunta(), respuesta, calcularNota(examen.getPreguntas().get(i), respuesta));
			
			respuestasDAO.insertarRespuestaAlumno(respuestaAlumno);
		}
	}

	private static int calcularNota(Pregunta pregunta, String respuesta) {
		String[] arrayRespuesta = pregunta.getRespuestaCorrecta().split(" ");
		String[] arrayRespuestaAlumno = respuesta.split(" ");
		int nota = 0;
        
        for (String palabraRespuesta : arrayRespuesta) {
            for (String palabraRespuestaAlumno : arrayRespuestaAlumno) {
            	if (palabraRespuesta.equalsIgnoreCase(palabraRespuestaAlumno)) {
            		nota++;
            	}
            }
        }
        
        return nota / arrayRespuesta.length;
    }

	private static boolean esSi(String opcion) {
		if (opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("sí") || opcion.equalsIgnoreCase("s")) {
			return true;
		}
		return false;
	}
}
