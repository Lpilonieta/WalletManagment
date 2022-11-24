//import UIdescarted.HomePanel;
import View.MainApp.LateralBar;
import View.MainApp.MainFrame;
import View.MainApp.MainPanels.*;
import ViewModel.Stats;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame(new HomePanel(),new CashflowPanel(),new AssetsPanel(),new PasivesPanel(),new StatsPanel(),new InventoryPanel(),new LateralBar());
    }
}
