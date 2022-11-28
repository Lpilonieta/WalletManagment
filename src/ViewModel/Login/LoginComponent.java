package ViewModel.Login;

import ViewModel.Components.NewItemInventory.NewItemInventoryComponent;
import ViewModel.Components.NewItemInventory.NewItemInventoryTemplate;
import ViewModel.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginComponent implements ActionListener {

    //Inyección de dependencia

    private LoginUITemplate loginUITemplate;

    private MainPanelComponent mainPanel;

    public LoginComponent (){
        this.loginUITemplate = new LoginUITemplate(this);
    }

    private String nameUser, claveUser, check;


    @Override
    public void actionPerformed(ActionEvent e) {

        Object op = e.getSource();

        if (op == loginUITemplate.getBloginI()) {

            System.out.println("Iniciando sesión");
            this.showDataUser();
            this.login ();

        } else if (op == loginUITemplate.getbRegistry()){
            System.out.println("Registrandose");
        }

    }

    public void showDataUser (){

        nameUser = loginUITemplate.getTextNombreUsuario().getText();
        claveUser = new String (loginUITemplate.gettClaveUser().getPassword());
        check = "";
        if (loginUITemplate.getCheckSi().isSelected()){
            check = "si";
        } else if (loginUITemplate.getCheckNo().isSelected()){
            check = "no";
        }

        System.out.println(nameUser + " " + claveUser + " " + check + " ");
    }

    public void login (){

        if(mainPanel == null){
            this.mainPanel = new MainPanelComponent(this);
            loginUITemplate.setVisible(false);
        } else {
            this.mainPanel.getMainPanelTemplate().setVisible(false);
            loginUITemplate.setVisible(true);
        }

    }

}
