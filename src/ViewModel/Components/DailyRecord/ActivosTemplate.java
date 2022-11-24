package ViewModel.Components.DailyRecord;

import javax.swing.*;
import java.awt.*;

public class ActivosTemplate extends JPanel {

    private ActivosComponent activosComponent;

    public ActivosTemplate(ActivosComponent activosComponent) {

        this.activosComponent = activosComponent;
        this.setSize(1300, 850);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setVisible(true);

    }
}
