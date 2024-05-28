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

		Alumno alumnoActual = null;
		Profesor profesorActual = null;

		String dniActual = null;

		String esAlumno = null;
		String esProfesor = null;

		do {
			System.out.println("Introduce tu DNI:");
			dniActual = sc.nextLine();

			alumnoActual = alumnoDAO.buscarAlumnoPorDni(dniActual);
			profesorActual = profesorDAO.buscarProfesorPorDni(dniActual);

			if (alumnoActual.getDni() == null && profesorActual.getDni() == null) {
				System.out.println("DNI no encontrado.");
			}

			if (alumnoActual.getDni() != null) {
				System.out.println("¿Eres " + alumnoActual.getNombre() + " " + alumnoActual.getApellidos() + "?");
				esAlumno = sc.nextLine();
			}

			if (profesorActual.getDni() != null) {
				System.out.println("¿Eres " + profesorActual.getNombre() + " " + profesorActual.getApellidos() + "?");
				esProfesor = sc.nextLine();
			}
		} while (alumnoActual.getDni() == null && profesorActual.getDni() == null);

		if (alumnoActual.getDni() != null) {
			if (esSi(esAlumno)) {
				int opcionAlumno;

				do {
					System.out.println("1. Modificar alumno actual.");
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
					case 6:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción incorrecta.");
						break;
					}
				} while (opcionAlumno != 6);
			}
		} else if (esSi(esProfesor)) {
			if (profesorActual.getDni() != null) {
				int opcionProfesor = 0;
				do {
					if (profesorActual.getAdministrador()) {
						System.out.println("1. Administrar alumnos.");
						System.out.println("2. Administrar profesores.");
						System.out.println("3. Crear examen.");
						System.out.println("4. Listar información.");
						System.out.println("5. Salir.");
						System.out.println("Introduce una opción (1-5).");
						opcionProfesor = sc.nextInt();

						switch (opcionProfesor) {
						case 1:
							administrarAlumnos(profesorActual);
							break;
						case 2:
							administrarProfesores(profesorActual);
							break;
						case 3:
							crearExamen(profesorActual);
							break;
						case 4:
							listar();
							break;
						case 5:
							System.out.println("Saliendo...");
							break;
						default:
							System.out.println("Opción incorrecta.");
							break;
						}
					} else {
						System.out.println("1. Modificar profesor actual.");
						System.out.println("2. Crear examen.");
						System.out.println("3. Buscar respuestas de un alumno.");
						System.out.println("4. Listar información.");
						System.out.println("5. Salir.");
						System.out.println("Introduce una opción (1-5).");
						opcionProfesor = sc.nextInt();

						switch (opcionProfesor) {
						case 1:
							modificarProfesor(profesorActual);
							break;
						case 2:
							crearExamen(profesorActual);
							break;
						case 3:
							buscarRespuestasAlumno(profesorActual);
							break;
						case 4:
							listar();
							break;
						case 5:
							System.out.println("Saliendo...");
							break;
						default:
							System.out.println("Opción incorrecta.");
							break;
						}
					}
				} while (opcionProfesor != 6);
			} else {
				System.out.println("Error al conectarse.");
			}
		}
	}

	private static void administrarProfesores(Profesor profesorActual) {
		Scanner sc = new Scanner(System.in);

		ProfesorDAO profesorDAO = new ProfesorDAO();

		int opcion;

		do {
			System.out.println("1. Crear profesor");
			System.out.println("2. Modificar profesor.");
			System.out.println("3. Eliminar profesor.");
			System.out.println("4. Salir.");
			System.out.println("Introduce una opción (1-4).");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				crearProfesor(profesorDAO);
				break;
			case 2, 3:
				System.out.println("¿Quieres buscar por DNI o por nombre? (Escribe 'salir' para salir).");
				String opcionBuscar = sc.nextLine();

				Profesor profesor = new Profesor();

				switch (opcionBuscar) {
				case "dni", "DNI":
					System.out.println("Escribe el DNI del profesor.");
					String dni = sc.nextLine();

					profesor = profesorDAO.buscarProfesorPorDni(dni);
					break;
				case "nombre", "Nombre":
					System.out.println("Escribe el nombre del profesor.");
					String nombre = sc.nextLine();

					profesor = profesorDAO.buscarProfesoresPorNombre(nombre).get(0);
					break;
				case "salir":
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción incorrecta.");
					break;
				}

				switch (opcion) {
				case 2:
					modificarProfesor(profesor);
					break;
				case 3:
					profesorDAO.eliminarProfesor(profesor);
					break;
				default:
					System.out.println("Opción incorrecta.");
					break;
				}
				break;
			case 4:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (opcion != 6);
	}

	private static void crearProfesor(ProfesorDAO profesorDAO) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe el DNI.");
		String dni = sc.nextLine();

		System.out.println("Escribe el nombre.");
		String nombre = sc.nextLine();

		System.out.println("Escribe los apellidos.");
		String apellidos = sc.nextLine();

		System.out.println("Escribe el teléfono.");
		String telefono = sc.nextLine();

		System.out.println("¿Es administrador?");
		String administrador = sc.nextLine();

		profesorDAO.crearProfesor(new Profesor(dni, nombre, apellidos, telefono, administrador));
	}

	private static void administrarAlumnos(Profesor profesorActual) {
		Scanner sc = new Scanner(System.in);

		AlumnoDAO alumnoDAO = new AlumnoDAO();

		int opcion;

		do {
			System.out.println("1. Crear alumno");
			System.out.println("2. Modificar alumno.");
			System.out.println("3. Eliminar alumno.");
			System.out.println("4. Matricular alumno.");
			System.out.println("5. Anular matrícula.");
			System.out.println("6. Salir.");
			System.out.println("Introduce una opción (1-6).");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				crearAlumno(alumnoDAO);
				break;
			case 2, 3, 4, 5:
				System.out.println("¿Quieres buscar por DNI o por nombre? (Escribe 'salir' para salir).");
				String opcionBuscar = sc.nextLine();

				Alumno alumno = new Alumno();

				switch (opcionBuscar) {
				case "dni", "DNI":
					System.out.println("Escribe el DNI del alumno.");
					String dni = sc.nextLine();

					alumno = alumnoDAO.buscarAlumnoPorDni(dni);
					break;
				case "nombre", "Nombre":
					System.out.println("Escribe el nombre del alumno.");
					String nombre = sc.nextLine();

					alumno = alumnoDAO.buscarAlumnosPorNombre(nombre).get(0);
					break;
				case "salir":
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción incorrecta.");
					break;
				}

				switch (opcion) {
				case 2:
					modificarAlumno(alumno);
					break;
				case 3:
					alumnoDAO.eliminarAlumno(alumno);
					break;
				case 4:
					matricularAlumno(alumno);
					break;
				case 5:
					anularMatricula(alumno);
					break;
				default:
					System.out.println("Opción incorrecta.");
					break;
				}
				break;
			case 6:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (opcion != 6);
	}

	private static void crearAlumno(AlumnoDAO alumnoDAO) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe el DNI.");
		String dni = sc.nextLine();

		System.out.println("Escribe el nombre.");
		String nombre = sc.nextLine();

		System.out.println("Escribe los apellidos.");
		String apellidos = sc.nextLine();

		System.out.println("Escribe el teléfono.");
		String telefono = sc.nextLine();

		System.out.println("Escribe la fecha de nacimiento.");
		String fechaNacimiento = sc.nextLine();

		alumnoDAO.crearAlumno(new Alumno(dni, nombre, apellidos, telefono, fechaNacimiento));
	}

	private static void modificarProfesor(Profesor profesorActual) {
		Scanner sc = new Scanner(System.in);

		ProfesorDAO profesorDAO = new ProfesorDAO();

		String[] campo = { "nombre", "apellidos", "telefono", "administrador" };

		int opcion;

		do {
			System.out.println("¿Qué quieres modificar?");
			System.out.println("1. Nombre.");
			System.out.println("2. Apellidos.");
			System.out.println("3. Teléfono.");
			System.out.println("4. Administrador.");
			System.out.println("5. Salir.");
			System.out.println("Introduce una opción (1-5).");

			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1, 2, 3:
				System.out.println("Escribe el nuevo " + campo[opcion - 1] + ".");
				String valorNuevo = sc.nextLine();

				profesorDAO.modificarProfesor(profesorActual, campo[opcion - 1], valorNuevo);
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (opcion != 5);
	}

	private static void crearExamen(Profesor profesorActual) {
		Scanner sc = new Scanner(System.in);

		CursoDAO cursoDAO = new CursoDAO();
		ExamenDAO examenDAO = new ExamenDAO();

		System.out.println("Escribe el título del examen.");
		String titulo = sc.nextLine();

		System.out.println("Escribe el tema.");
		int tema = sc.nextInt();
		sc.nextLine();

		examenDAO.crearExamen(new Examen(titulo, tema,
				cursoDAO.buscarModulosPorDniProfesor(profesorActual.getDni()).get(0).getCodigoModulo(),
				pedirPreguntasExamen()));
	}

	private static ArrayList<Pregunta> pedirPreguntasExamen() {
		Scanner sc = new Scanner(System.in);

		ArrayList<Pregunta> preguntas = new ArrayList<>();

		String enunciado;
		String respuesta;

		do {
			System.out.println("Escribe el enunciado (Escribe 'fin' para salir).");
			enunciado = sc.nextLine();
			if (!enunciado.equalsIgnoreCase("fin")) {
				System.out.println("Escribe la respuesta correcta.");
				respuesta = sc.nextLine();
				preguntas.add(new Pregunta(enunciado, respuesta));
			}
		} while (!enunciado.equalsIgnoreCase("fin"));

		return preguntas;
	}

	private static void buscarRespuestasAlumno(Profesor profesorActual) {
		Scanner sc = new Scanner(System.in);

		RespuestasDAO respuestasDAO = new RespuestasDAO();

		System.out.println("Introduce el DNI del alumno.");
		String dniAlumno = sc.nextLine();

		for (RespuestasAlumno respuestas : respuestasDAO.buscarRespuestasPorAlumno(dniAlumno)) {
			System.out.println(respuestas);
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
				System.out.println("Saliendo...");
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
			case 5:
				System.out.println("Saliendo...");
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
			case "dni", "DNI":
				System.out.println("Escribe el DNI del alumno.");
				String dni = sc.nextLine();

				System.out.println(alumnoDAO.buscarAlumnoPorDni(dni));
				break;
			case "nombre", "Nombre":
				System.out.println("Escribe el nombre del alumno.");
				String nombre = sc.nextLine();

				System.out.println(alumnoDAO.buscarAlumnosPorNombre(nombre));
				break;
			case "salir":
				System.out.println("Saliendo...");
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
			case "dni", "DNI":
				System.out.println("Escribe el DNI del profesor.");
				String dni = sc.nextLine();

				System.out.println(profesorDAO.buscarProfesorPorDni(dni));
				break;
			case "nombre", "Nombre":
				System.out.println("Escribe el nombre del profesor.");
				String nombre = sc.nextLine();

				System.out.println(profesorDAO.buscarProfesoresPorNombre(nombre));
				break;
			case "salir":
				System.out.println("Saliendo...");
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
			case "salir":
				System.out.println("Saliendo...");
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
			case "tema", "Tema":
				System.out.println("Escribe el tema.");
				int tema = sc.nextInt();
				sc.nextLine();

				System.out.println(examenDAO.buscarExamenPorTema(tema));
				break;
			case "modulo", "módulo", "Modulo", "Módulo":
				System.out.println("Escribe el nombre del módulo.");
				String nombre = sc.nextLine();

				System.out.println(examenDAO.buscarExamenesPorModulo(nombre));
				break;
			case "id", "Id", "ID":
				System.out.println("Escribe el id del examen.");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println(examenDAO.buscarExamenPorId(id));
				break;
			case "salir":
				System.out.println("Saliendo...");
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

		System.out.println("Escribe el id del examen que quieras realizar.");
		int id = sc.nextInt();
		sc.nextLine();

		Examen examen = examenDAO.buscarExamenPorId(id);

		for (int i = 0; i < examen.getPreguntas().size(); i++) {
			System.out.println(examen.getPreguntas().get(i).getEnunciado());
			String respuesta = sc.nextLine();

			RespuestasAlumno respuestaAlumno = new RespuestasAlumno(alumnoActual.getDni(),
					examen.getPreguntas().get(i).getIdPregunta(), respuesta);

			respuestasDAO.insertarRespuestaAlumno(respuestaAlumno);
		}
	}

	private static boolean esSi(String opcion) {
		return (opcion != null)
				&& (opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("sí") || opcion.equalsIgnoreCase("s"));
	}
}
