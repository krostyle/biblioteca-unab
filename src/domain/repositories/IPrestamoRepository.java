package domain.repositories;

import domain.entities.Prestamo;

public interface IPrestamoRepository {
    void crearPresatamo(Prestamo prestamo);
    void actualizarPrestamo(Prestamo prestamo);

    Prestamo buscarPrestamo(String isbn);
    void finalizarPrestamo(Prestamo prestamo);
}
