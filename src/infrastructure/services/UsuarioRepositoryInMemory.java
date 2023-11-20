package infrastructure.services;

import domain.entities.Usuario;
import domain.repositories.IUsuarioRepository;

import java.util.HashMap;
import java.util.Map;

public class UsuarioRepositoryInMemory implements IUsuarioRepository {
    private Map<String, Usuario> usuarios = new HashMap<>();

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getRun(), usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarios.put(usuario.getRun(), usuario);
    }

    @Override
    public void eliminarUsuario(String run) {
        usuarios.remove(run);
    }

    @Override
    public Usuario buscarUsuario(String run) {
        return usuarios.get(run);
    }
}
