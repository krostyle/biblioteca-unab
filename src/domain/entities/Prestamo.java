package domain.entities;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo {
    String isbnLibro;
    String runUsuario;
    LocalDate fechaPrestamo;
    LocalDate fechaDevolucion;
    int diasPrestamo;
    double multa;

    public Prestamo(String isbnLibro, String runUsuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion, int diasPrestamo) {
        this.isbnLibro = isbnLibro;
        this.runUsuario = runUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.diasPrestamo = diasPrestamo;
        this.multa=0;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public String getRunUsuario() {
        return runUsuario;
    }

    public void setRunUsuario(String runUsuario) {
        this.runUsuario = runUsuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
