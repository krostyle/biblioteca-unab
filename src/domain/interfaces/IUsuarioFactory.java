package domain.interfaces;

import domain.entities.Usuario;

public interface IUsuarioFactory {
    public abstract Usuario crearUsuario(String run, String nombreCompleto, char genero, Object ...args);
}
