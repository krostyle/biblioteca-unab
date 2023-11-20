package infrastructure.console.actions.usuario;

import domain.entities.Docente;
import domain.services.GestorUsuario;
import infrastructure.console.actions.usuario.CrearUsuarioAccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrearUsuarioDocenteAccion extends CrearUsuarioAccion {
    public CrearUsuarioDocenteAccion(Scanner scanner, GestorUsuario gestorUsuario) {
        super(scanner, gestorUsuario);
    }
    @Override
    public void ejecutar() {
        System.out.println("Crear Usuario Docente");
        System.out.println("=============");
        System.out.println();
        String run = validarRun();
        System.out.print("Ingrese el nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese el género: ");
        char genero = validarGenero().charAt(0);
        String profesion = scanner.nextLine();
        List<String> gradosAcademicos = seleccionarGradosAcademicos();
        Docente docente = new Docente(run, nombreCompleto, genero, profesion, gradosAcademicos);
        gestorUsuario.crearUsuario(docente);
        System.out.println("Usuario creado exitosamente");
    }

    private List<String> seleccionarGradosAcademicos() {
        List<String> gradosAcademicos = new ArrayList<>();
        boolean seleccionado = true;
        while (seleccionado) {
            System.out.println("Seleccione el grado académico del docente: ");
            System.out.println("1. Magister");
            System.out.println("2. Doctorado");
            System.out.println("3. Ambos");
            System.out.println("4. Ninguno");
            System.out.println("5. Finalizar Selección");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    if(!gradosAcademicos.contains("Magister")) {
                        gradosAcademicos.add("Magister");
                    } else {
                        System.out.println("Ya ha seleccionado este grado académico");
                    }
                    break;
                case 2:
                    if(!gradosAcademicos.contains("Doctorado")) {
                        gradosAcademicos.add("Doctorado");
                    } else {
                        System.out.println("Ya ha seleccionado este grado académico");
                    }
                    break;
                case 3:
                    gradosAcademicos.clear();
                    gradosAcademicos.add("Magister");
                    gradosAcademicos.add("Doctorado");
                    seleccionado = false;
                    break;
                case 4:
                    gradosAcademicos.add("Ninguno");
                    break;
                case 5:
                    if (gradosAcademicos.isEmpty()) {
                        System.out.println("Debe seleccionar al menos un grado académico.");
                        continue;
                    } else {
                        seleccionado = false;
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
        return gradosAcademicos;
    }
}
