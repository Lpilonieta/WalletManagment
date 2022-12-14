package View.MainPanel;


import View.Components.CashFlow.*;
import View.Components.CashFlowTable.CashFlowTableComponent;
import View.Components.EgresoXMotivo.EgresoxMotivoComponent;
import View.Components.InitApp.HomeComponent;
import View.Components.NewItemInventory.NewItemInventoryComponent;
import View.Components.PersonalArea.PersonalAreaComponent;
import View.Components.SalesRegistry.SalesRegistryComponent;
import View.Components.Stats.StatsComponent;
import View.Components.TitleBar.TitleBarComponent;
import View.Components.UserBrowsing.UserBrowsingComponent;
import View.Components.IngresoxMotivo.IngresoxMotivoComponent;
import View.Components.Groups.GroupsComponent;




public class MainPanelComponent {

    private MainPanelComponent mainPanelComponent;
    private MainPanelTemplate mainPanelTemplate;


    public MainPanelComponent (){
        this.mainPanelTemplate = new MainPanelTemplate(this);
        this.titleBarComponent = new TitleBarComponent(this);
        this.userBrowsingComponent = new UserBrowsingComponent(this);
        this.personalAreaComponent = new PersonalAreaComponent(this);

        mainPanelTemplate.getpBarraSuperior().add(titleBarComponent.getTitleBarTemplate());

        mainPanelTemplate.getpBarraLateral().add(userBrowsingComponent.getUserBrowsingTemplate());

        mainPanelTemplate.getpShowData().add(personalAreaComponent.getPersonalAreaTemplate());

    }
    //Componentes

    private TitleBarComponent titleBarComponent;
    //private LoginComponent loginComponent;
    private UserBrowsingComponent userBrowsingComponent;
    private EgresosComponent egresosComponent;
    private IngresosComponent ingresosComponent;
    private NewItemInventoryComponent newItemInventoryComponent;
    private GroupsComponent groupsComponent;
    private PersonalAreaComponent personalAreaComponent;

    private IngresoxMotivoComponent ingresoxMotivoComponent;
    private EgresoxMotivoComponent egresoxMotivoComponent;

    private CashFlowTableComponent cashFlowTableComponent;

    private StatsComponent statsComponent;
    public MainPanelTemplate getMainPanelTemplate() {
        return mainPanelTemplate;
    }

    public void showComponents (String comand){


    switch (comand){

        case "Add Negocio":
            System.out.println("Entr??");

            if (this.groupsComponent == null){
                mainPanelTemplate.getpShowData().removeAll();
                System.out.println("A??adiendo espacio financiero");
                this.mainPanelTemplate.getpShowData().add(new GroupsComponent().getFinalcialSpacesTemplate());
            }
            break;


        case "Ver area personal" :

            if (this.personalAreaComponent != null){
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new PersonalAreaComponent(this).getPersonalAreaTemplate());
                System.out.println("Viendo area personal");
            }

            break;

        case "Ver area avanzada":
            mainPanelTemplate.getpShowData().removeAll();
            mainPanelTemplate.getpShowData().add(new HomeComponent(this).getHomeTemplate());

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
            if (this.statsComponent== null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new StatsComponent(this).getStatsTemplate());
                System.out.println("Ingreso x motiva tabla");
            }
            break;

        case "TablaIngresos":
            if (this.ingresoxMotivoComponent == null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new IngresoxMotivoComponent(this).getIngresosxMotivoTemplate());
                    System.out.println("Ingreso x motiva tabla");
            }
        break;

        case "TablaEgresos":
            if (this.egresoxMotivoComponent == null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new EgresoxMotivoComponent(this).getEgresoXMotivoTemplate());
                System.out.println("Egreso x motiva tabla");
            }

            break;

        case "Inventario":

            if (this.newItemInventoryComponent == null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new NewItemInventoryComponent(this).getNewItemInventoryTemplate());
                System.out.println("Inventario en maintemplate");
            }
            break;

        case "Flujo de caja":
            if (this.cashFlowTableComponent== null) {
                mainPanelTemplate.getpShowData().removeAll();
                mainPanelTemplate.getpShowData().add(new CashFlowTableComponent(this).getCashFlowTableTemplate());
                System.out.println("Flujo de caja en maintemplate");
            }
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
