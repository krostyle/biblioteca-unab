package infrastructure.console.actions.usuario;

import domain.services.GestorUsuario;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public class EliminarUsuarioAccion implements IAccion {
    private Scanner scanner;
    private GestorUsuario gestorUsuario;

    public EliminarUsuarioAccion(Scanner scanner, GestorUsuario gestorUsuario) {
        this.scanner = scanner;
        this.gestorUsuario = gestorUsuario;
    }

    @Override
    public void ejecutar() {
        System.out.println("Eliminar Usuario");
        System.out.println("==============");
        System.out.print("Ingrese el run: ");
        String run = validarRun();
        gestorUsuario.eliminarUsuario(run);
        System.out.println("Usuario eliminado exitosamente");
    }

    protected String validarRun() {
        String run;
        while (true) {
            System.out.print("Ingrese el run: ");
            run = scanner.nextLine();
            if (gestorUsuario.validarRun(run)) {
                break;
            }
            System.out.println("Run inválido");
            System.out.println("Vuelva a intentarlo");
        }
        return run;
    }
}
