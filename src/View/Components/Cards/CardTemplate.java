package View.Components.Cards;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class CardTemplate extends JPanel {

    // Obj. Graficos y servicios

    private ObjGraficosService objGraficosService;

    private RecursosService recursosService;

    private CardComponent cardComponent;


    // Obj. Graficos

    private JLabel lTitle, lImage, lText;
    private JButton ir;


    public CardTemplate(CardComponent cardComponent, String title, ImageIcon image, String text) {

        this.cardComponent = cardComponent;
        this.recursosService = RecursosService.getService();
        this.objGraficosService = ObjGraficosService.getService();

        this.lImage = objGraficosService.construirJLabel(null, 70, 5, 64,64,
                null, null, null, null, image, null, "null");
        this.add(lImage);

        this.lTitle = objGraficosService.construirJLabel(title, 15,72,180,50, recursosService.getMainColor(), Color.WHITE,
                recursosService.getMainFont(), null, null, null, "CENTER");
        this.add(lTitle);

        this.lText = ObjGraficosService.getService().construirJLabel(text, 5,76,206,120, Color.DARK_GRAY, Color.WHITE, recursosService.getLightFont(), null, null, null, "CENTER");
        this.add(lText);

        this.setSize(200, 180);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);

    }



}
