package application.services;

import domain.entities.Estudiante;
import domain.entities.Usuario;
import domain.interfaces.IUsuarioFactory;

public class EstudianteFactory implements IUsuarioFactory {
    @Override
    public Usuario crearUsuario(String run, String nombreCompleto, char genero, Object ...args) {
        String carrera = (String) args[0];
        return new Estudiante(run, nombreCompleto, genero, carrera);
    }
}
