package View.Components.CashFlow;

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
