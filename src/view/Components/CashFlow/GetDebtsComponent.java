package view.Components.CashFlow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetDebtsComponent implements ActionListener {

    private String textFielDeudor, textFieldNombre, textFieldDescripcion, textFieldPorcentajeInteres, textFieldNumCoutas,
            textFieldPeriodicidadEspecifica, textFieldFecha1erPago, comboBoxTipoInteres, comboBoxTipoCorrienteNoCorriente, comboBoxPeriodicidad;
    private GetDebtsTemplate getDebtsTemplate;

    public GetDebtsComponent (EgresosComponent egresosComponent, EgresosTemplate egresosTemplate){

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

    }

    public GetDebtsTemplate getGetDebtsTemplate() {
        return getDebtsTemplate;
    }
}
