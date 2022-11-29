package View.Components.SalesRegistry;

import View.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesRegistryComponent implements ActionListener {

    private SalesRegistryTemplate salesRegistryTemplate;

    private MainPanelComponent mainPanelComponent;

    // Obj. Graficos

    private String textFieldNumVentasInString, comboBoxlSelectItemInString, comboBoxNegociosInString;

    public SalesRegistryComponent(MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.salesRegistryTemplate = new SalesRegistryTemplate(this);

    }

    public SalesRegistryTemplate getSalesRegistryTemplate() {
        return salesRegistryTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        this.getDataFormRegistarInventario();
        System.out.println(textFieldNumVentasInString + ", " + comboBoxlSelectItemInString);

    }

    public void getDataFormRegistarInventario (){

        textFieldNumVentasInString = salesRegistryTemplate.getTextFieldNumVentas().getText();
        comboBoxlSelectItemInString = ((String) salesRegistryTemplate.getComboBoxlSelectItem().getSelectedItem());
        comboBoxNegociosInString = (String) salesRegistryTemplate.getComboBoxNegocio().getSelectedItem();

    }
}
