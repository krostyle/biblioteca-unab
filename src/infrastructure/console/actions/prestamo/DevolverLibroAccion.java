package infrastructure.console.actions.prestamo;

import domain.services.GestorLibro;
import domain.services.GestorPrestamos;
import domain.services.GestorUsuario;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public class DevolverLibroAccion implements IAccion {
    private Scanner scanner;
    private GestorPrestamos gestorPrestamo;
    private GestorLibro gestorLibro;
    private GestorUsuario gestorUsuario;


    public DevolverLibroAccion(Scanner scanner, GestorPrestamos gestorPrestamo, GestorLibro gestorLibro, GestorUsuario gestorUsuario) {
        this.scanner = scanner;
        this.gestorPrestamo = gestorPrestamo;
        this.gestorLibro = gestorLibro;
        this.gestorUsuario = gestorUsuario;
    }

    @Override
    public void ejecutar() {
        System.out.println("Devolver Libro");
        System.out.println("==============");
        System.out.println("Ingrese el ISBN del libro a devolver");
        String isbn = scanner.nextLine();
        if (!validarExistenciaLibro(isbn)) {
            System.out.println("El libro no existe");
            return;
        }
        System.out.println("Ingrese el run del usuario");
        String run = scanner.nextLine();
        if (!validarExistenciaUsuario(run)) {
            System.out.println("El usuario no existe");
            return;
        }
        try {
            gestorPrestamo.devolverLibro(run, isbn);
            generarTicketDevolucion(run, isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void generarTicketDevolucion(String run, String isbn) {
        gestorPrestamo.generarTicketDevolucion(run, isbn);
    }

    public boolean validarExistenciaLibro(String isbn) {
        return gestorLibro.existeLibro(isbn);
    }

    public boolean validarExistenciaUsuario(String run) {
        if (gestorUsuario.buscarUsuario(run) == null) {
            return false;
        } else {
            return true;
        }
    }

}
