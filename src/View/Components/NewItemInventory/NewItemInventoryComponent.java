package View.Components.NewItemInventory;


import Model.SQLconection;
import View.MainPanel.MainPanelComponent;
import View.Components.Groups.GroupsComponent;
import ViewModel.Constants;
import ViewModel.Form;
import ViewModel.Inventory;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewItemInventoryComponent implements ActionListener {

    private NewItemInventoryTemplate newItemInventoryTemplate;
    private MainPanelComponent mainPanelComponent;

    private GroupsComponent groupsComponent;

    //Obj. de clase
   private String name_Product,  description_Product, type_Product, category_Product, valorStock_Product,
            valorXUnidad_Product, comboBoxNegociosInString, comboBoxFuenteInString, comboBoxMotivoInString, textFieldValorInString;

    public NewItemInventoryComponent (MainPanelComponent mainPanelComponent){

        this.newItemInventoryTemplate = new NewItemInventoryTemplate(this);
        this.mainPanelComponent = mainPanelComponent;

    }

    public NewItemInventoryTemplate getNewItemInventoryTemplate() {
        return newItemInventoryTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        this.getDataFormRegistrarInventario();

        Inventory item = new Inventory(Form.parseDatetoString(),
                0,
                "source",
                "motive",
                Constants.EXPENSE_FORM_TYPE,
                setInvId(),
                name_Product,
                description_Product,
                setType(),
                0,
                Integer.valueOf(valorStock_Product),
                0F,
                Float.valueOf(valorXUnidad_Product),
                category_Product,
                setCategory());
        SQLconection.SaveSqlInventory(item);
        SQLconection.SaveCashFlow(item);
        //Prueba de que se ajunten los datos a las variables
        System.out.println(name_Product + ", " + description_Product + ", " + type_Product + ", " + category_Product + ", " + valorXUnidad_Product + ", " + valorStock_Product + ", "
                + comboBoxNegociosInString);
        System.out.println("Boton selecionado");
    }

    private byte setCategory() {
        for (String category :
                Constants.ProductosConIVA) {
            if (category_Product.equals(category)){
                return 1;
            }
        }return 0;
    }

    private byte setType() {
        if (type_Product == "Corriente"){
            return Constants.CURRENT;
        }else return Constants.NO_CURRENT;
    }

    private int setInvId() {
        String nameSelected = comboBoxNegociosInString;
        for (FinancialSpace financialSpace :
                Manager.getAllFinancialSpaces()) {
            if (nameSelected.equals(financialSpace.getName()))return financialSpace.getId();
        }return 0;
    }

    public void getDataFormRegistrarInventario (){

      name_Product = newItemInventoryTemplate.getTextFieldName().getText();
      description_Product = newItemInventoryTemplate.getTextFieldDescription().getText();
      type_Product = ((String) newItemInventoryTemplate.getComboBoxType().getSelectedItem());
      category_Product = ((String) newItemInventoryTemplate.getComboBoxCategory().getSelectedItem());
      valorStock_Product = newItemInventoryTemplate.getTextFielValorStock().getText();
      valorXUnidad_Product = newItemInventoryTemplate.getTextFielValorxUnidad().getText();
      comboBoxNegociosInString = ((String) newItemInventoryTemplate.getComboBoxNegocio().getSelectedItem());
      comboBoxFuenteInString = (String) newItemInventoryTemplate.getComboBoxFuente().getSelectedItem();
      comboBoxMotivoInString = (String) newItemInventoryTemplate.getComboBoxMotivo().getSelectedItem();
      textFieldValorInString = newItemInventoryTemplate.getTextFieldValor().getText();

    }
}
