package view.Components.CashFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistryNewAssetComponent implements ActionListener {

    private RegistryNewAssetTemplate registryNewAssetTemplate;
    private IngresosTemplate ingresosTemplate;

    private IngresosComponent ingresosComponent;

    private String name_assetInString, description_assetInString, type_assetInString, percetRentibyliyInString, textFieldValorInString, comboBoxFuenteInString, comboBoxMotivoInString;

    public RegistryNewAssetComponent (IngresosComponent ingresosComponent, IngresosTemplate ingresosTemplate){

        this.ingresosTemplate = ingresosTemplate;
        this.ingresosComponent = ingresosComponent;
        this.registryNewAssetTemplate = new RegistryNewAssetTemplate(this);

    }

    public RegistryNewAssetTemplate getRegistryNewAssetTemplate() {
        return registryNewAssetTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

     this.getDataRegistroActivoForm();
        System.out.println(name_assetInString + " " + description_assetInString + " " + type_assetInString + " " + percetRentibyliyInString + " " + textFieldValorInString
        + " " + comboBoxMotivoInString + " " + comboBoxFuenteInString);

    }

    public void getDataRegistroActivoForm (){

        name_assetInString = registryNewAssetTemplate.getTextFieldName().getText();
        description_assetInString = registryNewAssetTemplate.getTextFieldDescription().getText();
        type_assetInString = (String) registryNewAssetTemplate.getComboBoxType().getSelectedItem();
        percetRentibyliyInString = registryNewAssetTemplate.getTextFieldRentability().getText();
        textFieldValorInString = ingresosTemplate.getTextFieldValor().getText();
        comboBoxFuenteInString = (String) ingresosTemplate.getComboBoxFuente().getSelectedItem();
        comboBoxMotivoInString = (String) ingresosTemplate.getComboBoxMotivo().getSelectedItem();

    }

}
