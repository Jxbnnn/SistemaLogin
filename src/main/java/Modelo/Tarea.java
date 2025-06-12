package Modelo;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;
    private boolean finalizada;

    public Tarea(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.finalizada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public boolean estaFinalizada() {
        return finalizada;
    }

    public void marcarFinalizada() {
        this.finalizada = true;
    }
}
