package application.services;

import domain.entities.Docente;
import domain.entities.Usuario;
import domain.interfaces.IUsuarioFactory;

import java.util.List;

public class DocenteFactory implements IUsuarioFactory {
    @Override
    public Usuario crearUsuario(String run, String nombreCompleto, char genero, Object ...args) {
        String profesion = (String) args[0];
        List<String> gradosAcademicos = (List<String>) args[1];
        return new Docente(run, nombreCompleto, genero, profesion, gradosAcademicos);
    }
}
