package domain.repositories;

import domain.entities.Usuario;

public interface IUsuarioRepository {
    void agregarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(String run);
    Usuario buscarUsuario(String run) ;
}
