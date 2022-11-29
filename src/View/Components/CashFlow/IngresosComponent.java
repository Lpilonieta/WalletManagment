package View.Components.CashFlow;

import View.MainPanel.MainPanelComponent;

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
