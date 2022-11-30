package View.Components.EgresoXMotivo;

import View.Components.IngresoxMotivo.IngresoxMotivoComponent;
import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class EgresoXMotivoTemplate extends JPanel{

    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    private EgresoxMotivoComponent egresoxMotivoComponent;
    //Obj. Graficos

    private JPanel pOptions, pData;

    //Obj. Graficos
    private JLabel lTitle, lInstructions, lEslogan, lId, lIdValue, lMotivo, lEgreso;
    private JButton bShow, bInsert, bFiltrar, bModify, bDelete;
    private JTextField tConsult, tEgreso, tMotivo;
    private JScrollPane pTable;
    private JTable table;
    private JTableHeader header;
    private DefaultTableModel modelEgresos;
    private String [] cabecera={"Egreso", "Motivo"};


    //Obj. Decorador

    private Color colorGray;

    public EgresoXMotivoTemplate (EgresoxMotivoComponent egresoxMotivoComponent){

        this.egresoxMotivoComponent = egresoxMotivoComponent;
        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtPanelesEgresos();
        this.builtPOptionsEgresos();
        this.builtpDatosEgresos();
        this.crearJTableEgresos();

        this.setBackground(recursosService.getColorGrisClaro());
        this.colorGray = new Color (235, 235, 235);
        this.setSize(1300, 850);
        this.setLayout(null);
        this.setVisible(true);

    }

    public void crearJTableEgresos (){
        modelEgresos = new DefaultTableModel();
        modelEgresos.setColumnIdentifiers(cabecera);

        table = new JTable();
        table.setModel(modelEgresos);

        header = table.getTableHeader();

        pTable = objGraficosService.construirPanelBarra(table, 30,260,580,370,Color.WHITE, null);
        this.add(pTable);
        table.addMouseListener(egresoxMotivoComponent);

    }


    public void builtPanelesEgresos (){

        pOptions = objGraficosService.contruirPanelGenerico(40,10,600,200,Color.WHITE, null);
        this.add(pOptions);
        pData = objGraficosService.contruirPanelGenerico(700,10,280,600,Color.WHITE, null);
        this.add(pData);
    }

    public void builtPOptionsEgresos (){

        lTitle = objGraficosService.construirJLabel("Edición de tabla", 20, 10, 200, 30, recursosService.getColorGrisOscuro(), Color.WHITE,
                recursosService.getMainFont(), null, null, null, "null");
        this.pOptions.add(lTitle);

        tConsult = objGraficosService.construirJTextFiel(30,60,380,40, "Filtrar...", recursosService.getColorGrisClaro(),
                recursosService.getCursivafont(), "null", recursosService.getCursoTexto());
        this.pOptions.add(tConsult);

        //BOTÓN FILTRAR
        bFiltrar = objGraficosService.builtButton("Filtrar", 430, 65, 120,35, recursosService.getCursoMano(),
                recursosService.getLightFont(), recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bFiltrar.addFocusListener(egresoxMotivoComponent);
        bFiltrar.addActionListener(egresoxMotivoComponent);
        //pOptions.add(bFiltrar);

        //BOTON MOSTRAR

        bShow = objGraficosService.builtButton("Mostrar", 10,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
                ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bShow.addFocusListener(egresoxMotivoComponent);
        bShow.addActionListener(egresoxMotivoComponent);
        pOptions.add(bShow);

        //BOTON INSERTAR

        bInsert = objGraficosService.builtButton("Insertar", 160,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
                ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bInsert.addFocusListener(egresoxMotivoComponent);
        bInsert.addActionListener(egresoxMotivoComponent);
        pOptions.add(bInsert);

        // BOTON MODIFICAR

        bModify = objGraficosService.builtButton("Modificar", 300,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
                ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bModify.addFocusListener(egresoxMotivoComponent);
        bModify.addActionListener(egresoxMotivoComponent);
        pOptions.add(bModify);

        //BOTON ELIMINAR

        bDelete = objGraficosService.builtButton("Eliminar", 440,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
                ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bDelete.addFocusListener(egresoxMotivoComponent);
        bDelete.addActionListener(egresoxMotivoComponent);
        pOptions.add(bDelete);
    }

    public void builtpDatosEgresos (){

        lInstructions = objGraficosService.construirJLabel("<html>Tabla egresos por motivo <html>", 20,20,120,
                75,recursosService.getColorGrisOscuro(), Color.WHITE, recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lInstructions);

        lEslogan= objGraficosService.construirJLabel("<html>A continuación puede ver y editar sus registros <br>de egresos conforme al motivo<html>", 20,90,280,
                75,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "LEFT");
        this.pData.add(lEslogan);

        lId= objGraficosService.construirJLabel("# Registros", 20,160,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lId);

        lIdValue = objGraficosService.construirJLabel("0", 30,160,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "RIGHT");
        this.pData.add(lIdValue);

        lEgreso = objGraficosService.construirJLabel("Egreso", 20,200,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lEgreso);

        tEgreso = objGraficosService.construirJTextFiel(30, 250, 240, 30, "Ingreso", colorGray,
                recursosService.getLightFont(),"null", recursosService.getCursoTexto());
        this.pData.add(tEgreso);

        lMotivo = objGraficosService.construirJLabel("Motivo", 20,350,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lMotivo);

        tMotivo = objGraficosService.construirJTextFiel(30, 390, 240, 30, "Motivo", colorGray,
                recursosService.getLightFont(),"null", recursosService.getCursoTexto());
        this.pData.add(tMotivo );

    }

    public JButton getbInsert() {
        return bInsert;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModelEgresos() {
        return modelEgresos;
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

    public JTextField gettEgreso() {
        return tEgreso;
    }

    public JButton getbShow() {
        return bShow;
    }

    public JTextField gettMotivo() {
        return tMotivo;
    }

    public JLabel getlIdValue() {
        return lIdValue;
    }
}
