package infrastructure.console.actions.libro;

import domain.services.GestorLibro;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public class EliminarLibroAccion implements IAccion {
    private Scanner scanner;
    private GestorLibro gestorLibro;

    public EliminarLibroAccion(Scanner scanner, GestorLibro gestorLibro) {
        this.scanner = scanner;
        this.gestorLibro = gestorLibro;
    }

    @Override
    public void ejecutar() {
        System.out.println("Eliminar Libro");
        System.out.println("==============");
        System.out.print("Ingrese el ISBN: ");
        String isbn = validarISBN();
        gestorLibro.eliminarLibro(isbn);
        System.out.println("Libro eliminado exitosamente");
    }
    private String validarISBN() {
        String isbn;
        while (true) {
            System.out.print("Ingrese el ISBN: ");
            isbn = scanner.nextLine();
            if (gestorLibro.existeLibro(isbn)) {
                break;
            }
            System.out.println("Libro no existe, ingrese un ISBN válido");
            System.out.println("Vuelva a intentarlo");
        }
        return isbn;
    }
}
