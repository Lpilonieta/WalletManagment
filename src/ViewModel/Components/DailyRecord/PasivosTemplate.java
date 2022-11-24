package ViewModel.Components.DailyRecord;

import ViewModel.MainPanel.MainPanelTemplate;
import ViewModel.Services.ObjGraficosService;
import ViewModel.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class PasivosTemplate extends JPanel {

    //Servcios y dependencias

    private PasivosComponent pasivosComponent;
    private ObjGraficosService sOjGraficosService;

    private RecursosService recursosService;


    //Obj. Graficos

    private JLabel title, name, description, type, interes, nCoutas, periodicidad, datePago, typeInteres;
    private JComboBox comboBoxType, comboBoxInteres, comboBoxPeriodicidad, comboBoxPrimerPago;
    private JTextField textName, textDescription, textInteres, textNumCoutas;
    private JButton saveData;
    private JCheckBox option, option2;

    public PasivosTemplate(PasivosComponent pasivosComponent) {

        this.pasivosComponent = pasivosComponent;
        this.sOjGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();


        this.builtLabels();
        this.builtJTextField();
        this.builtJComboBox();
        this.builtButton();
        this.builtCheckBox();

        this.setSize(1300, 850);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void builtLabels (){

        this.title = sOjGraficosService.construirJLabel("Formulario pasivos" , (1300 - 260)/2 - 200,
                50, 260,40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "null"
        );
        this.add(title);

    this.name = sOjGraficosService.construirJLabel("Nombre" , (1300 - 260)/2 - 200,
            200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
            );
    this.add(name);

    this.description = sOjGraficosService.construirJLabel("Descripción", (1300 - 260)/2 - 200,
            250, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
            );
    this.add(description);

    this.typeInteres = sOjGraficosService.construirJLabel("Tipo de interés", (1300 - 260)/2 - 200,
            350, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
    this.add(typeInteres);

    this.type = sOjGraficosService.construirJLabel("Tipo", (1300 - 260)/2 - 200,
            300, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
    this.add(type);

    this.interes = sOjGraficosService.construirJLabel("% Interés", (1300 - 260)/2 - 200,
            400, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
    this.add(interes);

    this.nCoutas = sOjGraficosService.construirJLabel("Num Coutas", (1300 - 260)/2 - 200,
            450, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
    this.add(nCoutas);

    this.periodicidad = sOjGraficosService.construirJLabel("Periodicidad", (1300 - 260)/2 - 200,
            500, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
    this.add(periodicidad);

    this.datePago = sOjGraficosService.construirJLabel("Primer fecha de pago", (1300 - 260)/2 - 200,
            550, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
    this.add(datePago);
    }

    public void builtJTextField (){

        this.textName = sOjGraficosService.construirJTextFiel((1300 - 260)/2, 200, 400, 40,
                null, Color.DARK_GRAY, Color.WHITE, Color.DARK_GRAY, Color.DARK_GRAY, recursosService.getLightFont(), "null");
        this.textName.setCursor(recursosService.getCursoTexto());
        this.add(textName);

        this.textDescription = sOjGraficosService.construirJTextFiel((1300 - 260)/2, 250, 400, 40,
                null, Color.DARK_GRAY, Color.WHITE, Color.DARK_GRAY, Color.DARK_GRAY, recursosService.getLightFont(), "null");
        this.textDescription.setCursor(recursosService.getCursoTexto());
        this.add(textDescription);

        this.textInteres= sOjGraficosService.construirJTextFiel((1300 - 260)/2 , 400, 100, 40,
                null, Color.DARK_GRAY, Color.WHITE, Color.DARK_GRAY, Color.DARK_GRAY, recursosService.getLightFont(), "null");
        this.textInteres.setCursor(recursosService.getCursoTexto());
        this.add(textInteres);

        this.textNumCoutas = sOjGraficosService.construirJTextFiel((1300 - 260)/2 , 450, 100, 40,
                null, Color.DARK_GRAY, Color.WHITE, Color.DARK_GRAY, Color.DARK_GRAY, recursosService.getLightFont(), "null");
        this.textNumCoutas.setCursor(recursosService.getCursoTexto());
        this.add(textNumCoutas);

    }

    public void builtJComboBox (){

        this.comboBoxType = sOjGraficosService.construirJComboBox((1300 - 260)/2, 350, 200,
                40, recursosService.getLightFont(), "Seleccione", Color.WHITE, Color.DARK_GRAY, "c");
        this.comboBoxType.addItem("Compuesto");
        this.comboBoxType.addItem("Normal");
        this.comboBoxType.setCursor(recursosService.getCursoMano());

        ((JLabel) this.comboBoxType.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        this.add(comboBoxType);

        this.comboBoxPeriodicidad = sOjGraficosService.construirJComboBox((1300 - 260)/2, 500, 200,
                40, recursosService.getLightFont(), "Seleccione", Color.WHITE, Color.DARK_GRAY, "c");
        this.comboBoxPeriodicidad.addItem("Diaria");
        this.comboBoxPeriodicidad.addItem("Semanal");
        this.comboBoxPeriodicidad.addItem("Mensual");
        this.comboBoxPeriodicidad.addItem("Anual");
        this.comboBoxPeriodicidad.setCursor(recursosService.getCursoMano());

        ((JLabel) this.comboBoxPeriodicidad.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        this.add(comboBoxPeriodicidad);


        this.comboBoxInteres = sOjGraficosService.construirJComboBox((1300 - 260)/2, 300, 200,
                40, recursosService.getLightFont(), "Seleccione", Color.WHITE, Color.DARK_GRAY, "c");
        this.comboBoxInteres.addItem("Corriente");
        this.comboBoxInteres.addItem("No corriente");
        this.comboBoxInteres.setCursor(recursosService.getCursoMano());

        ((JLabel) this.comboBoxInteres.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        this.add(comboBoxInteres);
    }

    public void builtButton (){

        saveData = sOjGraficosService.builtButton("Guardar datos", (1300 - 260)/2 - 200, 680, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), recursosService.getMainColor(),
                Color.WHITE, null, null, true, "null");
     this.add(saveData);
    }

    public void builtCheckBox (){

        this.option = sOjGraficosService.construirJCheckBox("",(1300 - 260)/2 - 250, 510, 20, 20, recursosService.getCursoMano(), null,
                null);
        this.add(option);

        this.option2 = sOjGraficosService.construirJCheckBox("",(1300 - 260)/2 - 250, 560, 20, 20, recursosService.getCursoMano(), null,
                null);
        this.add(option2 );
    }


}

