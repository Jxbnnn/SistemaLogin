package Vista;

import Modelo.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class VistaPrincipal extends JFrame {
    private final Usuario usuario;
    private final DatosSesion datosSesion;
    private DefaultListModel<String> modeloTareas;
    private JList<String> listaTareas;
    private JTextField campoBusqueda;

    public VistaPrincipal (DatosSesion datosSesion) {
        this.usuario = datosSesion.getUsuario();
        this.datosSesion = datosSesion;

        setTitle("Tareas de " + usuario.getNombreUsuario());
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        inicializarComponentes();
        cargarTareas();
    }

}