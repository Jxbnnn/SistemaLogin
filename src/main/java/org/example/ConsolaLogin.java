package org.example;

import java.util.Scanner;

public class ConsolaLogin {
    private Login login;

    public ConsolaLogin() {
        this.login = new Login ();
    }

        public void mostrarMenu() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("----------------------------------");
            System.out.println("    Iniciando sistema de login    ");
            System.out.println("----------------------------------");
            System.out.println("Usuario: ");
            String usuario = scanner.nextLine();
            System.out.println("Contraseña: ");
            String contraseña = scanner.nextLine();

            bolean resultado = login.verificar (usuario, contraseña);
            if (resultado) {
                System.out.println ("Iniciando sesión ;)");
            } else {
                System.out.println ("Acceso denegado :(");
            }
        }
    }
}
