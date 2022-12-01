package View.Components.Stats;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;

public class StatsTemplate extends JPanel {

    private StatsComponent statsComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    public StatsTemplate (StatsComponent statsComponent){

        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();
        this.statsComponent = statsComponent;

    }




}
