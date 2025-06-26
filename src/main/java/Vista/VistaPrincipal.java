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
    private void inicializarComponentes() {
        JPanel panel = new JPanel(new BorderLayout());

        modeloTareas = new DefaultListModel<>();
        listaTareas = new JList<>(modeloTareas);
        JScrollPane scrollPane = new JScrollPane(listaTareas);

        campoBusqueda = new JTextField();
        campoBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filtrar(); }
            public void removeUpdate(DocumentEvent e) { filtrar(); }
            public void changedUpdate(DocumentEvent e) { filtrar(); }
        });

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(new JLabel("Buscar: "), BorderLayout.WEST);
        panelSuperior.add(campoBusqueda, BorderLayout.CENTER);

        JButton botonAgregar = new JButton("Agregar Tarea");
        botonAgregar.addActionListener(e -> mostrarDialogoAgregar());

        panel.add(panelSuperior, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(botonAgregar, BorderLayout.SOUTH);

        add(panel);
    }
}
