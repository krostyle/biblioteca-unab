package domain.services;

import domain.entities.Usuario;
import domain.interfaces.IGestorUsuario;
import domain.repositories.IUsuarioRepository;

public class GestorUsuario implements IGestorUsuario {
    private IUsuarioRepository usuarioRepository;

    public GestorUsuario(IUsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        usuarioRepository.agregarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(String run) {
        usuarioRepository.eliminarUsuario(run);
    }

    @Override
    public Usuario buscarUsuario(String run) {
        if (!validarRun(run)) {
            System.out.println("El run ingresado no es válido");
        }
        return usuarioRepository.buscarUsuario(run);
    }

    @Override
    public boolean validarRun(String run) {
        if (run.length() != 9) {
            return false;
        }
        int suma = 0;
        int[] serie = {2, 3, 4, 5, 6, 7, 2, 3};
        for (int i = run.length() - 2; i >= 0; i--) {
            int digito = Integer.parseInt(run.substring(i, i + 1));
            suma += digito * serie[run.length() - 2 - i];
        }
        int resto = suma % 11;
        int dv = 11 - resto;
        if (dv == 11) {
            dv = 0;
        } else if (dv == 10) {
            dv = 1;
        }
        return dv == Integer.parseInt(run.substring(run.length() - 1));
    }

    @Override
    public boolean validarGenero(char genero) {
        return genero == 'M' || genero == 'F';
    }
}
