package ViewModel;

import ViewModel.Services.ObjGraficosService;
import ViewModel.Services.RecursosService;

import java.awt.*;

public class MainPanelTemplate {

    private ObjGraficosService sOjGraficosService;

    private RecursosService recursosService;

    private Color colorSecundario;

    public MainPanelTemplate(){

        //Obtención de servicios

       sOjGraficosService = ObjGraficosService.getService();

       recursosService = RecursosService.getService();

    }

}
