package View.Components.FinancialSpaces;

import javax.swing.*;
import java.awt.*;

public class FinalcialSpacesTemplate extends JPanel {

    private FinalcialSpacesComponent finalcialSpacesComponent;
    public FinalcialSpacesTemplate(FinalcialSpacesComponent finalcialSpacesComponent) {

        this.finalcialSpacesComponent = finalcialSpacesComponent;


        this.setSize(1300, 850);
        this.setBackground(Color.GREEN);
        this.setLayout(null);
        this.setVisible(true);
    }

}
