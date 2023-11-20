package infrastructure.console.actions.usuario;

import domain.services.GestorUsuario;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public abstract class CrearUsuarioAccion implements IAccion {
    protected Scanner scanner;
    protected GestorUsuario gestorUsuario;

    public CrearUsuarioAccion(Scanner scanner, GestorUsuario gestorUsuario) {
        this.scanner = scanner;
        this.gestorUsuario = gestorUsuario;
    }

    protected String validarRun() {
        String run;
        while (true) {
            System.out.print("Ingrese el run sin puntos ni guión: ");
            run = scanner.nextLine();
            if (gestorUsuario.validarRun(run)) {
                break;
            }
            System.out.println("Run inválido");
            System.out.println("Vuelva a intentarlo");
        }
        return run;
    }

    protected String validarGenero() {
        char genero;
        while (true) {
            System.out.print("Ingrese el género M ó F: ");
            genero = scanner.nextLine().charAt(0);
            if (gestorUsuario.validarGenero(genero)) {
                break;
            }
            System.out.println("Género inválido, recuerde que debe ser M ó F");
            System.out.println("Vuelva a intentarlo");
        }
        return String.valueOf(genero);
    }
}
