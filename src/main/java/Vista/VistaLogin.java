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
