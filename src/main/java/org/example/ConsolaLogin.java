package org.example;

import java.util.Scanner;

public class ConsolaLogin {
    private Login login;
    private Scanner scanner;

    public ConsolaLogin() {
        login = new Login();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n------------------------");
            System.out.println("\n    Sistema de Login    ");
            System.out.println("\n------------------------");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();
            if (opcion.equals("1")) {
                manejarLogin();
            } else if (opcion.equals("2")) {
                System.out.println("Saliendo del sistema.");
                break;
            } else {
                System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    private void manejarLogin() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine().trim();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine().trim();

        if (login.autenticar(usuario, contraseña)) {
            System.out.println("Iniciando sesión, " + usuario);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}
