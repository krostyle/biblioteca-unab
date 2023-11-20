package infrastructure.services;

import domain.entities.Prestamo;
import domain.repositories.IPrestamoRepository;

import java.util.HashMap;
import java.util.Map;

public class PrestamoRepositoryInMemory implements IPrestamoRepository{
    private Map<String, Prestamo> prestamos = new HashMap<>();

    @Override
    public void crearPresatamo(Prestamo prestamo) {
        prestamos.put(prestamo.getIsbnLibro(), prestamo);
    }

    @Override
    public void finalizarPrestamo(Prestamo prestamo) {
        prestamos.remove(prestamo.getIsbnLibro());
    }

    @Override
    public void actualizarPrestamo(Prestamo prestamo) {
        prestamos.put(prestamo.getIsbnLibro(), prestamo);
    }

    @Override
    public Prestamo buscarPrestamo(String isbn) {
        return prestamos.get(isbn);
    }
}
