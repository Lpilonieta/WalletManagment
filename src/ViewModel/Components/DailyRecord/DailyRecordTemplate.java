package ViewModel.Components.DailyRecord;

import javax.swing.*;
import java.awt.*;

public class DailyRecordTemplate extends JPanel {

    private DailyRecordComponent dailyRecordComponent;

    public DailyRecordTemplate(DailyRecordComponent dailyRecordComponent) {

        this.dailyRecordComponent = dailyRecordComponent;


        this.setSize(1300, 850);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setVisible(true);
    }
}
