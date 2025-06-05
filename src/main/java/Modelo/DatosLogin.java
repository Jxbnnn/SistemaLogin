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

            }
        }
    }
}