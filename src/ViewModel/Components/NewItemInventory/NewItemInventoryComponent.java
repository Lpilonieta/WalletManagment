package ViewModel.Components.NewItemInventory;

import ViewModel.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewItemInventoryComponent implements ActionListener {

    private NewItemInventoryTemplate newItemInventoryTemplate;
    private MainPanelComponent mainPanelComponent;

    //Obj. de clase
   private String name_Product,  description_Product, type_Product, category_Product, valorStock_Product, valorXUnidad_Product;

    public NewItemInventoryComponent (MainPanelComponent mainPanelComponent){

        this.newItemInventoryTemplate = new NewItemInventoryTemplate(this);
        this.mainPanelComponent = mainPanelComponent;

    }

    public NewItemInventoryTemplate getNewItemInventoryTemplate() {
        return newItemInventoryTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        System.out.println("Boton selecionado");
        this.getDataFormRegistrarInventario();

        //Prueba de que se ajunten los datos a las variables
        System.out.println(name_Product + ", " + description_Product + ", " + type_Product + ", " + category_Product + ", " + valorXUnidad_Product + ", " + valorStock_Product);

    }

    public void getDataFormRegistrarInventario (){

      name_Product = newItemInventoryTemplate.getTextFieldName().getText();
      description_Product = newItemInventoryTemplate.getTextFieldDescription().getText();
      type_Product = ((String) newItemInventoryTemplate.getComboBoxType().getSelectedItem());
      category_Product = ((String) newItemInventoryTemplate.getComboBoxCategory().getSelectedItem());
      valorStock_Product = newItemInventoryTemplate.getTextFielValorStock().getText();
      valorXUnidad_Product = newItemInventoryTemplate.getTextFielValorxUnidad().getText();

    }


}
