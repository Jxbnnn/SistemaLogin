package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatosLogin {
    public boolean existeUsuario(String usuario, String contraseña) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader("login.txt"));
            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println("Línea leída: " + linea);  //

                String[] partes = linea.split(",");

                if (partes.length == 2) {
                    String userArchivo = partes[0].trim();
                    String passArchivo = partes[1].trim();

                    System.out.println("Comparando con: " + userArchivo + " / " + passArchivo);

                    if (userArchivo.equals(usuario.trim()) && passArchivo.equals(contraseña.trim())) {
                        lector.close();
                        return true;
                    }
                }
            }

            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo login.txt: " + e.getMessage());
        }

        return false;
    }

}
