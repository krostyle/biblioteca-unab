package domain.entities;

public abstract class Usuario {
    private String run;
    private String nombreCompleto;
    private char genero;
    private String prestamo;

    public Usuario(String run, String nombreCompleto, char genero) {
        this.run = run;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.prestamo = "0";
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }
}
