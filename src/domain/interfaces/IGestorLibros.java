package domain.interfaces;

import domain.entities.Libro;

public interface IGestorLibros {
    void crearLibro(Libro libro);
    void actualizarLibro(Libro libro);
    void eliminarLibro(String isbn);
    Libro buscarLibro(String isbn);
    boolean validarISBNUnico(String isbn);
    void validarCantidadBiblioteca(int cantidadEnBiblioteca);
    void validarCantidadDisponible(int cantidadDisponible);
    boolean existeLibro(String isbn);
}
