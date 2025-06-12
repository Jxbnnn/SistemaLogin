package Modelo;

import java.util.HashMap;

public class DatosLogin {
    private HashMap<String, String> credenciales;

    public DatosLogin() {
        credenciales = new HashMap<>();
        // Simulación de carga de datos
        credenciales.put("usuario1", "1234");
        credenciales.put("admin", "admin");
    }

    public boolean autenticar(String usuario, String contrasena) {
        return credenciales.containsKey(usuario) && credenciales.get(usuario).equals(contrasena);
    }
}
