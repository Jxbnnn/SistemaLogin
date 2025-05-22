package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatosLogin {
    public boolean existeUsuario(String usuario, String contraseña) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/resources/login.txt"));
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length == 2 && partes[0].equals(usuario) && partes[1].equals(contraseña)) {
                    return true; // Usuario encontrado
                }
            }

            lector.close();
        } catch (IOException e) {
            System.out.println("⚠️ Error al leer el archivo login.txt");
        }

        return false; // Usuario no encontrado
    }
}
