package org.example;

public class ConsolaLogin {
    private Login login;

    public ConsolaLogin() {
        this.login = new Login ();
        public void mostrarMenu() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------------------------");
            System.out.println("    Iniciando sistema de login    ");
            System.out.println("----------------------------------");
            System.out.println("Usuario: ");
            String usuario = scanner.nextLine();
            System.out.println("Contraseña: ");
            String contraseña = scanner.nextLine();
        }
    }
}
