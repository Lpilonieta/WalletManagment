package ViewModel.Components.CashFlow;

import ViewModel.MainPanel.MainPanelComponent;

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

        if (ingresosTemplate.getCheckOpcionesAvanzadas().isSelected()) {
            if (this.registryNewAssetComponent == null) {
                ingresosTemplate.getAdvanced().removeAll();
                ingresosTemplate.getAdvanced().add(new RegistryNewAssetComponent(this).getRegistryNewAssetTemplate());
                ingresosTemplate.getAdvanced().repaint();
                System.out.println("Entró");
            }
        }
    }
    public void getDataIngresosForm (){

        textFieldValorInString = ingresosTemplate.getTextFieldValor().getText();
        comboBoxFuenteInString = ((String) ingresosTemplate.getComboBoxFuente().getSelectedItem());
        comboBoxMotivoInString = ((String) ingresosTemplate.getComboBoxMotivo().getSelectedItem());
    }
}
