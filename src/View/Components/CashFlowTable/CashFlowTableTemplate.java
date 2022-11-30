package View.Components.CashFlowTable;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CashFlowTableTemplate extends JPanel {

    //Servicios
    public CashFlowTableComponent cashFlowTableComponent;

    private RecursosService recursosService;

    private ObjGraficosService objGraficosService;

    private JPanel pOptions, pData;

    //Obj. Graficos
    private JLabel lTitle, lTitle2, lInstructions, lEslogan, lId, lIdValue, lMotivo, lSaldoInicial, tSaldoIncial, tSaldoFinal, lSaldoFinal;
    private JButton bShow, bInsert, bFiltrar, bModify, bDelete;

    private JTextField tConsult;

    private JScrollPane pTable;
    private JTable table;
    private JTableHeader header;
    private DefaultTableModel model;
    private String [] cabecera={"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };


    //Obj. Decorador

    private Color colorGray;


    public CashFlowTableTemplate (CashFlowTableComponent cashFlowTableComponent){

        this.cashFlowTableComponent = cashFlowTableComponent;
        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtPaneles();
        this.crearJTable();
        this.builtPOptions();
        this.builtpDatos();

        this.setBackground(recursosService.getColorGrisClaro());
        this.colorGray = new Color (235, 235, 235);
        this.setSize(1300, 850);
        this.setLayout(null);
        this.setVisible(true);

    }

    public void crearJTable (){
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cabecera);

        table = new JTable();
        table.setModel(model);

        header = table.getTableHeader();

        pTable = objGraficosService.construirPanelBarra(table, 30,260,580,370,Color.WHITE, null);
        this.add(pTable);
        table.addMouseListener(cashFlowTableComponent);

    }

    public void builtPaneles (){

        pOptions = objGraficosService.contruirPanelGenerico(40,10,600,200,Color.WHITE, null);
        this.add(pOptions);
        pData = objGraficosService.contruirPanelGenerico(700,10,280,600,Color.WHITE, null);
        this.add(pData);
    }

    public void builtPOptions (){

        lTitle = objGraficosService.construirJLabel("Edición de tabla", 20, 10, 200, 30, recursosService.getColorGrisOscuro(), Color.WHITE,
                recursosService.getMainFont(), null, null, null, "null");
        this.pOptions.add(lTitle);

        tConsult = objGraficosService.construirJTextFiel(30,60,380,40, "Filtrar...", recursosService.getColorGrisClaro(),
                recursosService.getCursivafont(), "null", recursosService.getCursoTexto());
        this.pOptions.add(tConsult);

        //BOTÓN FILTRAR
        bFiltrar = objGraficosService.builtButton("Filtrar", 430, 65, 120,35, recursosService.getCursoMano(),
                recursosService.getLightFont(), recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bFiltrar.addFocusListener(cashFlowTableComponent);
        bFiltrar.addActionListener(cashFlowTableComponent);
        pOptions.add(bFiltrar);

        //BOTON MOSTRAR

        bShow = objGraficosService.builtButton("Mostrar", 10,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
                ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bShow.addFocusListener(cashFlowTableComponent);
        bShow.addActionListener(cashFlowTableComponent);
        pOptions.add(bShow);

        // BOTON MODIFICAR

        bModify = objGraficosService.builtButton("Modificar", 220,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
                ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bModify.addFocusListener(cashFlowTableComponent);
        bModify.addActionListener(cashFlowTableComponent);
        pOptions.add(bModify);

        //BOTON ELIMINAR

        bDelete = objGraficosService.builtButton("Eliminar", 440,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
                ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bDelete.addFocusListener(cashFlowTableComponent);
        bDelete.addActionListener(cashFlowTableComponent);
        pOptions.add(bDelete);
    }

    public void builtpDatos (){

        lInstructions = objGraficosService.construirJLabel("<html>Tabla de flujo de caja <html>", 20,20,120,
                75,recursosService.getColorGrisOscuro(), Color.WHITE, recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lInstructions);

        lEslogan= objGraficosService.construirJLabel("<html>A continuación puedes ver y editar <br> tu flujo de caja <html>", 20,90,280,
                75,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "LEFT");
        this.pData.add(lEslogan);

        lId= objGraficosService.construirJLabel("# Registros", 20,160,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lId);

        lIdValue = objGraficosService.construirJLabel("0", 30,160,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "RIGHT");
        this.pData.add(lIdValue);

        lSaldoInicial = objGraficosService.construirJLabel("Saldo inicial", 20,200,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lSaldoInicial);

        tSaldoIncial = objGraficosService.construirJLabel("Saldo inicial", 20,200,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(tSaldoIncial);

        tSaldoFinal = objGraficosService.construirJLabel("0", 60,250,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "LEFT");
        this.pData.add(tSaldoFinal);

        lSaldoFinal = objGraficosService.construirJLabel("Saldo final", 20,350,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lSaldoFinal);

        tSaldoFinal = objGraficosService.construirJLabel("0", 60,390,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "LEFT");
        this.pData.add(tSaldoFinal);


    }


    public CashFlowTableComponent getCashFlowTableComponent() {
        return cashFlowTableComponent;
    }

    public JLabel getlIdValue() {
        return lIdValue;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getbShow() {
        return bShow;
    }

    public JButton getbInsert() {
        return bInsert;
    }

    public JButton getbFiltrar() {
        return bFiltrar;
    }

    public JButton getbModify() {
        return bModify;
    }

    public JButton getbDelete() {
        return bDelete;
    }

    public JTextField gettConsult() {
        return tConsult;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
