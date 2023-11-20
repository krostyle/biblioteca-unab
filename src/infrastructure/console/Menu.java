package infrastructure.console;

import domain.services.GestorLibro;
import domain.services.GestorPrestamos;
import domain.services.GestorUsuario;
import infrastructure.console.actions.*;
import infrastructure.console.actions.libro.AgregarLibroAccion;
import infrastructure.console.actions.libro.BuscarLibroAccion;
import infrastructure.console.actions.libro.EliminarLibroAccion;
import infrastructure.console.actions.prestamo.DevolverLibroAccion;
import infrastructure.console.actions.prestamo.PrestarLibroAccion;
import infrastructure.console.actions.usuario.BuscarUsuarioAccion;
import infrastructure.console.actions.usuario.CrearUsuarioDocenteAccion;
import infrastructure.console.actions.usuario.CrearUsuarioEstudianteAccion;
import infrastructure.console.actions.usuario.EliminarUsuarioAccion;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Map<Integer, IAccion> acciones;
    private GestorUsuario gestorUsuario;
    private GestorLibro gestorLibro;
    private GestorPrestamos gestorPrestamo;

    public Menu(GestorUsuario gestorUsuario, GestorLibro gestorLibro, GestorPrestamos gestorPrestamo) {
        this.scanner = new Scanner(System.in);
        this.acciones = new HashMap<>();
        this.gestorUsuario = gestorUsuario;
        this.gestorLibro = gestorLibro;
        this.gestorPrestamo = gestorPrestamo;
        registrarAcciones();
    }

    private int mostrarMenu() {
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Agregar usuario");
        System.out.println("5. Buscar usuario");
        System.out.println("6. Eliminar usuario");
        System.out.println("7. Prestar libro");
        System.out.println("8. Devolver libro");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private int mostrarSubMenuAgregarUsuario() {
        System.out.println("Crear Usuario");
        System.out.println("=============");
        System.out.println("1. Agregar Estudiante");
        System.out.println("2. Agregar Docente");
        System.out.println("3. Volver");
        System.out.print("Seleccione una opción: ");
        try {
            int opcionSubMenu = scanner.nextInt();
            scanner.nextLine();
            return opcionSubMenu;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private void registrarAcciones() {
        acciones.put(1, new AgregarLibroAccion(scanner, gestorLibro));
        acciones.put(2, new BuscarLibroAccion(scanner, gestorLibro));
        acciones.put(3, new EliminarLibroAccion(scanner, gestorLibro));
        acciones.put(4, new CrearUsuarioEstudianteAccion(scanner, gestorUsuario));
        acciones.put(5, new BuscarUsuarioAccion(scanner, gestorUsuario));
        acciones.put(6, new EliminarUsuarioAccion(scanner, gestorUsuario));
        acciones.put(7, new PrestarLibroAccion(scanner, gestorPrestamo, gestorLibro, gestorUsuario));
        acciones.put(8, new DevolverLibroAccion(scanner, gestorPrestamo, gestorLibro, gestorUsuario));
    }

    private void procesarSubMenuAgregarUsuario(GestorUsuario gestorUsuario) {
        int opcion = mostrarSubMenuAgregarUsuario();
        switch (opcion) {
            case 1:
                IAccion accionEstudiante = new CrearUsuarioEstudianteAccion(scanner, gestorUsuario);
                accionEstudiante.ejecutar();
                break;
            case 2:
                IAccion accionDocente = new CrearUsuarioDocenteAccion(scanner, gestorUsuario);
                accionDocente.ejecutar();
                break;
            case 3:
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }

    public void procesarMenus() {
        while (true) {
            int opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    IAccion accionAgregarLibro = acciones.get(opcion);
                    accionAgregarLibro.ejecutar();
                    break;
                case 2:
                    IAccion accionBuscarLibro = acciones.get(opcion);
                    accionBuscarLibro.ejecutar();
                    break;
                case 3:
                    IAccion accionEliminarLibro = acciones.get(opcion);
                    accionEliminarLibro.ejecutar();
                    break;
                case 4:
                    procesarSubMenuAgregarUsuario(gestorUsuario);
                    break;
                case 5:
                    IAccion accionBuscarUsuario = acciones.get(opcion);
                    accionBuscarUsuario.ejecutar();
                    break;
                case 6:
                    IAccion accionEliminarUsuario = acciones.get(opcion);
                    accionEliminarUsuario.ejecutar();
                    break;
                case 7:
                    IAccion accionPrestarLibro = acciones.get(opcion);
                    accionPrestarLibro.ejecutar();
                    break;
                case 8:
                    IAccion accionDevolverLibro = acciones.get(opcion);
                    accionDevolverLibro.ejecutar();
                    break;
                case 9:
                    break;
            }
            if (opcion == 9) {
                break;
            }
        }
    }


}
