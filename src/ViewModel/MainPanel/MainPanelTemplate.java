package ViewModel.MainPanel;

import ViewModel.Components.UserBrowsing.UserBrowsingComponent;
import ViewModel.Services.ObjGraficosService;
import ViewModel.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class MainPanelTemplate extends JFrame {

    private ObjGraficosService sOjGraficosService;

    private MainPanelComponent mainPanelComponent;

    private RecursosService recursosService;

    private JPanel pBarraLateral, pShowData, pBarraSuperior;



    public MainPanelTemplate(MainPanelComponent mainPanelComponent){

        //Obtención de servicios

        this.mainPanelComponent = mainPanelComponent;
        this.mainPanelComponent.getClass();
        sOjGraficosService = ObjGraficosService.getService();
        recursosService = RecursosService.getService();


        this.builtPanel();

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1300,900);
        setLocationRelativeTo(this);
        setResizable(false);
        setVisible(true);
        setLayout(null);

    }


    public void builtPanel (){

     pBarraLateral = sOjGraficosService.contruirPanelGenerico(0,0, 250,900, null, null);
     this.add(pBarraLateral);

     pBarraSuperior = sOjGraficosService.contruirPanelGenerico(250,0,1300,50, null, null);
     this.add(pBarraSuperior);

     pShowData = sOjGraficosService.contruirPanelGenerico(250, 50, 1300, 850, null, null);
     this.add(pShowData);

    }

    public JPanel getpBarraLateral() {
        return pBarraLateral;
    }

    public JPanel getpShowData() {
        return pShowData;
    }

    public JPanel getpBarraSuperior() {
        return pBarraSuperior;
    }
}
