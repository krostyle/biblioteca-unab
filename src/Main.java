import domain.services.GestorLibro;
import domain.services.GestorPrestamos;
import domain.services.GestorUsuario;
import infrastructure.console.Menu;
import infrastructure.services.LibroRepositoryInMemory;
import infrastructure.services.PrestamoRepositoryInMemory;
import infrastructure.services.UsuarioRepositoryInMemory;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        GestorUsuario gestorUsuario = new GestorUsuario(new UsuarioRepositoryInMemory());
        GestorLibro gestorLibro = new GestorLibro(new LibroRepositoryInMemory());
        GestorPrestamos gestorPrestamo = new GestorPrestamos(gestorLibro,gestorUsuario, new PrestamoRepositoryInMemory());
        Menu menu = new Menu(gestorUsuario,gestorLibro,gestorPrestamo);
        menu.procesarMenus();
    }
}