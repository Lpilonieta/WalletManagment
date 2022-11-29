package view.MainPanel;

import view.Components.CashFlow.*;
import view.Components.InitApp.HomeComponent;
import view.Components.FinancialSpaces.FinalcialSpacesComponent;
import view.Components.NewItemInventory.NewItemInventoryComponent;
import view.Components.PersonalArea.PersonalAreaComponent;
import view.Components.SalesRegistry.SalesRegistryComponent;
import view.Components.SeeFinalcialSpaces.SeeFinalcialSpacesComponent;
import view.Components.TitleBar.TitleBarComponent;
import view.Components.UserBrowsing.UserBrowsingComponent;
import view.Login.LoginComponent;


public class MainPanelComponent {

    private MainPanelComponent mainPanelComponent;
    private MainPanelTemplate mainPanelTemplate;


    //Componentes

    private TitleBarComponent titleBarComponent;
    private LoginComponent loginComponent;
    private UserBrowsingComponent userBrowsingComponent;

    private SalesRegistryComponent salesRegistryComponent;

    private EgresosComponent egresosComponent;

    private IngresosComponent ingresosComponent;

    private NewItemInventoryComponent newItemInventoryComponent;

    private FinalcialSpacesComponent finalcialSpacesComponent;

    private PersonalAreaComponent personalAreaComponent;

    private SeeFinalcialSpacesComponent seeFinalcialSpacesComponent;

    private HomeComponent homeComponent;

    public MainPanelComponent (LoginComponent loginComponent){
        this.loginComponent = loginComponent;
        this.mainPanelTemplate = new MainPanelTemplate(this);
        this.titleBarComponent = new TitleBarComponent(this);
        this.userBrowsingComponent = new UserBrowsingComponent(this);
        this.homeComponent = new HomeComponent(this);

        mainPanelTemplate.getpBarraSuperior().add(titleBarComponent.getTitleBarTemplate());

        mainPanelTemplate.getpBarraLateral().add(userBrowsingComponent.getUserBrowsingTemplate());

        mainPanelTemplate.getpShowData().add(homeComponent.getHomeTemplate());

    }

    public MainPanelTemplate getMainPanelTemplate() {
        return mainPanelTemplate;
    }

    public void showComponents (String comand){


    switch (comand){

        case "Add Espacio Financiero":
            System.out.println("Entró");

            if (this.finalcialSpacesComponent == null){
                mainPanelTemplate.getpShowData().removeAll();
                System.out.println("Añadiendo espacio financiero");
                this.mainPanelTemplate.getpShowData().add(new FinalcialSpacesComponent().getFinalcialSpacesTemplate());
            }
            break;

        case "Ver espacios financieros":
            if (this.seeFinalcialSpacesComponent == null){
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new SeeFinalcialSpacesComponent().getSeeFinalcialSpacesTemplate());

                System.out.println("Viendo espacio financiero");
            }
            break;

        case "Ver area personal" :

            if (this.personalAreaComponent == null){
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new PersonalAreaComponent().getPersonalAreaTemplate());
                System.out.println("Viendo espacio financiero");
            }

            break;

        case "Home":
            mainPanelTemplate.getpShowData().removeAll();
            mainPanelTemplate.getpShowData().add(new HomeComponent(this).getHomeTemplate());

                 break;

        case "Consejos Financieros":
            mainPanelTemplate.getpShowData().removeAll();
            System.out.println("Consejos financieros en maintemplate");

            break;

        case "Egresos":
            if (this.egresosComponent == null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new EgresosComponent(this).getEgresosTemplate());
                System.out.println("Registro de ventas en maintemplate");
            }
            break;

        case "Ingresos":
            if (this.ingresosComponent== null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new IngresosComponent(this).getIngresosTemplate());
                System.out.println("Inventario en maintemplate");
            }
            System.out.println("Ingresos en maintemplate");

            break;

        case "Estadisticas finanacieras":
            mainPanelTemplate.getpShowData().removeAll();
            System.out.println("Estadisticas en maintemplate");

            break;

        case "Tabla ingresos x por motivo":
            mainPanelTemplate.getpShowData().removeAll();
            System.out.println("Tabla ingresos x por motivo en maintemplate");

            break;

        case "Tabla egresos x por motivo":
            mainPanelTemplate.getpShowData().removeAll();
            System.out.println("Tabla egresos x por motivoen maintemplate");

            break;

        case "Inventario":

            if (this.newItemInventoryComponent == null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new NewItemInventoryComponent(this).getNewItemInventoryTemplate());
                System.out.println("Inventario en maintemplate");
            }
            break;

        case "Flujo de caja":
            mainPanelTemplate.getpShowData().removeAll();
            System.out.println("Flujo de caja en maintemplate");

            break;

        case "Registro de ventas":

            if (this.newItemInventoryComponent == null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new SalesRegistryComponent(this).getSalesRegistryTemplate());
                System.out.println("Registro de ventas en maintemplate");
            }


            break;
        default:
            break;
    }

        mainPanelTemplate.repaint();

    }
}
