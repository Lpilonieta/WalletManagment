package ViewModel.Components.TitleBar;

import ViewModel.MainPanel.MainPanelComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleBarComponent {

    private TitleBarTemplate titleBarTemplate;
    private MainPanelComponent mainPanelComponent;



    public TitleBarComponent (MainPanelComponent mainPanelComponent) {

        this.titleBarTemplate = new TitleBarTemplate(this);
        this.mainPanelComponent = mainPanelComponent;

    }

    public TitleBarTemplate getTitleBarTemplate() {
        return titleBarTemplate;
    }


}
