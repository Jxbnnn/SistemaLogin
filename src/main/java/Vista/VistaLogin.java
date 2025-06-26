package Vista;

import Controlador.Login;
import Modelo.DatosLogin;
import Modelo.GestorUsuarios;
import Modelo.Usuario;
import Modelo.DatosSesion;
import javax.swing.*;
import java.awt.*;

public class VistaLogin extends JFrame{
    private final JTextField campoUsuario = new JTextField(15);
    private final JPasswordField campoClave = new JPasswordField(15);
    private final JButton botonLogin = new JButton("Iniciar Sesión");
    private final DatosLogin datosLogin = new DatosLogin();
    private final GestorUsuarios gestorUsuarios = new GestorUsuarios();
    private final Login loginCotroller = new Login();
}
public VistaLogin() {
    setTittle("Inicio de Sesión");
    setSize(300,200);
    setDefaultCloseOperation (EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GrindLayout(3,2,5,5));
    panel.add(new JLabel("Usuario:"));
    panel.add(campoUsuario);
    panel.add(new JLabel("Contraseña:"));
    panel.add(campoClave);
    panel.add(new JLabel());
    panel.add(botonLogin);
    add(panel);

    botonLogin.addActionListener(e -> autenticarUsuario());
}
private void autenticarUsuario (){
    String usuario = campoUsuario.getText();
    String clave = new String(campoClave,getPassword());

    if (loginController.autenticar(usuario, clave)) {
        Usuario user = gestorUsuarios.obtenerUsuario(usuario);
        DatosSesion sesion = new DatosSesion(user);
        new VistaPrincipal(sesion).setVisible(true);
        this.dispose();
