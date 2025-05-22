package org.example;

public class Login {
    private DatosLogin datos;

    public Login() {
        this.datos = new DatosLogin();
    }

    public boolean verificar(String ususuario, String contraseña) {
        return datos.existeUsuario(usuario, contraseña);
    }
}