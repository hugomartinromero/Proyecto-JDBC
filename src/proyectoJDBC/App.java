package proyectoJDBC;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PersonaDAO personadao = new PersonaDAO();
		
		System.out.println("¿Quién eres?");
		
		String dni = buscarDni();

		
		System.out.println(personadao.buscarAlumno(dni));
		System.out.println(personadao.buscarProfesor(dni));
		
		
		System.out.println("1. Administrar alumno.");
		System.out.println("2. Administrar profesor.");
		System.out.println("3. Administrar curso escolar.");
		System.out.println("4. Administrar módulo.");
		System.out.println("5. Administrar examen.");
		System.out.println("6. Salir.");
		
	}

	private static String buscarDni() {
		Scanner sc = new Scanner(System.in);
		
		String dni;
		
		do {
            System.out.println("Introduce el dni.");
            dni = sc.nextLine();

            if (dni.length() != 9) {
                System.out.println("Introduce el dni de nuevo.");
            }
        } while (dni.length() != 9);
		
		return dni;
	}

}
