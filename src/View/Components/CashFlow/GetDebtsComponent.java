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

        this.getDataAquirirDeudaForm();
        this.verificationInteres();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //aqui
        Pasives pasive = new Pasives(Form.parseDatetoString(),
                Integer.valueOf(textFieldValorInString),
                comboBoxFuenteInString,
                comboBoxMotivoInString,
                Constants.RENEUE_FORM_TYPE,
                Manager.getFinEspId(),
                textFieldNombre,
                textFieldDescripcion,
                setType(comboBoxTipoCorrienteNoCorriente),
                Integer.valueOf(textFieldPorcentajeInteres),
                setSaldoDeuda(textFieldValorInString,textFieldPorcentajeInteres,comboBoxTipoInteres),
                Integer.valueOf(textFieldNumCoutas),
                setValorCuota(),
                setPeriodicidad(),
                Integer.valueOf(textFieldPeriodicidadEspecifica));
        SQLconection.SaveSqlPasives(pasive);
        SQLconection.SaveCashFlow(pasive);

    }

    private byte setPeriodicidad() {
        if (comboBoxPeriodicidad == "Diaria"){
            return Constants.DAILY;
        } else if (comboBoxPeriodicidad == "Semanal") {
            return Constants.WEEKLY;
        } else if (comboBoxPeriodicidad == "Mensual") {
            return Constants.MONTHLY;
        }else return Constants.YEARLY;
    }

    private float setValorCuota() {
        float valorBase= Float.valueOf(textFieldValorInString);
        float porcentajeDeInteres=Integer.valueOf(textFieldPorcentajeInteres);
        int numCuota = Integer.parseInt(textFieldNumCoutas);
        if (comboBoxTipoInteres =="Normal"){
            float cuota = (valorBase+(valorBase*porcentajeDeInteres))/numCuota;
        }
            return 0;
    }

    private int setSaldoDeuda(String textFieldValorInString, String textFieldPorcentajeInteres, String comboBoxTipoInteres) {
        if (textFieldPorcentajeInteres == "0" || textFieldPorcentajeInteres==""||textFieldPorcentajeInteres==" ")textFieldPorcentajeInteres="1";

        if (comboBoxTipoInteres == "Compuesto"){
            return -1; //TODO: calcular cuota con intr??s compuesto
        } else {
            float porcentajeDeInteres=Integer.valueOf(textFieldPorcentajeInteres);
            float valorBase = Integer.valueOf(textFieldValorInString);
            return (int)(valorBase + (valorBase*(porcentajeDeInteres/100)));
        }
    }

    private byte setType(String comboBoxTipoCorrienteNoCorriente) {
        if (comboBoxTipoCorrienteNoCorriente == "Corriente"){
            return Constants.CURRENT;
        }else return Constants.NO_CURRENT;
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

    public void verificationInteres (){

        if (comboBoxTipoInteres == "Ninguno"){

            this.getDebtsTemplate.getTextFieldPorcentajeInteres().setEnabled(true);
        } else {
            this.getDebtsTemplate.getTextFieldPorcentajeInteres().setEnabled(false);

        }
    }

    public GetDebtsTemplate getGetDebtsTemplate() {
        return getDebtsTemplate;
    }
}
