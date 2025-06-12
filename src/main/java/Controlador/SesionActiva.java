package Controlador;

import Modelo.*;

import java.util.Scanner;

public class SesionActiva {
    private final Usuario usuario;
    private final Scanner scanner;
    private final DatosSesion datosSesion;

    public SesionActiva(Usuario usuario) {
        this.usuario = usuario;
        this.scanner = new Scanner(System.in);
        this.datosSesion = new DatosSesion(usuario);
    }

    public void menuSesion() {
        int opcion;
        do {
            System.out.println("\n-------------------------");
            System.out.println("     Menú de Usuario    ");
            System.out.println("-------------------------");
            System.out.println("1. Ver tareas activas");
            System.out.println("2. Ver tareas finalizadas");
            System.out.println("3. Agregar tarea");
            System.out.println("4. Finalizar tarea");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> mostrarTareas(datosSesion.getTareasActivas());
                case 2 -> mostrarTareas(datosSesion.getTareasFinalizadas());
                case 3 -> agregarTarea();
                case 4 -> finalizarTarea();
                case 5 -> mostrarHistorial();
                case 6 -> System.out.println("Cerrando sesión...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private void mostrarTareas(java.util.List<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        for (int i = 0; i < tareas.size(); i++) {
            Tarea t = tareas.get(i);
            System.out.printf("%d. %s [%s]%n", i + 1, t.getDescripcion(), t.getPrioridad());
        }
    }

    private void agregarTarea() {
        System.out.print("Descripción: ");
        String desc = scanner.nextLine();
        System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
        Prioridad prioridad = Prioridad.valueOf(scanner.nextLine().toUpperCase());
        Tarea tarea = new Tarea(desc, prioridad);
        datosSesion.registrarNuevaTarea(tarea);
        System.out.println("Tarea agregada.");
    }

    private void finalizarTarea() {
        mostrarTareas(datosSesion.getTareasActivas());
        System.out.print("Seleccione el número de la tarea a finalizar: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (datosSesion.finalizarTarea(index - 1)) {
            System.out.println("Tarea finalizada.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private void mostrarHistorial() {
        HistorialSesion h = datosSesion.getHistorial();
        System.out.println("Inicio de sesión: " + h.getInicio());
        System.out.println("Tareas agregadas: " + h.getTareasAgregadas());
    }
}
