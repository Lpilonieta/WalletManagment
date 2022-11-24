package ViewModel.Components.DailyRecord;

import javax.swing.*;
import java.awt.*;

public class EgresosTemplate extends JPanel {

    private EgresosComponent egresosComponent;
    public EgresosTemplate(EgresosComponent egresosComponent) {

        this.egresosComponent = egresosComponent;

        this.setSize(1300, 850);
        this.setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setVisible(true);

    }


}
