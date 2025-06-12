package Modelo;

import java.util.HashMap;

public class GestorUsuarios {
    private HashMap<String, Usuario> usuarios;

    public GestorUsuarios() {
        usuarios = new HashMap<>();

        // Crear perfiles
        Perfil perfilUsuario1 = new Perfil("usuario1@correo.com");
        Perfil perfilAdmin = new Perfil("admin@correo.com");

        // Crear usuarios con perfil
        Usuario usuario1 = new Usuario("usuario1", "1234", perfilUsuario1);
        Usuario admin = new Usuario("admin", "admin", perfilAdmin);

        // Agregar al mapa
        usuarios.put("usuario1", usuario1);
        usuarios.put("admin", admin);
    }

    public Usuario obtenerUsuario(String nombreUsuario) {
        return usuarios.get(nombreUsuario);
    }

    public boolean existeUsuario(String nombreUsuario) {
        return usuarios.containsKey(nombreUsuario);
    }
}
