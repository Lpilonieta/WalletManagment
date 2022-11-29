package View.Components.CashFlow;

import Model.GeneralRegistry;
import Model.SQLconection;
import View.MainPanel.MainPanelComponent;
import ViewModel.Constants;
import ViewModel.Form;
import ViewModel.Spaces.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresosComponent implements ActionListener {

    private IngresosTemplate ingresosTemplate;
    private MainPanelComponent mainPanelComponent;

    private RegistryNewAssetComponent registryNewAssetComponent;


    private String textFieldValorInString, comboBoxFuenteInString, comboBoxMotivoInString;

    public IngresosComponent (MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.ingresosTemplate = new IngresosTemplate(this);

    }

    public IngresosTemplate getIngresosTemplate() {
        return ingresosTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.getDataIngresosForm();
        this.checkValidadtion();
        if (ingresosTemplate.getCheckOpcionesAvanzadas().isSelected()){
            //guardar un activo
        }else {
            Form form = new Form(Form.parseDatetoString(),Integer.valueOf(textFieldValorInString),comboBoxFuenteInString,comboBoxMotivoInString, Constants.RENEUE_FORM_TYPE, Manager.getFinEspId());
            SQLconection.SaveSqlForms(form);
        }
        System.out.println(textFieldValorInString + ", " + comboBoxMotivoInString + ", " + comboBoxFuenteInString);


    }

    public void getDataIngresosForm (){

        textFieldValorInString = ingresosTemplate.getTextFieldValor().getText();
        comboBoxFuenteInString = ((String) ingresosTemplate.getComboBoxFuente().getSelectedItem());
        comboBoxMotivoInString = ((String) ingresosTemplate.getComboBoxMotivo().getSelectedItem());

    }

    public void checkValidadtion (){

        if (ingresosTemplate.getCheckOpcionesAvanzadas().isSelected()) {
            if (this.registryNewAssetComponent == null) {
                ingresosTemplate.getAdvanced().removeAll();
                ingresosTemplate.getAdvanced().add(new RegistryNewAssetComponent(this, ingresosTemplate).getRegistryNewAssetTemplate());
                ingresosTemplate.getAdvanced().repaint();
                System.out.println("Entró");

            }
        }
    }
}
