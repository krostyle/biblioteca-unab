package domain.services;

import domain.entities.Estudiante;
import domain.entities.Libro;
import domain.entities.Prestamo;
import domain.entities.Usuario;
import domain.repositories.IPrestamoRepository;


import java.time.LocalDate;
import java.util.Date;

public class GestorPrestamos {
    private GestorLibro gestorLibro;
    private GestorUsuario gestorUsuario;
    private IPrestamoRepository prestamoRepository;


    public GestorPrestamos(GestorLibro gestorLibro, GestorUsuario gestorUsuario, IPrestamoRepository prestamoRepository) {
        this.gestorLibro = gestorLibro;
        this.gestorUsuario = gestorUsuario;
        this.prestamoRepository = prestamoRepository;
    }


    public void realizarPrestamo(String run, String isbn) {
        Libro libro = gestorLibro.buscarLibro(isbn);
        Usuario usuario = gestorUsuario.buscarUsuario(run);

        if (libro.getCantidadDisponible() == 0) {
            throw new RuntimeException("No hay copias disponibles");
        }
        if (usuario.getPrestamo()!="0") {
            throw new RuntimeException("El usuario ya tiene un libro prestado");
        }
        libro.disminuirDisponibilidad();
        usuario.setPrestamo(isbn);
        gestorLibro.actualizarLibro(libro);
        gestorUsuario.actualizarUsuario(usuario);
        int diasPrestamo;
        if (usuario instanceof Estudiante) {
            diasPrestamo = 10;
        } else {
            diasPrestamo = 20;
        }
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDevolucion = fechaActual.plusDays(diasPrestamo);
        Prestamo prestamo = new Prestamo(isbn, run, fechaActual, fechaDevolucion, diasPrestamo);
        prestamoRepository.crearPresatamo(prestamo);
    }

    public void devolverLibro(String run, String isbn) {
        Libro libro = gestorLibro.buscarLibro(isbn);
        Usuario usuario = gestorUsuario.buscarUsuario(run);
        Prestamo prestamo = prestamoRepository.buscarPrestamo(isbn);
        if (usuario.getPrestamo()=="0") {
            throw new RuntimeException("El usuario no tiene un libro prestado");
        }
        libro.aumentarDisponibilidad();
        usuario.setPrestamo("0");
        gestorLibro.actualizarLibro(libro);
        gestorUsuario.actualizarUsuario(usuario);
        prestamo.setFechaDevolucion(LocalDate.now());
        prestamoRepository.actualizarPrestamo(prestamo);
    }

    private double calcularMulta(Prestamo prestamo) {
        int diasRetraso = LocalDate.now().compareTo(prestamo.getFechaDevolucion());
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * 1000;
    }

    public void generarTicketPrestamo(String run, String isbn) {
        Usuario usuario = gestorUsuario.buscarUsuario(run);
        Libro libro = gestorLibro.buscarLibro(isbn);
        Prestamo prestamo = prestamoRepository.buscarPrestamo(isbn);
        System.out.println("Ticket de Prestamo");
        System.out.println("==============");
        System.out.println("Run: " + run);
        System.out.println("Nombre Completo: " + usuario.getNombreCompleto());
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Fecha de prestamo: " + prestamo.getFechaPrestamo());
        System.out.println("Fecha de devolución: " + prestamo.getFechaDevolucion());
        System.out.println("Días de préstamo: " + prestamo.getDiasPrestamo());
    }

    public void generarTicketDevolucion(String run, String isbn) {
        Usuario usuario = gestorUsuario.buscarUsuario(run);
        Libro libro = gestorLibro.buscarLibro(isbn);
        Prestamo prestamo = prestamoRepository.buscarPrestamo(isbn);
        System.out.println("Ticket de Devolución");
        System.out.println("==============");
        System.out.println("Run: " + run);
        System.out.println("Nombre Completo: " + usuario.getNombreCompleto());
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Fecha de prestamo: " + prestamo.getFechaPrestamo());
        System.out.println("Fecha de devolución: " + prestamo.getFechaDevolucion());
        System.out.println("Días de préstamo: " + prestamo.getDiasPrestamo());
        System.out.println("Multa: " + calcularMulta(prestamo));
    }


}
