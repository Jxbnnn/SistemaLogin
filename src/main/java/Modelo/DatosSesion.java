package Modelo;

import java.io.*;
import java.util.ArrayList;

public class DatosSesion {
    private final String archivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();

    public DatosSesion(String usuario) {
        this.archivo = usuario + "_todo.txt";
        File file = new File(archivo);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo de tareas.");
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                tareas.add(new Tarea(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de tareas.");
        }
    }

    public void agregarTarea(String descripcion) {
        Tarea nueva = new Tarea(descripcion);
        tareas.add(nueva);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(descripcion);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("No se pudo guardar la tarea.");
        }
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}
