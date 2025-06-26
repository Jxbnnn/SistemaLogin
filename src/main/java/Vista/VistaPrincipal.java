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

}