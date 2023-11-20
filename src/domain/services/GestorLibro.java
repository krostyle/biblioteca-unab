package domain.services;

import domain.entities.Libro;
import domain.interfaces.IGestorLibros;
import domain.repositories.ILibroRepository;

public class GestorLibro implements IGestorLibros {
    private ILibroRepository libroRepository;

    public GestorLibro(ILibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public void crearLibro(Libro libro) {
        if (existeLibro(libro.getIsbn())) {
            throw new RuntimeException("El libro ya existe");
        }
        libroRepository.agregarLibro(libro);
    }

    @Override
    public void actualizarLibro(Libro libro) {
        libroRepository.actualizarLibro(libro);
    }

    @Override
    public void eliminarLibro(String codigo) {
        libroRepository.eliminarLibro(codigo);
    }

    @Override
    public Libro buscarLibro(String codigo) {
        if (!existeLibro(codigo)) {
            System.out.println("No se encontró el libro");
        }
        return libroRepository.buscarLibro(codigo);
    }

    @Override
    public boolean validarISBNUnico(String isbn) {
        return libroRepository.buscarLibro(isbn) == null;
    }

    @Override
    public void validarCantidadBiblioteca(int cantidadEnBiblioteca) {
        if (cantidadEnBiblioteca < 0) {
            throw new RuntimeException("Cantidad en biblioteca inválida");
        }
    }

    @Override
    public void validarCantidadDisponible(int cantidadDisponible) {
        if (cantidadDisponible < 0) {
            throw new RuntimeException("Cantidad disponible inválida");
        }
    }

    @Override
    public boolean existeLibro(String isbn) {
        return libroRepository.buscarLibro(isbn) != null;
    }
}
