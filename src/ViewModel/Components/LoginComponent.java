package ViewModel.Login;

import ViewModel.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginComponent implements ActionListener {

    //Inyección de dependencia
    private LoginComponent loginComponent;

    private LoginUITemplate loginUITemplate;

    private MainPanelComponent mainPanel;

    public LoginComponent (LoginComponent loginComponent){

     this.loginComponent = loginComponent;

    }


    public LoginComponent (){
        this.loginUITemplate = new LoginUITemplate(this);
    }


    public LoginUITemplate getLoginUITemplate() {
        return this.loginUITemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object op = e.getSource();

        if (op == loginUITemplate.getBloginI()) {

            System.out.println("Iniciando sesión");
            this.showDataUser();
            this.login ();

            this.mainPanel = new MainPanelComponent();
            loginUITemplate.setVisible(false);

        } else if (op == loginUITemplate.getbRegistry()){


            System.out.println("Registrandose");
        }

    }

    public void showDataUser (){

        String nameUser = loginUITemplate.getTextNombreUsuario().getText();
        String claveUser = new String (loginUITemplate.gettClaveUser().getPassword());
        String check = "";
        if (loginUITemplate.getCheckSi().isSelected()){
            check = "si";
        } else if (loginUITemplate.getCheckNo().isSelected()){
            check = "no";
        }

        System.out.println(nameUser + " " + claveUser + " " + check + " ");
    }

    public void login (){

    }
}
