package View.Components.Stats;

import View.Main;
import View.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsComponent implements ActionListener {

    private StatsTemplate statsTemplate;
    private MainPanelComponent mainPanelComponent;

    public StatsComponent (MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.statsTemplate = new StatsTemplate(this);


    }

    public StatsTemplate getStatsTemplate() {
        return statsTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
