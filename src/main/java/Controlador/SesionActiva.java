package Controlador;

import Modelo.DatosSesion;
import Modelo.GestorUsuarios;
import java.util.Scanner;

public class SesionActiva {
    private final String usuario;
    private final Scanner scanner;
    private final DatosSesion datosSesion;

    public SesionActiva (String usuario) {
        this.usuario = usuario;
        this scanner = new Scanner(System.in);
        this.datosSesion = new DatosSesion (usuario);

    }
}
public void menuSesion () {
    while (true) {
        System.out.println("-------------------------");
        System.out.println("     Menu de Usuario    ");
        System.out.println("-------------------------");
        System.out.println("1. Ver tareas");
        System.out.println("2. Agregar tarea");
        if (usuario.equals("admin")) {
            
        }
    }
}