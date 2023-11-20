package domain.interfaces;

import domain.entities.Usuario;

public interface IGestorUsuario {
    void crearUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(String run);
    Usuario buscarUsuario(String run);
    boolean validarRun(String run);
    boolean validarGenero(char genero);
}
