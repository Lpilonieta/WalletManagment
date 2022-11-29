package view.Components.TitleBar;

import view.MainPanel.MainPanelComponent;

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
