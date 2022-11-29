package View.Components.CashFlow;

import View.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EgresosComponent implements ActionListener {

    private EgresosTemplate egresosTemplate;

    private String textFieldValorInString, comboBoxFuenteInString, comboBoxMotivoInString;

    private GetDebtsTemplate getDebtsTemplate;

    private MainPanelComponent mainPanelComponent;
    public EgresosComponent (MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.egresosTemplate = new EgresosTemplate(this);
    }

    public EgresosTemplate getEgresosTemplate() {
        return egresosTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.getDataIngresosForm();
        this.checkValidadtion();

    }

    public void getDataIngresosForm (){

        textFieldValorInString = egresosTemplate.getTextFieldValor().getText();
        comboBoxFuenteInString = ((String) egresosTemplate.getComboBoxFuente().getSelectedItem());
        comboBoxMotivoInString = ((String) egresosTemplate.getComboBoxMotivo().getSelectedItem());

    }

    public void checkValidadtion (){

        if (egresosTemplate.getCheckOpcionesAvanzadas().isSelected()) {
            if (this.getDebtsTemplate == null) {
                egresosTemplate.getAdvanced().removeAll();
                egresosTemplate.getAdvanced().add(new GetDebtsComponent(this, egresosTemplate).getGetDebtsTemplate());
                egresosTemplate.getAdvanced().repaint();
                System.out.println("Entró");

            }
        }
    }
}
