package infrastructure.console.actions.usuario;

import domain.entities.Usuario;
import domain.services.GestorUsuario;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public class BuscarUsuarioAccion implements IAccion {
    private Scanner scanner;
    private GestorUsuario gestorUsuario;

    public BuscarUsuarioAccion(Scanner scanner, GestorUsuario gestorUsuario) {
        this.scanner = scanner;
        this.gestorUsuario = gestorUsuario;
    }
    @Override
    public void ejecutar() {
        System.out.println("Buscar Usuario Por Run");
        System.out.println("==============");
        System.out.print("Ingrese el run: ");
        String run = validarRun();
        Usuario usuario = gestorUsuario.buscarUsuario(run);
        if (usuario != null) {
            System.out.println("Información del usuario");
            System.out.println("==================================");
            System.out.println("Run: " + usuario.getRun());
            System.out.println("Nombre Completo: " + usuario.getNombreCompleto());
            System.out.println("Género: " + usuario.getGenero());
            System.out.println("Libro prestado: " + usuario.getPrestamo());
            System.out.println("==================================");
        } else {
            System.out.println("No se encontró el usuario");
        }
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
