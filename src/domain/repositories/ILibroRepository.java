package domain.repositories;

import domain.entities.Libro;

public interface ILibroRepository {
    void agregarLibro(Libro libro);
    void actualizarLibro(Libro libro);
    void eliminarLibro(String codigo);
    Libro buscarLibro(String codigo) ;
}
