package View.IngresoxMotivo;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class IngresosxMotivoTemplate extends JPanel {

    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    private IngresoxMotivoComponent ingresoxMotivoComponent;
    //Obj. Graficos

    private JPanel pOptions, pData;


    //Obj. Decorador

    private Color colorGray;

    public IngresosxMotivoTemplate (IngresoxMotivoComponent ingresoxMotivoComponent){

        this.ingresoxMotivoComponent = ingresoxMotivoComponent;
     this.objGraficosService = ObjGraficosService.getService();
     this.recursosService = RecursosService.getService();

     this.builtPaneles();

     this.setBackground(recursosService.getColorGris());
     this.colorGray = new Color (235, 235, 235);
     this.setSize(1300, 850);
     this.setLayout(null);
     this.setVisible(true);

    }


    public void builtPaneles (){

        pOptions = objGraficosService.contruirPanelGenerico(10,10,58,200,Color.BLUE, null);
        this.add(pOptions);
        pData = objGraficosService.contruirPanelGenerico(600,10,240,580,Color.GREEN, null);
        this.add(pData);


    }
}
