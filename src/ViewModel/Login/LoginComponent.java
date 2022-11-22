package ViewModel.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginComponent implements ActionListener {

    //Inyección de dependencia
    private LoginComponent loginComponent;

    private LoginUITemplate loginUITemplate;

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

    }
}
