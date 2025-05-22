package org.example;

public class Login {
    private DatosLogin datos;

    public Login() {
        datos = new DatosLogin();
    }

    /**
     * Verifica usuario y contraseña usando DatosLogin.
     */
    public boolean autenticar(String usuario, String contraseña) {
        return datos.verificarCredenciales(usuario, contraseña);
    }
}
