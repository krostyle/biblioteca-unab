package infrastructure.console.actions.prestamo;

import domain.services.GestorLibro;
import domain.services.GestorPrestamos;
import domain.services.GestorUsuario;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public class PrestarLibroAccion implements IAccion {
    private Scanner scanner;
    private GestorPrestamos gestorPrestamo;
    private GestorLibro gestorLibro;
    private GestorUsuario gestorUsuario;

    public PrestarLibroAccion(Scanner scanner, GestorPrestamos gestorPrestamo, GestorLibro gestorLibro, GestorUsuario gestorUsuario) {
        this.scanner = scanner;
        this.gestorPrestamo = gestorPrestamo;
        this.gestorLibro = gestorLibro;
        this.gestorUsuario = gestorUsuario;
    }

    @Override
    public void ejecutar() {
        System.out.println("Prestar Libro");
        System.out.println("==============");
        System.out.println("Ingrese el ISBN del libro a prestar");
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
            gestorPrestamo.realizarPrestamo(run, isbn);
            generarTicketPrestamo(run, isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void generarTicketPrestamo(String run, String isbn) {
        gestorPrestamo.generarTicketPrestamo(run, isbn);
    }

    public boolean validarExistenciaLibro(String isbn) {
        return gestorLibro.existeLibro(isbn);
    }

    public boolean validarExistenciaUsuario(String run) {
        gestorUsuario.buscarUsuario(run);
        if (gestorUsuario.buscarUsuario(run) == null) {
            return false;
        } else {
            return true;
        }
    }




}
