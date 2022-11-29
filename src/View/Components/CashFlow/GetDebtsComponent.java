package View.Components.CashFlow;

import Model.SQLconection;
import ViewModel.Constants;
import ViewModel.Form;
import ViewModel.Pasives;
import ViewModel.Spaces.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetDebtsComponent implements ActionListener {

    private String textFielDeudor, textFieldNombre, textFieldDescripcion, textFieldPorcentajeInteres, textFieldNumCoutas,
            textFieldPeriodicidadEspecifica, textFieldFecha1erPago, comboBoxTipoInteres, comboBoxTipoCorrienteNoCorriente, comboBoxPeriodicidad,
            textFieldValorInString, comboBoxFuenteInString, comboBoxMotivoInString;

    private GetDebtsTemplate getDebtsTemplate;

    private EgresosTemplate egresosTemplate;

    public GetDebtsComponent (EgresosComponent egresosComponent, EgresosTemplate egresosTemplate){

        this.egresosTemplate = egresosTemplate;
        this.getDebtsTemplate = new GetDebtsTemplate(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        this.getDataAquirirDeudaForm();
        //aqui
        Pasives pasive = new Pasives(Form.parseDatetoString(),Integer.valueOf(textFieldValorInString),
                comboBoxFuenteInString,comboBoxMotivoInString,
                Constants.EXPENSE_FORM_TYPE,
                Manager.getFinEspId(),textFieldNombre,
                textFieldDescripcion,
                Constants.CURRENT,
                Integer.valueOf(textFieldPorcentajeInteres),
                Integer.valueOf(textFieldValorInString),
                Integer.valueOf(textFieldNumCoutas),0,Constants.DAILY,Integer.valueOf(textFieldPeriodicidadEspecifica));
        SQLconection.SaveSqlPasives(pasive);
    }


    public void getDataAquirirDeudaForm (){

        this.textFielDeudor = getDebtsTemplate.getTextFielDeudor().getText();
        this.textFieldNombre = getDebtsTemplate.getTextFieldNombre().getText();
        this.textFieldDescripcion = getDebtsTemplate.getTextFieldDescripcion().getText();
        this.textFieldPorcentajeInteres = getDebtsTemplate.getTextFieldPorcentajeInteres().getText();
        this.textFieldNumCoutas = getDebtsTemplate.getTextFieldNumCoutas().getText();
        this.textFieldPeriodicidadEspecifica = getDebtsTemplate.getTextFieldPeriodicidadEspecifica().getText();
        this.textFieldFecha1erPago = getDebtsTemplate.getTextFieldFecha1erPago().getText();
        this.comboBoxTipoInteres = (String) getDebtsTemplate.getComboBoxTipoInteres().getSelectedItem();
        this.comboBoxTipoCorrienteNoCorriente = (String) getDebtsTemplate.getComboBoxTipoCorrienteNoCorriente().getSelectedItem();
        this.comboBoxPeriodicidad = (String) getDebtsTemplate.getComboBoxPeriodicidad().getSelectedItem();
        this.textFieldValorInString = egresosTemplate.getTextFieldValor().getText();
        this.comboBoxFuenteInString = (String) egresosTemplate.getComboBoxFuente().getSelectedItem();
        this.comboBoxMotivoInString = (String) egresosTemplate.getComboBoxMotivo().getSelectedItem();
    }

    public GetDebtsTemplate getGetDebtsTemplate() {
        return getDebtsTemplate;
    }
}
