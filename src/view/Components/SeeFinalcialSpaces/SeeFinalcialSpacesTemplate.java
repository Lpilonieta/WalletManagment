package view.Components.SeeFinalcialSpaces;

import javax.swing.*;
import java.awt.*;

public class SeeFinalcialSpacesTemplate extends JPanel {

    private SeeFinalcialSpacesComponent seeFinalcialSpacesComponent;

    public SeeFinalcialSpacesTemplate (SeeFinalcialSpacesComponent seeFinalcialSpacesComponent){

        this.seeFinalcialSpacesComponent = seeFinalcialSpacesComponent;


        this.setSize(1300, 850);
        this.setBackground(Color.BLUE);
        this.setLayout(null);
        this.setVisible(true);
    }


}
