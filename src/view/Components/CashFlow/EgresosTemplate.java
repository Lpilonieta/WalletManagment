package view.Components.CashFlow;

import view.Services.ObjGraficosService;
import view.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class EgresosTemplate extends JPanel {

    //Servicios

    private ObjGraficosService sOjGraficosService;
    private RecursosService recursosService;

    //Obj. Graficos

    private JLabel lValor, lFuente, lMotivo, title;
    private JComboBox comboBoxFuente, comboBoxMotivo;
    private JTextField textFieldValor;
    private JButton saveData;
    private JPanel standar, advanced;

    private JCheckBox checkOpcionesAvanzadas;
    private EgresosComponent egresosComponent;
    public EgresosTemplate(EgresosComponent egresosComponent) {

        this.egresosComponent = egresosComponent;
        this.sOjGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtJPanels();
        this.builtStandarData();

        this.setSize(1300, 850);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);

    }

    public void builtJPanels (){

        this.standar = sOjGraficosService.contruirPanelGenerico(0, 0, 1300, 300, Color.WHITE, null);
        this.add(standar);
        this.advanced = sOjGraficosService.contruirPanelGenerico(0, 300, 1300, 550, Color.WHITE, null);
        this.add(advanced);
    }
    public void builtStandarData (){

        this.title = sOjGraficosService.construirJLabel("Registrar egresos" , (1300 - 260)/2 - 200,
                50, 260,40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "null"
        );
        this.standar.add(title);

        this.lValor = sOjGraficosService.construirJLabel("Valor" , (1300 - 260)/2 - 200,
                100, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.standar.add(lValor);

        this.lMotivo = sOjGraficosService.construirJLabel("Motivo", (1300 - 260)/2 - 200,
                200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.standar.add(lMotivo);

        this.lFuente = sOjGraficosService.construirJLabel("Fuente", (1300 - 260)/2 - 200,
                150, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.standar.add(lFuente);

        this.textFieldValor= sOjGraficosService.construirJTextFiel((1300 - 260)/2, 100, 400, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.standar.add(textFieldValor);

        this.comboBoxFuente = new JComboBox<>();
        this.comboBoxFuente.addItem("1");
        this.comboBoxFuente.addItem("2");
        this.comboBoxFuente.addItem("3");
        this.comboBoxFuente.addItem("4");
        this.comboBoxFuente.setSize(200,40);
        this.comboBoxFuente.setLocation((1300 - 260)/2, 150);
        this.comboBoxFuente.setForeground(Color.DARK_GRAY);
        this.comboBoxFuente.setBackground(Color.WHITE);
        this.comboBoxFuente.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxFuente.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.standar.add(comboBoxFuente);


        this.comboBoxMotivo= new JComboBox<>();
        this.comboBoxMotivo.addItem("5");
        this.comboBoxMotivo.addItem("6");
        this.comboBoxMotivo.addItem("7");
        this.comboBoxMotivo.addItem("8");
        this.comboBoxMotivo.setSize(200,40);
        this.comboBoxMotivo.setLocation((1300 - 260)/2, 200);
        this.comboBoxMotivo.setForeground(Color.DARK_GRAY);
        this.comboBoxMotivo.setBackground(Color.WHITE);
        this.comboBoxMotivo.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxMotivo.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.standar.add(comboBoxMotivo);

        saveData = sOjGraficosService.builtButton("Guardar datos", (1300 - 260)/2 - 200, 0, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), recursosService.getMainColor(),
                Color.WHITE, null, null, true, "null");
        this.saveData.addActionListener(egresosComponent);
        this.advanced.add(saveData);

        this.checkOpcionesAvanzadas = sOjGraficosService.construirJCheckBox("Opciones avanzadas",(1300 - 260)/2 - 200, 250,
                300, 30, recursosService.getCursoMano(), recursosService.getLightFont(), Color.DARK_GRAY);
        this.checkOpcionesAvanzadas.addActionListener(egresosComponent);
        this.standar.add(checkOpcionesAvanzadas);

    }

    public JComboBox getComboBoxFuente() {
        return comboBoxFuente;
    }

    public JComboBox getComboBoxMotivo() {
        return comboBoxMotivo;
    }

    public JTextField getTextFieldValor() {
        return textFieldValor;
    }

    public JCheckBox getCheckOpcionesAvanzadas() {
        return checkOpcionesAvanzadas;
    }

    public JPanel getAdvanced() {
        return advanced;
    }
}
