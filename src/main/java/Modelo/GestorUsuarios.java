package Modelo;

import java.io.*;

public class GestorUsuarios {

    public GestorUsuarios() {
        File archivo = new File("login.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear login.txt");
            }
        }
    }

    public boolean registrar(String nombre, String clave) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("login.txt", true))) {
            bw.write(nombre + ";" + clave);
            bw.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
