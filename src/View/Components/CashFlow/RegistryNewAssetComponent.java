package View.Components.CashFlow;

import Model.SQLconection;
import ViewModel.Assets;
import ViewModel.Constants;
import ViewModel.Form;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

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
        Assets asset = new Assets(Form.parseDatetoString(),
                Integer.valueOf(textFieldValorInString),
                comboBoxFuenteInString,
                comboBoxFuenteInString,
                Constants.EXPENSE_FORM_TYPE,
                Manager.getFinEspId(),
                name_assetInString,
                description_assetInString,
                Constants.CURRENT,
                Integer.valueOf(percetRentibyliyInString));
        SQLconection.SaveSqlAssets(asset);
        SQLconection.SaveCashFlow(asset);
        System.out.println(name_assetInString + " " + description_assetInString + " " + type_assetInString + " " + percetRentibyliyInString + " " + textFieldValorInString
        + " " + comboBoxMotivoInString + " " + comboBoxFuenteInString);

    }
//    private int setInvId() {
//        String nameSelected = comboBoxNegociosInString;
//        for (FinancialSpace financialSpace :
//                Manager.getAllFinancialSpaces()) {
//            if (nameSelected.equals(financialSpace.getName()))return financialSpace.getId();
//        }return 0;
//    }

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
