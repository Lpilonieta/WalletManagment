package View.Components.InitApp;

import View.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeComponent implements ActionListener {

    private HomeTemplate homeTemplate;

    private MainPanelComponent mainPanelComponent;

    public HomeComponent(MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.homeTemplate = new HomeTemplate(this, "ingresosDePrueba", "egresosDePrueba");

    }

    public HomeTemplate getHomeTemplate() {
        return homeTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object optionSelected = e.getSource();
        String optionSelectedInString = "null";


        if (optionSelected == homeTemplate.getbFlujoDeCaja()) {

            optionSelectedInString = "Consejos Financieros";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbEgresos()) {
            optionSelectedInString = "Egresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbIngresos()) {
            optionSelectedInString = "Ingresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbEstadisticas()) {
            optionSelectedInString = "Estadisticas finanacieras";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbTablaIngresosxMotivos()) {
            optionSelectedInString = "TablaIngresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbTablaEgresosxMotivo()) {
            optionSelectedInString = "TablaEgresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbInventario()) {
            optionSelectedInString = "Inventario";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbFlujodeCaja()){
            optionSelectedInString = "Flujo de caja";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == homeTemplate.getbRegistroVentas()){
            optionSelectedInString = "Registro de ventas";
            System.out.println(optionSelectedInString);
        }

        this.mainPanelComponent.showComponents(optionSelectedInString.trim());
    }


}
