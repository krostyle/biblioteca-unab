package domain.entities;

public class Estudiante extends Usuario{
    private String carrera;

    public Estudiante(String run, String nameComplete, char genero, String carrera) {
        super(run, nameComplete, genero);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
