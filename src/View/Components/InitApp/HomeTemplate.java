package View.Components.InitApp;

import View.Components.InfoUtil.InfoUtilComponent;
import View.Components.InfoUtil.InfoUtilTemplate;
import View.Components.Cards.CardComponent;
import View.Services.ObjGraficosService;
import View.Services.RecursosService;
import ViewModel.User;

import javax.swing.*;
import java.awt.*;

public class HomeTemplate extends JPanel {

    private HomeComponent homeComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

// Obj. Graficos

    private JPanel pFlujoDeCaja, pIngresos, pEgresos, pEstadisticas, pOtros;
    private JLabel infoUtil;
    private JButton bFlujoDeCaja, bEstadisticas, bEgresos, bIngresos, bTablaIngresosxMotivos, bTablaEgresosxMotivo, bInventario, bRegistroVentas;
    private ImageIcon iIngresos, iEgresos, iEstadisticas, iConsejosFinancieros,iInventarios, iTabla, iClashFlow, iRegistroVentas;

    private User user = new User();

    public HomeTemplate(HomeComponent homeComponent, String ingresosTotales, String egresosTotales) {

        this.homeComponent = homeComponent;
        this.homeComponent.getClass();
        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtPanel();
        this.builtDecorativesObject();
        this.builtpIngresosComponents(ingresosTotales);
        this.builtpEgresosComponents(egresosTotales);
        this.builtFlujoDeCajaComponents();
        this.builtpEstadisticasComponents();
        this.builtButtons();
        this.builtActions();

        this.setSize(1300, 850);
        this.setBackground(recursosService.getColorGrisClaro());
        this.setLayout(null);
        this.setVisible(true);

    }

    public void builtPanel (){

        this.pFlujoDeCaja = objGraficosService.contruirPanelGenerico(40,50,200,240, recursosService.getMainColor(), recursosService.getGrayBorder());
        this.add(pFlujoDeCaja);

        this.pIngresos = objGraficosService.contruirPanelGenerico(290,50,200,240, recursosService.getMainColor(), recursosService.getGrayBorder());
        this.add(pIngresos);

        this.pEgresos = objGraficosService.contruirPanelGenerico(540,50,200,240, recursosService.getMainColor(), recursosService.getGrayBorder());
        this.add(pEgresos);

        this.pEstadisticas = objGraficosService.contruirPanelGenerico(790,50,200,240, recursosService.getMainColor(), recursosService.getGrayBorder());
        this.add(pEstadisticas);

        this.pOtros  = objGraficosService.contruirPanelGenerico(20,350,1000,400,Color.WHITE, null);
        this.add(pOtros);

    }

    public void builtButtons (){
        this.bFlujoDeCaja = objGraficosService.builtButton("Ver flujo de caja", 5, 180, 190, 50,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE, null, null, false, "CENTER");
        this.bFlujoDeCaja.addActionListener(homeComponent);
        this.pFlujoDeCaja.add(bFlujoDeCaja);

        this.bIngresos = objGraficosService.builtButton("Registrar", 5, 180, 190, 50,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE, null, null, false, "CENTER");
        this.bIngresos.addActionListener(homeComponent);
        this.pIngresos.add(bIngresos);

        this.bEgresos = objGraficosService.builtButton("Registrar", 5, 180, 190, 50,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE, null, null, false, "CENTER");
        this.bEgresos.addActionListener(homeComponent);
        this.pEgresos.add(bEgresos);

        this.bEstadisticas = objGraficosService.builtButton("Ver estadisticas", 5, 180, 190, 50,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE, null, null, false, "CENTER");
        this.bEstadisticas.addActionListener(homeComponent);
        this.pEstadisticas.add(bEstadisticas);
    }


    public void builtDecorativesObject (){

        this.iIngresos = new ImageIcon("Graphics/MainPanel/iIngresos.png");
        this.iEstadisticas = new ImageIcon("Graphics/MainPanel/iEstadisticas.png");
        this.iConsejosFinancieros = new ImageIcon("Graphics/MainPanel/iConsejosFinancieros.png");
        this.iEgresos = new ImageIcon("Graphics/MainPanel/iEgresos.png");
        this.iInventarios = new ImageIcon("Graphics/MainPanel/inventario.png");
        this.iClashFlow = new ImageIcon("Graphics/MainPanel/cash-flow.png");
        this.iTabla = new ImageIcon("Graphics/MainPanel/Table.png");
        this.iRegistroVentas = new ImageIcon("Graphics/MainPanel/registar_Ventas.png");
    }

    public void builtpEstadisticasComponents (){

        this.pEstadisticas.add(new CardComponent(
                "<html><body> Estadisticas <br> Financieras </body></html> ",
                iEstadisticas, "<html><body> Mira aqui tus estadisticas<br>  financieras</body></html> ", "Ver").getCardTemplate());
    }
    public void builtpIngresosComponents (String ingresosTotales){

        this.pIngresos.add(new CardComponent("Ingresos", iIngresos, "<html><body> Tus ingresos totales: <br>" + user.getTotalRevenue() + "</body></html>", "Registrar").getCardTemplate());

    }

    public void builtpEgresosComponents (String egresosTotales){

        this.pEgresos.add(new CardComponent("Egresos", iEgresos, "<html><body> Tus ingresos totales: <br>" + user.getTotalRevenue() + "</body></html>", "Registrar").getCardTemplate());

    }
    public void builtFlujoDeCajaComponents(){

        this.pFlujoDeCaja.add(new CardComponent(
                "Flujo de caja",
                iClashFlow, "Mira aqui tu flujo de caja", "Ver").getCardTemplate());

    }

    public void builtActions (){

        this.infoUtil = objGraficosService.construirJLabel(
                "Otros servicios", 10, 19, 160, 30, recursosService.getMainColor(), null,
                recursosService.getMainFont(), null, null, null, "null");
        this.pOtros.add(infoUtil);

        //Botones invisibles

        this.bTablaIngresosxMotivos = objGraficosService.builtButton(null, 15, 60, 250,125,
                recursosService.getCursoMano(), null, null, null, null, null, false, "null");
        this.bTablaIngresosxMotivos.addActionListener(homeComponent);
        this.pOtros.add(bTablaIngresosxMotivos);

        this.bTablaEgresosxMotivo = objGraficosService.builtButton(null, 350, 60, 250,125,
                recursosService.getCursoMano(), null, null, null, null, null, false, "null");
        this.bTablaEgresosxMotivo.addActionListener(homeComponent);
        this.pOtros.add(bTablaEgresosxMotivo);

        this.bInventario = objGraficosService.builtButton(null, 685, 60, 250,125,
                recursosService.getCursoMano(), null, null, null, null, null, false, "null");
        this.bInventario .addActionListener(homeComponent);
        this.pOtros.add(bInventario);

        this.bRegistroVentas= objGraficosService.builtButton(null, 15, 250, 250,125,
                recursosService.getCursoMano(), null, null, null, null, null, false, "null");
        this.bRegistroVentas .addActionListener(homeComponent);
        this.pOtros.add(bRegistroVentas);

        // Label con info Util

        InfoUtilTemplate p1 = new InfoUtilComponent("Ingresos x Motivo", "Mira aqui la tabla de ingresos y motivos", iTabla).getInfoUtilTemplate();
        p1.setLocation(15,60);
        this.pOtros.add(p1);

        InfoUtilTemplate p2 = new InfoUtilComponent("Egresos x Motivo", "Mira aqui la tabla de egresos y motivos", iTabla).getInfoUtilTemplate();
        p2.setLocation(350,60);
        this.pOtros.add(p2);

        InfoUtilTemplate p3 = new InfoUtilComponent("Inventario", "Registra aqui tu inventario", iInventarios).getInfoUtilTemplate();
        p3.setLocation(685, 60);
        this.pOtros.add(p3);

        InfoUtilTemplate p4 = new InfoUtilComponent("Registro de ventas", "Registra aqui nuevas ventas", iRegistroVentas).getInfoUtilTemplate();
        p4.setLocation(15,250);
        this.pOtros.add(p4);
    }

    public JButton getbFlujoDeCaja() {
        return bFlujoDeCaja;
    }

    public JButton getbEstadisticas() {
        return bEstadisticas;
    }
    public JButton getbEgresos() {
        return bEgresos;
    }
    public JButton getbIngresos() {
        return bIngresos;
    }
    public JButton getbRegistroVentas() {
        return bRegistroVentas;
    }
    public JButton getbTablaIngresosxMotivos() {
        return bTablaIngresosxMotivos;
    }
    public JButton getbTablaEgresosxMotivo() {
        return bTablaEgresosxMotivo;
    }
    public JButton getbInventario() {
        return bInventario;
    }

}
