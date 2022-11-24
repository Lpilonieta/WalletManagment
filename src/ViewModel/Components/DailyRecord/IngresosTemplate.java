package ViewModel.Components.DailyRecord;

import javax.swing.*;
import java.awt.*;

public class IngresosTemplate extends JPanel {


    private IngresosComponent ingresosComponent;
    public IngresosTemplate(IngresosComponent ingresosComponent) {

        this.ingresosComponent = ingresosComponent;

        this.setSize(1300, 850);
        this.setBackground(Color.magenta);
        this.setLayout(null);
        this.setVisible(true);

    }
}
