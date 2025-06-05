package Controlador;

import Modelo.DatosLogin;

public class Login {
    private DatosLogin datos;

    public Login() {
        datos = new DatosLogin();
    }

    public boolean autenticar(String usuario, String contraseña) {
        return datos.verificarCredenciales(usuario, contraseña);
    }
}
