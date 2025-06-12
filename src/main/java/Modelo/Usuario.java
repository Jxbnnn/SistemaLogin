package Modelo;

import java.util.ArrayList;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private Perfil perfil;
    private ArrayList<Tarea> tareas;

    // Constructor por defecto (opcional, por si lo necesitas)
    public Usuario() {
        this.tareas = new ArrayList<>();
    }

    // Constructor principal
    public Usuario(String nombreUsuario, String contrasena, Perfil perfil) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.perfil = perfil;
        this.tareas = new ArrayList<>();
    }

    // Getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }
}
