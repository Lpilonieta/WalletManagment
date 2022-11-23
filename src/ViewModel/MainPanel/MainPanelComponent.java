package ViewModel.Components;

import ViewModel.MainPanel.MainPanelTemplate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanelComponent implements ActionListener {

    private MainPanelComponent mainPanelComponent;

    private MainPanelTemplate mainPanelTemplate;

    public MainPanelComponent (MainPanelComponent mainPanelComponent){

        this.mainPanelComponent = mainPanelComponent;

    }

    public MainPanelComponent (){

        this.mainPanelTemplate = new MainPanelTemplate(this);

    }

    public MainPanelTemplate getMainPanelTemplate() {
        return mainPanelTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
