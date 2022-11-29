package view.Components.PersonalArea;

import javax.swing.*;
import java.awt.*;

public class PersonalAreaTemplate extends JPanel {

    private PersonalAreaComponent personalAreaComponent;

    public PersonalAreaTemplate (PersonalAreaComponent personalAreaComponent){

        this.personalAreaComponent = personalAreaComponent;

        this.setSize(1300, 850);
        this.setBackground(Color.RED);
        this.setLayout(null);
        this.setVisible(true);

    }


}
