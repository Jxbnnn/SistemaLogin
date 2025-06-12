package Modelo;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DatosSesion {
    private Usuario usuario;
    private HistorialSesion historial;

    public DatosSesion(Usuario usuario) {
        this.usuario = usuario;
        this.historial = new HistorialSesion();
    }

    public void registrarNuevaTarea(Tarea tarea) {
        usuario.agregarTarea(tarea);
        historial.registrarNuevaTarea();
    }

    public ArrayList<Tarea> getTareasActivas() {
        return usuario.getTareas().stream()
                .filter(t -> !t.estaFinalizada())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Tarea> getTareasFinalizadas() {
        return usuario.getTareas().stream()
                .filter(Tarea::estaFinalizada)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean finalizarTarea(int indice) {
        ArrayList<Tarea> activas = getTareasActivas();
        if (indice >= 0 && indice < activas.size()) {
            activas.get(indice).marcarFinalizada();
            return true;
        }
        return false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public HistorialSesion getHistorial() {
        return historial;
    }
}
