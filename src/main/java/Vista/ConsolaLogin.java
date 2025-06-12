package Vista;

import Modelo.*;

import java.util.Scanner;
import java.util.List;

public class ConsolaLogin {
    private DatosLogin datosLogin;
    private GestorUsuarios gestorUsuarios;
    private Scanner scanner;

    public ConsolaLogin() {
        datosLogin = new DatosLogin();
        gestorUsuarios = new GestorUsuarios();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Ingrese usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese contraseña:");
        String contrasena = scanner.nextLine();

        if (datosLogin.autenticar(usuario, contrasena)) {
            Usuario user = gestorUsuarios.obtenerUsuario(usuario);
            DatosSesion sesion = new DatosSesion(user);
            menu(sesion);
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private void menu(DatosSesion sesion) {
        int opcion;
        do {
            System.out.println("\n1. Ver tareas activas");
            System.out.println("2. Ver tareas finalizadas");
            System.out.println("3. Agregar tarea");
            System.out.println("4. Finalizar tarea");
            System.out.println("5. Salir");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> mostrarTareas(sesion.getTareasActivas());
                case 2 -> mostrarTareas(sesion.getTareasFinalizadas());
                case 3 -> agregarTarea(sesion);
                case 4 -> finalizarTarea(sesion);
                case 5 -> mostrarHistorial(sesion);
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void mostrarTareas(List<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar.");
            return;
        }
        for (int i = 0; i < tareas.size(); i++) {
            Tarea t = tareas.get(i);
            System.out.printf("%d. %s [%s]%n", i + 1, t.getDescripcion(), t.getPrioridad());
        }
    }

    private void agregarTarea(DatosSesion sesion) {
        System.out.print("Descripción de la tarea: ");
        String desc = scanner.nextLine();
        System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
        Prioridad p = Prioridad.valueOf(scanner.nextLine().toUpperCase());
        sesion.registrarNuevaTarea(new Tarea(desc, p));
        System.out.println("Tarea agregada correctamente.");
    }

    private void finalizarTarea(DatosSesion sesion) {
        mostrarTareas(sesion.getTareasActivas());
        System.out.print("Ingrese número de tarea a finalizar: ");
        int i = Integer.parseInt(scanner.nextLine());
        if (sesion.finalizarTarea(i - 1)) {
            System.out.println("Tarea finalizada.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void mostrarHistorial(DatosSesion sesion) {
        HistorialSesion h = sesion.getHistorial();
        System.out.println("Inicio de sesión: " + h.getInicio());
        System.out.println("Tareas agregadas: " + h.getTareasAgregadas());
    }
}
