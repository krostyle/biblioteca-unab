package domain.entities;

import java.util.List;

public class Docente extends Usuario {
    private String profesion;
    private List<String> gradosAcademicos;

    public Docente(String run, String nameComplete, char genero, String profesion, List<String> gradosAcademicos) {
        super(run, nameComplete, genero);
        this.profesion = profesion;
        this.gradosAcademicos = gradosAcademicos;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<String> getGradosAcademicos() {
        return gradosAcademicos;
    }

    public void setGradosAcademicos(List<String> gradosAcademicos) {
        this.gradosAcademicos = gradosAcademicos;
    }
}
