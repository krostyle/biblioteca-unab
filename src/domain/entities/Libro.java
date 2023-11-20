package domain.entities;

public class Libro {
    String isbn;
    String titulo;
    String autor;
    int cantidadEnBiblioteca;
    int cantidadDisponible;
    String imagen;

    public Libro(String isbn, String titulo, String autor, int cantidadEnBiblioteca ) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadEnBiblioteca = cantidadEnBiblioteca;
        this.cantidadDisponible = cantidadEnBiblioteca;
        this.imagen = "https://servidorbiblioteca.com/imagen"+isbn+".jpg";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadEnBiblioteca() {
        return cantidadEnBiblioteca;
    }

    public void setCantidadEnBiblioteca(int cantidadEnBiblioteca) {
        this.cantidadEnBiblioteca = cantidadEnBiblioteca;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void disminuirDisponibilidad(){
        this.cantidadDisponible--;
    }

    public void aumentarDisponibilidad(){
        this.cantidadDisponible++;
    }
}
