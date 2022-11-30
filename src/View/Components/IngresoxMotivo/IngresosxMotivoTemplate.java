package View.Components.IngresoxMotivo;

import View.Components.ModelAux.IngresoxMotivo;
import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class IngresosxMotivoTemplate extends JPanel {

    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    private IngresoxMotivoComponent ingresoxMotivoComponent;

    //Obj. Graficos

    private JPanel pOptions, pData;

    //Obj. Graficos
    private JLabel lTitle, lInstructions, lEslogan, lId, lIdValue, lMotivo, lIngreso;
    private JButton bShow, bFiltrar;
    private JTextField tConsult, tIngreso, tMotivo;
    private JScrollPane pTable;
    private JTable table;
    private JTableHeader header;
    private DefaultTableModel model;
    private String [] cabecera={"Ingreso", "Motivo"};


    //Obj. Decorador

    private Color colorGray;

    public IngresosxMotivoTemplate (IngresoxMotivoComponent ingresoxMotivoComponent){

        this.ingresoxMotivoComponent = ingresoxMotivoComponent;
     this.objGraficosService = ObjGraficosService.getService();
     this.recursosService = RecursosService.getService();

     this.builtPaneles();
     this.builtPOptions();
     this.builtpDatos();
     this.crearJTable();

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
        table.addMouseListener(ingresoxMotivoComponent);

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
        bFiltrar.addFocusListener(ingresoxMotivoComponent);
        bFiltrar.addActionListener(ingresoxMotivoComponent);
       pOptions.add(bFiltrar);

        //BOTON MOSTRAR

        bShow = objGraficosService.builtButton("Mostrar", 10,145,120,35,recursosService.getCursoMano(), recursosService.getLightFont()
        ,recursosService.getMainColor(), Color.WHITE, null, null, true, "null");
        bShow.addFocusListener(ingresoxMotivoComponent);
        bShow.addActionListener(ingresoxMotivoComponent);
        pOptions.add(bShow);


    }

    public void builtpDatos (){

        lInstructions = objGraficosService.construirJLabel("<html>Tabla ingresos por motivo <html>", 20,20,120,
                75,recursosService.getColorGrisOscuro(), Color.WHITE, recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lInstructions);

        lEslogan= objGraficosService.construirJLabel("<html>A continuación puede ver y editar sus registros <br>de ingresos conforme al motivo<html>", 20,90,280,
                75,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "LEFT");
        this.pData.add(lEslogan);

        lId= objGraficosService.construirJLabel("# Registros", 20,160,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lId);

        lIdValue = objGraficosService.construirJLabel("0", 30,160,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getLightFont(), null, null, null, "RIGHT");
        this.pData.add(lIdValue);

        lIngreso = objGraficosService.construirJLabel("Ingreso", 20,200,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lIngreso);

        tIngreso = objGraficosService.construirJTextFiel(30, 250, 240, 30, "Ingreso", colorGray,
                recursosService.getLightFont(),"null", recursosService.getCursoTexto());
        this.pData.add(tIngreso);

        lMotivo = objGraficosService.construirJLabel("Motivo", 20,350,160,
                30,recursosService.getColorGrisOscuro(), Color.WHITE,recursosService.getMainFont(), null, null, null, "LEFT");
        this.pData.add(lMotivo);

        tMotivo = objGraficosService.construirJTextFiel(30, 390, 240, 30, "Motivo", colorGray,
                recursosService.getLightFont(),"null", recursosService.getCursoTexto());
        this.pData.add(tMotivo );

    }

    public JLabel getlIdValue() {
        return lIdValue;
    }

    public JButton getbShow() {
        return bShow;
    }

    public JButton getbFiltrar() {
        return bFiltrar;
    }

    public JTextField gettConsult() {
        return tConsult;
    }

    public JTextField gettIngreso() {
        return tIngreso;
    }

    public JTextField gettMotivo() {
        return tMotivo;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
