package View.Login;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginUITemplate extends JFrame {


    private JPanel panelLogin, panelLogo;

    private JLabel lNotitifications, lTituloLogin;

    private JTextField textNombreUsuario;

    private JPasswordField tClaveUser;

    private JButton bloginI, bRegistry;

    private JCheckBox checkSi, checkNo;

    private ButtonGroup bottonGroup;

    //private JComboBox userType;

    //Declaración de servicios

    private ObjGraficosService sObjGraficos;

    private LoginComponent loginComponent;

    private RecursosService recursosService;


    //Decoradores

    private Color mainColor;

    private Cursor cursoTexto;
    private ImageIcon iconLogin, iConUser, iConPassword, iconExit;
    private JLabel lIconLogin, lIconUser, lIconPassword;

    private Border bInferiorVerde;
    private Font mainFont, specialTitle, cursivafont;



    public LoginUITemplate(LoginComponent loginComponent){
        super("Login usuario");

        this.loginComponent = loginComponent;
        recursosService = RecursosService.getService();
        sObjGraficos = ObjGraficosService.getService();


        this.Jdecoradores();
        this.JLabels();
        this.JTextField();
       // this.JComboBox();
        this.PasswordFields();
        this.JButtons();
        this.JCheckBoxs();


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(630,900);
        setLocationRelativeTo(this);
        setResizable(true);
        setVisible(true);
        setLayout(null);


    }


    public void Jdecoradores(){

     //Fuentes

        mainFont = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        specialTitle = new Font("Rockwell Extra Bold", Font.PLAIN, 18);
        cursivafont = new Font("Calibri (Cuerpo)", Font.ITALIC, 17);


        //Color

        mainColor = new Color(76,175,80);

        //Cursor

        cursoTexto = new Cursor(Cursor.TEXT_CURSOR);

        //Border

        bInferiorVerde = BorderFactory.createMatteBorder(0,0,3,0,mainColor);

        //Paneles

        panelLogin = new JPanel();
        panelLogin.setSize(590,670);
        panelLogin.setLocation(10, 350 );
        panelLogin.setBackground(Color.WHITE);
        panelLogin.setLayout(null);
        add(panelLogin);

        panelLogo = new JPanel();
        panelLogo.setSize(212,212);
        panelLogo.setLocation(195, 50);
        panelLogo.setLayout(null);
        add(panelLogo);

        //Imagenes


        iconLogin = new ImageIcon("Graphics/Login/8801574.png");
        iConUser = new ImageIcon("Graphics/Login/user.png");
        iConPassword = new ImageIcon("Graphics/Login/cerrar-con-llave.png");
        iconExit = new ImageIcon("Graphics/Login/sign-out.png");

        lIconLogin = new JLabel();
        lIconLogin.setBounds(0,0,212,212);
        lIconLogin.setIcon( iconLogin);
        panelLogo.add(lIconLogin);

        lIconUser = new JLabel();
        lIconUser.setBounds((panelLogin.getWidth() - lIconUser.getWidth())/2 - 190,100,40,40);
        lIconUser.setIcon(iConUser);
        panelLogin.add(lIconUser);

        lIconPassword = new JLabel();
        lIconPassword.setBounds((panelLogin.getWidth() - lIconPassword.getWidth())/2 - 190,200,40,40);
        lIconPassword.setIcon(iConPassword);
        panelLogin.add(lIconPassword);


        //Border

        bInferiorVerde = BorderFactory.createMatteBorder(0,0,3,0,mainColor);

    }

    public void JLabels (){

        lTituloLogin = new JLabel("Registra tus datos");
        lTituloLogin.setSize(150,30);
        lTituloLogin.setLocation((panelLogin.getWidth()-lTituloLogin.getWidth())/2,60);
        lTituloLogin.setForeground(mainColor);
        lTituloLogin.setHorizontalAlignment(SwingUtilities.CENTER);
        lTituloLogin.setFont(mainFont);

        panelLogin.add(lTituloLogin);


        lNotitifications = new JLabel("¿Recibir notificaciones?");
        lNotitifications.setSize(190, 20);
        lNotitifications.setLocation((panelLogin.getWidth() - lNotitifications.getWidth())/2, 450);
        lNotitifications.setForeground(mainColor);
        lNotitifications.setHorizontalAlignment(SwingUtilities.CENTER);
        lNotitifications.setFont(mainFont);
        panelLogin.add(lNotitifications);

    }

    public void JTextField (){

        //JTextField

        textNombreUsuario = new JTextField("Nombre usuario");
        textNombreUsuario.setSize(260,40);
        textNombreUsuario.setLocation((panelLogin.getWidth() - textNombreUsuario.getWidth())/2, 100);
        textNombreUsuario.setForeground(Color.DARK_GRAY);
        textNombreUsuario.setBackground(Color.WHITE);
        textNombreUsuario.setCaretColor(mainColor);
        textNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        textNombreUsuario.setCursor(cursoTexto);
        textNombreUsuario.setBorder(bInferiorVerde);
        textNombreUsuario.setFont(cursivafont);
        panelLogin.add(textNombreUsuario);

    }

/*
    public void JComboBox(){

        //JComboBox

        userType = new JComboBox<>();
        userType.addItem("Basico");
        userType.addItem("Avanzado");
        userType.setSize(220,30);
        userType.setLocation((panelLogin.getWidth() - userType.getWidth())/2, 270);
        userType.setForeground(Color.DARK_GRAY);
        userType.setBackground(Color.WHITE);
        ((JLabel) userType.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        panelLogin.add(userType);


    }
*/
    public void PasswordFields (){

        //JPasswordField

        tClaveUser = new JPasswordField("Clave Usuario");
        tClaveUser.setSize(260,40);
        tClaveUser.setLocation((panelLogin.getWidth() - tClaveUser.getWidth())/2, 200);
        tClaveUser.setForeground(Color.DARK_GRAY);
        tClaveUser.setCaretColor(mainColor);
        tClaveUser.setHorizontalAlignment(SwingUtilities.CENTER);
        tClaveUser.setCursor(cursoTexto);
        tClaveUser.setBorder(bInferiorVerde);
        tClaveUser.setFont(cursivafont);
        panelLogin.add(tClaveUser);

    }

    public void JButtons () {

        //JButton


        bloginI = sObjGraficos.builtButton("Iniciar sesión", 30, 350, 200, 40, recursosService.getCursoMano(),
                null, recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bloginI.addActionListener(loginComponent);
        panelLogin.add(bloginI);

/*
        bloginI = new JButton("Iniciar sesión");
        bloginI.setSize(200,40);
        bloginI.setLocation(30,350);
        bloginI.setBackground(mainColor);
        bloginI.setForeground(Color.WHITE);
        bloginI.setFocusable(false);
        bloginI.setCursor(cursoMano);
        panelLogin.add(bloginI);
*/

        bRegistry = new JButton("Registrarse");
        bRegistry.setSize(200,40);
        bRegistry.setLocation(360,350);
        bRegistry.setBackground(mainColor);
        bRegistry.setForeground(Color.WHITE);
        bRegistry.setFocusable(false);
        bRegistry.setCursor(recursosService.getCursoMano());
        bRegistry.addActionListener(loginComponent);
        panelLogin.add(bRegistry);

    }

    public void JCheckBoxs (){

        //JCheckBox

        checkSi = new JCheckBox("Si");
        checkNo = new JCheckBox("No");

        checkSi.setSize(45,25);
        checkSi.setFocusable(false);
        checkSi.setBackground(Color.WHITE);
        checkSi.setLocation((panelLogin.getWidth() - checkSi.getWidth()) / 2 - 15, 430);
        checkSi.setCursor(recursosService.getCursoMano());


        checkNo.setSize(45,25);
        checkNo.setFocusable(false);
        checkNo.setBackground(Color.WHITE);
        checkNo.setLocation((panelLogin.getWidth() + checkNo.getWidth()) / 2 + 6, 430);
        checkNo.setCursor(recursosService.getCursoMano());

        panelLogin.add(checkSi);
        panelLogin.add(checkNo);

        bottonGroup = new ButtonGroup();

        bottonGroup.add(checkSi);
        bottonGroup.add(checkNo);
    }



    public JTextField getTextNombreUsuario() {
        return textNombreUsuario;
    }

    public JPasswordField gettClaveUser() {
        return tClaveUser;
    }


    public JButton getBloginI() {
        return bloginI;
    }

    public JButton getbRegistry() {
        return bRegistry;
    }


    public JCheckBox getCheckSi() {
        return checkSi;
    }

    public JCheckBox getCheckNo() {
        return checkNo;
    }


}