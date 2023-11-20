package infrastructure.console.actions.libro;

import domain.entities.Libro;
import domain.services.GestorLibro;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public class AgregarLibroAccion implements IAccion {
    private Scanner scanner;
    private GestorLibro gestorLibro;


    public AgregarLibroAccion(Scanner scanner, GestorLibro gestorLibro) {
        this.scanner = scanner;
        this.gestorLibro = gestorLibro;
    }
    @Override
    public void ejecutar() {
        System.out.println("Agregar Libro");
        System.out.println("==============");
        System.out.print("Ingrese el ISBN: ");
        String isbn = validarISBN();
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese la cantidad en biblioteca: ");
        int cantidadEnBiblioteca = scanner.nextInt();
        scanner.nextLine();
        Libro libro = new Libro(isbn, titulo, autor, cantidadEnBiblioteca);
        gestorLibro.crearLibro(libro);
        System.out.println("Libro agregado exitosamente");
    }


    private String validarISBN() {
        String isbn;
        while (true) {
            System.out.print("Ingrese el ISBN: ");
            isbn = scanner.nextLine();
            if (gestorLibro.validarISBNUnico(isbn)) {
                break;
            }
            System.out.println("ISBN ya existe");
            System.out.println("Vuelva a intentarlo");
        }
        return isbn;
    }
}
