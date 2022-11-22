package ViewModel.MainPanel;

public class MainPanelComponent {

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
}
