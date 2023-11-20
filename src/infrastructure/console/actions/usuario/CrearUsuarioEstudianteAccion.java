package infrastructure.console.actions.usuario;

import domain.entities.Estudiante;
import domain.services.GestorUsuario;
import infrastructure.console.actions.usuario.CrearUsuarioAccion;

import java.util.Scanner;

public class CrearUsuarioEstudianteAccion extends CrearUsuarioAccion {
    public CrearUsuarioEstudianteAccion(Scanner scanner, GestorUsuario gestorUsuario) {
        super(scanner, gestorUsuario);
    }
    @Override
    public void ejecutar() {
        System.out.println("Crear Usuario Estudiante");
        System.out.println("=============");
        System.out.println();
        String run = validarRun();
        System.out.print("Ingrese el nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese el género: ");
        char genero = validarGenero().charAt(0);
        System.out.print("Ingrese la carrera: ");
        String carrera = scanner.nextLine();
        Estudiante estudiante = new Estudiante(run, nombreCompleto, genero, carrera);
        gestorUsuario.crearUsuario(estudiante);
        System.out.println("Usuario creado exitosamente");
    }
}
