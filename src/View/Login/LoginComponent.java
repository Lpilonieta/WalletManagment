package View.Login;

import View.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoginComponent implements ActionListener {

    //Inyección de dependencia

    private LoginUITemplate loginUITemplate;

    private MainPanelComponent mainPanel;

    public LoginComponent() {
        this.loginUITemplate = new LoginUITemplate(this);
    }

    private String verificationInitLogin;

    private String nameUser, claveUser, check;

    @Override
    public void actionPerformed(ActionEvent e) {

        Object op = e.getSource();

        if (op == loginUITemplate.getBloginI()) {
            System.out.println(verificationInitLogin);
            try {
                this.validationInit();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Iniciando sesión");
            this.showDataUser();
        } else if (op == loginUITemplate.getbRegistry()) {
            System.out.println("Registrandose");
        }

    }

    public void showDataUser() {

        nameUser = loginUITemplate.getTextNombreUsuario().getText();
        claveUser = new String(loginUITemplate.gettClaveUser().getPassword());
        check = "";
        if (loginUITemplate.getCheckSi().isSelected()) {
            check = "si";
        } else if (loginUITemplate.getCheckNo().isSelected()) {
            check = "no";
        }

        System.out.println(nameUser + " " + claveUser + " " + check + " ");
    }


    public void cargarDatos() {
        String verificationInitLogin;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("archives/ValidationInitLogin.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atributos = linea.split(",");
                verificationInitLogin = atributos[0];
                this.verificationInitLogin = verificationInitLogin;
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void validationInit() throws IOException {

        this.cargarDatos();
        System.out.println(verificationInitLogin);
        if (verificationInitLogin != "false") {
            loginUITemplate.setVisible(true);
            this.sobreEscritura();
        } else {
            if (mainPanel == null) {
                this.mainPanel = new MainPanelComponent();
                System.out.println(verificationInitLogin);
                loginUITemplate.setVisible(false);
                System.out.println("Esta aqui");
            }
        }
    }

    public void sobreEscritura() throws IOException {

        File newFile = new File("/archives/ValidationInitLogininn.txt");

    }
}

