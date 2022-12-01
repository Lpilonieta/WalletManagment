package View.Components.CashFlow;

import Model.SQLconection;
import View.MainPanel.MainPanelComponent;
import ViewModel.Constants;
import ViewModel.Form;
import ViewModel.Pasives;
import ViewModel.Spaces.Manager;

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

        if (!egresosTemplate.getCheckOpcionesAvanzadas().isSelected()) {
            Form form = new Form(Form.parseDatetoString(),
                    Integer.valueOf(textFieldValorInString),
                    comboBoxFuenteInString,
                    comboBoxMotivoInString,
                    Constants.EXPENSE_FORM_TYPE,
                    Manager.getFinEspId());
            SQLconection.SaveSqlForms(form);
            SQLconection.SaveCashFlow(form);
        }


    }

    public void getDataIngresosForm (){

        this.textFieldValorInString = egresosTemplate.getTextFieldValor().getText().trim();
        this.comboBoxFuenteInString = ((String) egresosTemplate.getComboBoxFuente().getSelectedItem());
        this.comboBoxMotivoInString = ((String) egresosTemplate.getComboBoxMotivo().getSelectedItem());

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
