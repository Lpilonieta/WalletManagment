package view.Components.CashFlow;

import view.Services.ObjGraficosService;
import view.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class GetDebtsTemplate extends JPanel {

    //Servicios

    private ObjGraficosService sOjGraficosService;
    private RecursosService recursosService;
    private GetDebtsComponent getDebtsComponent;

    //Obj. Garficos

    private JLabel labelDeudor, labelNombre, labelDescription, labelTipoInteres,
            labelPorcentajeInteres, labelTipoCorrienteNoCorriente, labelNumCoutas, labelPeriodicidad, labelPEspecifica, labelFecha1erPago, title;

    private JTextField textFielDeudor, textFieldNombre, textFieldDescripcion, textFieldPorcentajeInteres, textFieldNumCoutas, textFieldPeriodicidadEspecifica, textFieldFecha1erPago;
    private JComboBox comboBoxTipoInteres, comboBoxTipoCorrienteNoCorriente, comboBoxPeriodicidad;
    private JButton saveData;

  public GetDebtsTemplate (GetDebtsComponent getDebtsComponent){

      this.getDebtsComponent = getDebtsComponent;
      this.sOjGraficosService = ObjGraficosService.getService();
      this.recursosService = RecursosService.getService();

      this.builtJTextField();
      this.builtLabels();
      this.builtJComboBox();
      this.builtButton();

      this.setSize(1300, 550);
      this.setBackground(Color.WHITE);
      this.setLayout(null);
      this.setVisible(true);

  }
    public void builtLabels (){

    //Fila 1

        this.title= sOjGraficosService.construirJLabel("Registrar una deuda" , (1300 - 260)/2 - 200,
                10, 260,40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "CENTER"
        );
        this.add(title);

        this.labelDeudor = sOjGraficosService.construirJLabel("Deudor" , (1300 - 260)/2 - 500,
                100, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelDeudor);

        this.labelNombre = sOjGraficosService.construirJLabel("Nombre" , (1300 - 260)/2 - 500,
                190, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelNombre);

        this.labelDescription = sOjGraficosService.construirJLabel("Descripción" , (1300 - 260)/2 - 500,
                280, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelDescription);

        //Fila 2

        this.labelTipoInteres = sOjGraficosService.construirJLabel("Tipo interés" , (1300 - 260)/2 - 200,
                100, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelTipoInteres);

        this.labelPorcentajeInteres = sOjGraficosService.construirJLabel("% Interés" , (1300 - 260)/2 - 200,
                200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelPorcentajeInteres );

        this.labelTipoCorrienteNoCorriente = sOjGraficosService.construirJLabel("Tipo" , (1300 - 260)/2 - 180,
                280, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelTipoCorrienteNoCorriente);

        this.labelFecha1erPago = sOjGraficosService.construirJLabel("1er fecha de pago" , (1300 - 260)/2 - 260,
                350, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelFecha1erPago);


        //FILA 3

        this.labelNumCoutas = sOjGraficosService.construirJLabel("Num coutas" , (1300 - 260)/2 + 150,
                100, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelNumCoutas);

        this.labelPeriodicidad = sOjGraficosService.construirJLabel("Periodicidad" , (1300 - 260)/2 + 150,
                200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelPeriodicidad);

        this.labelPEspecifica = sOjGraficosService.construirJLabel("Periodicidad Fija" , (1300 - 260)/2 + 150,
                280, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(labelPEspecifica);


    }

    public void builtJTextField (){

      //Fila 1
        this.textFielDeudor= sOjGraficosService.construirJTextFiel((1300 - 260)/2 - 435, 100, 200, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFielDeudor);

        this.textFieldNombre= sOjGraficosService.construirJTextFiel((1300 - 260)/2 - 435, 190, 200, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldNombre);

        this.textFieldDescripcion= sOjGraficosService.construirJTextFiel((1300 - 260)/2 - 400, 280, 200, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldDescripcion);

      //Fila 2

        this.textFieldPorcentajeInteres= sOjGraficosService.construirJTextFiel((1300 - 260)/2 - 100, 200, 100, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldPorcentajeInteres);

        this.textFieldFecha1erPago = sOjGraficosService.construirJTextFiel((1300 - 260)/2 - 100, 350, 200, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldFecha1erPago);


      //Fila 3
        this.textFieldNumCoutas = sOjGraficosService.construirJTextFiel((1300 - 260)/2 + 250, 100, 200, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldNumCoutas);

        this.textFieldPeriodicidadEspecifica = sOjGraficosService.construirJTextFiel((1300 - 260)/2 + 250, 280, 100, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldPeriodicidadEspecifica );

    }

    public void builtJComboBox (){

        this.comboBoxTipoInteres= new JComboBox<>();
        this.comboBoxTipoInteres.addItem("Ninguno");
        this.comboBoxTipoInteres.addItem("Normal");
        this.comboBoxTipoInteres.addItem("Compuesto");
        this.comboBoxTipoInteres.setSize(200,40);
        this.comboBoxTipoInteres.setLocation((1300 - 260)/2 - 100, 100);
        this.comboBoxTipoInteres.setForeground(Color.DARK_GRAY);
        this.comboBoxTipoInteres.setBackground(Color.WHITE);
        this.comboBoxTipoInteres.setCursor(recursosService.getCursoMano());
        ((JLabel)comboBoxTipoInteres.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxTipoInteres);

        this.comboBoxTipoCorrienteNoCorriente= new JComboBox<>();
        this.comboBoxTipoCorrienteNoCorriente.addItem("Corriente");
        this.comboBoxTipoCorrienteNoCorriente.addItem("No corriente");
        this.comboBoxTipoCorrienteNoCorriente.setSize(100,40);
        this.comboBoxTipoCorrienteNoCorriente.setLocation((1300 - 260)/2 - 100, 280);
        this.comboBoxTipoCorrienteNoCorriente.setForeground(Color.DARK_GRAY);
        this.comboBoxTipoCorrienteNoCorriente.setBackground(Color.WHITE);
        this.comboBoxTipoCorrienteNoCorriente.setCursor(recursosService.getCursoMano());
        ((JLabel)comboBoxTipoCorrienteNoCorriente.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxTipoCorrienteNoCorriente);

        this.comboBoxPeriodicidad= new JComboBox<>();
        this.comboBoxPeriodicidad.addItem("Diaria");
        this.comboBoxPeriodicidad.addItem("Semanal");
        this.comboBoxPeriodicidad.addItem("Mensual");
        this.comboBoxPeriodicidad.addItem("Anual");
        this.comboBoxPeriodicidad.setSize(100,40);
        this.comboBoxPeriodicidad.setLocation((1300 - 260)/2 + 250, 200);
        this.comboBoxPeriodicidad.setForeground(Color.DARK_GRAY);
        this.comboBoxPeriodicidad.setBackground(Color.WHITE);
        this.comboBoxPeriodicidad.setCursor(recursosService.getCursoMano());
        ((JLabel)comboBoxPeriodicidad.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxPeriodicidad);


    }

    public void builtButton (){

        saveData = sOjGraficosService.builtButton("Guardar datos", (1300 - 260)/2 - 200, 400, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), recursosService.getMainColor(),
                Color.WHITE, null, null, true, "null");
        this.saveData.addActionListener(getDebtsComponent);
        this.add(saveData);

    }

    public JTextField getTextFielDeudor() {
        return textFielDeudor;
    }

    public JTextField getTextFieldNombre() {
        return textFieldNombre;
    }

    public JTextField getTextFieldDescripcion() {
        return textFieldDescripcion;
    }

    public JTextField getTextFieldPorcentajeInteres() {
        return textFieldPorcentajeInteres;
    }

    public JTextField getTextFieldNumCoutas() {
        return textFieldNumCoutas;
    }

    public JTextField getTextFieldPeriodicidadEspecifica() {
        return textFieldPeriodicidadEspecifica;
    }

    public JTextField getTextFieldFecha1erPago() {
        return textFieldFecha1erPago;
    }

    public JComboBox getComboBoxTipoInteres() {
        return comboBoxTipoInteres;
    }

    public JComboBox getComboBoxTipoCorrienteNoCorriente() {
        return comboBoxTipoCorrienteNoCorriente;
    }

    public JComboBox getComboBoxPeriodicidad() {
        return comboBoxPeriodicidad;
    }
}
