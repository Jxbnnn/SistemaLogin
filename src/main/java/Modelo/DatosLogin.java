package Modelo;

import java.io.*;
import java.util.HashMap;

public class DatosLogin {
    private HashMap<String, String> usuarios = new HashMap<>();

    public DatosLogin() {
        crearArchivosSiNoExiste();
        cargarUsuarios();
    }

    private void crearArchivosSiNoExiste() {
        File archivo = new File("login.txt");
        if (!archivo.exists()){
            try {
                archivo.createNewFile();
                try(FileWriter fw = new FileWriter(archivo,true)) {
                    fw.write("admin;admin123\n");
                }
            }catch (IOException e) {
                System.err.println("Error al crear el archivo login.txt");
            }
        }
    }

    private void cargarUsuarios() {
        try (BufferedReader lector = new BufferedReader(new FileReader("login.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty() && linea.contains(";")) {
                    String[] partes = linea.split(";");
                    if (partes.length == 2) {
                        String usuario = partes[0].trim();
                        String contraseña = partes[1].trim();
                        usuarios.put(usuario, contraseña);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo login.txt: " + e.getMessage());
        }
    }

    public boolean existeUsuario(String usuario) {
        return usuarios.containsKey(usuario);
    }

    public boolean verificarCredenciales(String usuario, String contraseña) {
        if (!existeUsuario(usuario)) {
            return false;
        }
        String passGuardada = usuarios.get(usuario);
        return passGuardada.equals(contraseña);
    }
}

