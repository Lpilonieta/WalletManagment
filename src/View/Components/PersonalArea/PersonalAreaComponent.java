package View.Components.PersonalArea;

import View.MainPanel.MainPanelComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalAreaComponent implements ActionListener {

    private PersonalAreaTemplate personalAreaTemplate;

    private MainPanelComponent mainPanelComponent;

    public PersonalAreaComponent (MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.personalAreaTemplate = new PersonalAreaTemplate(this, "ingreossoDePrueba", "egresosDePruba");

    }




    public PersonalAreaTemplate getPersonalAreaTemplate() {
        return personalAreaTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object optionSelected = e.getSource();
        String optionSelectedInString = "null";


         if (optionSelected == personalAreaTemplate.getbEgresos()) {
            optionSelectedInString = "Egresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == personalAreaTemplate.getbIngresos()) {
            optionSelectedInString = "Ingresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == personalAreaTemplate.getbEstadisticas()) {
            optionSelectedInString = "Estadisticas finanacieras";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == personalAreaTemplate.getbTablaIngresosxMotivos()) {
            optionSelectedInString = "TablaIngresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == personalAreaTemplate.getbTablaEgresosxMotivo()) {
            optionSelectedInString = "TablaEgresos";
            System.out.println(optionSelectedInString);
        } else if (optionSelected == personalAreaTemplate.getbFlujoDeCaja()){
            optionSelectedInString = "Flujo de caja";
            System.out.println(optionSelectedInString);
        }
        this.mainPanelComponent.showComponents(optionSelectedInString.trim());
    }

}

