package infrastructure.console.actions.libro;

import domain.entities.Libro;
import domain.services.GestorLibro;
import infrastructure.console.actions.IAccion;

import java.util.Scanner;

public class BuscarLibroAccion implements IAccion {
    private Scanner scanner;
    private GestorLibro gestorLibro;

    public BuscarLibroAccion(Scanner scanner, GestorLibro gestorLibro) {
        this.scanner = scanner;
        this.gestorLibro = gestorLibro;
    }

    @Override
    public void ejecutar() {
        System.out.println("Buscar Libro Por ISBN");
        System.out.println("==============");
        System.out.print("Ingrese el ISBN: ");
        String isbn = scanner.nextLine();
        Libro libro = gestorLibro.buscarLibro(isbn);
        if (libro != null) {
            System.out.println("Información del libro");
            System.out.println("==================================");
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Total Ejemplares En Biblioteca: " + libro.getCantidadEnBiblioteca());
            System.out.println("Cantidad Disponible para prestamo: " + libro.getCantidadDisponible());
            System.out.println(("URL de la imagen: " + libro.getImagen()));
            System.out.println("==================================");
        } else {
            System.out.println("No se encontró el libro");
        }
    }

}
