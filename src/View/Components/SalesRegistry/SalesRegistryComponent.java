package View.Components.SalesRegistry;

import Model.SQLconection;
import View.MainPanel.MainPanelComponent;
import ViewModel.Inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SalesRegistryComponent implements ActionListener {

    private SalesRegistryTemplate salesRegistryTemplate;

    private MainPanelComponent mainPanelComponent;

    // Obj. Graficos

    private String textFieldNumVentasInString, comboBoxlSelectItemInString; //comboBoxNegociosInString;

    public SalesRegistryComponent(MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.salesRegistryTemplate = new SalesRegistryTemplate(this);

    }

    public SalesRegistryTemplate getSalesRegistryTemplate() {
        return salesRegistryTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Id;
        String stock;
        String ventasT;
        try {
            for (Inventory inv :
                    SQLconection.getallInventoryFromDB()) {
                if (inv.getName().equals(comboBoxlSelectItemInString)){
                    Id = inv.getId();
                    stock = String.valueOf(inv.getStockNumber()-Integer.valueOf(textFieldNumVentasInString));
                    ventasT = String.valueOf(inv.getSaleNumbers()+Integer.valueOf(textFieldNumVentasInString));
                    SQLconection.modifyInventory(Id,stock,ventasT);
                    break;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        this.getDataFormRegistarInventario();
        System.out.println(textFieldNumVentasInString + ", " + comboBoxlSelectItemInString);

    }

    public void getDataFormRegistarInventario (){

        textFieldNumVentasInString = salesRegistryTemplate.getTextFieldNumVentas().getText();
        comboBoxlSelectItemInString = ((String) salesRegistryTemplate.getComboBoxlSelectItem().getSelectedItem());
       // comboBoxNegociosInString = (String) salesRegistryTemplate.getComboBoxNegocio().getSelectedItem();

    }
}
