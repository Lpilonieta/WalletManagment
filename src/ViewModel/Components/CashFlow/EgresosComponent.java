package ViewModel.Components.CashFlow;

import ViewModel.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EgresosComponent implements ActionListener {

    private EgresosTemplate egresosTemplate;

    private MainPanelComponent mainPanelComponent;
    public EgresosComponent (MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;
        this.egresosTemplate = new EgresosTemplate(this);
    }

    public EgresosTemplate getEgresosTemplate() {
        return egresosTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
