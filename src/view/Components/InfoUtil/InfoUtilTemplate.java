package view.Components.InfoUtil;

import view.Services.ObjGraficosService;
import view.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class InfoUtilTemplate extends JLabel {

    private InfoUtilComponent actionComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    //Obj. Graficos

    private JLabel lTitle, lIcon, lText;

    public InfoUtilTemplate(InfoUtilComponent infoUtilComponent, String title, String text, ImageIcon image) {

        this.actionComponent = infoUtilComponent;
        this.recursosService = RecursosService.getService();
        this.objGraficosService = ObjGraficosService.getService();

        this.lIcon= objGraficosService.construirJLabel(null, (250-60)/2 + 6, 5, 45, 45,
                null, null, null, null, image, null, "CENTER");
        this.add(lIcon);

        this.lTitle= objGraficosService.construirJLabel(title, (250-220)/2, 50, 220, 30,
                null, null, recursosService.getMainFont(), null, null, null, "CENTER");
        this.add(lTitle);
        this.lText= objGraficosService.construirJLabel(text, (250-230)/2, 70, 230, 50,
                null, null, recursosService.getLightFont(), null, null, null, "CENTER");
        this.add(lText);


        this.setSize(250,125);
        this.setBackground(Color.WHITE);
        this.setBorder(recursosService.getGrayBorder());
        this.setLayout(null);
        this.setVisible(true);

    }



}
