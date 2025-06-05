package Modelo;

import java.io.*;
import java.util.ArrayList;

public class DatosLogin{
    private final ArrayList<Usuario> usuarios = new ArrayList<>();

    public DatosLogin(){
        File archivo = new File("login.txt");

        if(!archivo.exists()){
            try{
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println ("No se pudo crear login.txt");
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) !=null){
                String[] partes = linea.split (";");
                if(partes.length ==2){
                    usuarios.add(new Usuario(partes[0],partes[1]));
                }

            }
        }catch (IOException e){
            System.out.println("Error en la lectura de login.txt");
        }
    }
}