package infrastructure.services;

import domain.entities.Libro;
import domain.repositories.ILibroRepository;

import java.util.HashMap;
import java.util.Map;

public class LibroRepositoryInMemory implements ILibroRepository {
    private Map<String, Libro> libros = new HashMap<>();

    @Override
    public void agregarLibro(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    @Override
    public void actualizarLibro(Libro libro) {
        libros.put(libro.getIsbn(), libro);
    }

    @Override
    public void eliminarLibro(String isbn) {
        libros.remove(isbn);
    }

    @Override
    public Libro buscarLibro(String isbn) {
        return libros.get(isbn);
    }
}
