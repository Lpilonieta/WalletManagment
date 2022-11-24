package ViewModel.MainPanel;

import ViewModel.Components.DailyRecord.*;
import ViewModel.Components.FinancialSpaces.FinalcialSpacesComponent;
import ViewModel.Components.FinancialSpaces.FinalcialSpacesTemplate;
import ViewModel.Components.PersonalArea.PersonalAreaComponent;
import ViewModel.Components.PersonalArea.PersonalAreaTemplate;
import ViewModel.Components.SeeFinalcialSpaces.SeeFinalcialSpacesComponent;
import ViewModel.Components.SeeFinalcialSpaces.SeeFinalcialSpacesTemplate;
import ViewModel.Components.TitleBar.TitleBarComponent;
import ViewModel.Components.UserBrowsing.UserBrowsingComponent;
import ViewModel.Components.UserBrowsing.UserBrowsingTemplate;
import ViewModel.Login.LoginComponent;

import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanelComponent {

    private MainPanelComponent mainPanelComponent;
    private MainPanelTemplate mainPanelTemplate;


    //Componentes

    private TitleBarComponent titleBarComponent;
    private LoginComponent loginComponent;
    private UserBrowsingComponent userBrowsingComponent;

    private ActivosComponent activosComponent;

    private EgresosComponent egresosComponent;

    private IngresosComponent ingresosComponent;

    private PasivosComponent pasivosComponent;

    private FinalcialSpacesComponent finalcialSpacesComponent;

    private PersonalAreaComponent personalAreaComponent;

    private SeeFinalcialSpacesComponent seeFinalcialSpacesComponent;



    public MainPanelComponent (LoginComponent loginComponent){
        this.loginComponent = loginComponent;
        this.mainPanelTemplate = new MainPanelTemplate(this);
        this.titleBarComponent = new TitleBarComponent(this);
        this.userBrowsingComponent = new UserBrowsingComponent(this);

        mainPanelTemplate.getpBarraSuperior().add(titleBarComponent.getTitleBarTemplate());

        mainPanelTemplate.getpBarraLateral().add(userBrowsingComponent.getUserBrowsingTemplate());
    }

    public MainPanelTemplate getMainPanelTemplate() {
        return mainPanelTemplate;
    }

    public void showComponents (String comand){

    switch (comand){

        case "Add Espacio Financiero":

            if (this.finalcialSpacesComponent == null){
                System.out.println("Añadiendo espacio financiero");
                this.mainPanelTemplate.getpShowData().add(new FinalcialSpacesComponent().getFinalcialSpacesTemplate());
            }
            break;

        case "Ver espacios financieros":
            if (this.seeFinalcialSpacesComponent == null){
                mainPanelTemplate.getpShowData().add(new SeeFinalcialSpacesComponent().getSeeFinalcialSpacesTemplate());

                System.out.println("Viendo espacio financiero");
            }
            break;

        case "Ver area personal" :

            if (this.personalAreaComponent == null){
                mainPanelTemplate.getpShowData().add(new PersonalAreaComponent().getPersonalAreaTemplate());
                System.out.println("Viendo espacio financiero");
            }

            break;

        case "Home":

            mainPanelTemplate.getpShowData().removeAll();

            System.out.println("Home");

            break;

        case "Ingresos":

            if (this.ingresosComponent == null){
                mainPanelTemplate.getpShowData().add(new IngresosComponent().getIngresosTemplate());
                System.out.println("Viendo espacio financiero");
            }

            System.out.println("Añadiendo ingresos");

            break;

        case "Egresos":

            if (this.egresosComponent== null){
                mainPanelTemplate.getpShowData().add(new EgresosComponent().getEgresosTemplate());
                System.out.println("Viendo espacio financiero");
            }

            System.out.println("Añadiendo egresos");
            break;

        case "Pasivos":

            if (this.pasivosComponent == null){
                mainPanelTemplate.getpShowData().add(new PasivosComponent().getPasivosTemplate());
                System.out.println("Viendo espacio financiero");
            }


            System.out.println("Añadiendo pasivos");
            break;

        case "Activos":

            if (this.activosComponent == null){
                mainPanelTemplate.getpShowData().add(new ActivosComponent().getActivosTemplate());
                System.out.println("Viendo espacio financiero");
            }

            System.out.println("Añadiendo activos");

            break;

        default:
            break;
    }

        mainPanelTemplate.repaint();

    }
}
