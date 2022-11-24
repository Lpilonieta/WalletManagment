package View.MainApp;

//import UIdescarted.HomePanel;
import View.MainApp.MainPanels.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HomePanel homePanel;
    private CashflowPanel cashflowPanel;
    private AssetsPanel assetsPanel;
    private PasivesPanel pasivesPanel;
    private StatsPanel statsPanel;
    private InventoryPanel inventoryPanel;
    private LateralBar lateralBar;

    private JPanel principal=new JPanel();
    private JPanel root=new JPanel(new BorderLayout());
    private CardLayout cardLayout = new CardLayout();

    public MainFrame(HomePanel homePanel, CashflowPanel cashflowPanel, AssetsPanel assetsPanel, PasivesPanel pasivesPanel, StatsPanel statsPanel, InventoryPanel inventoryPanel, LateralBar lateralBar) throws HeadlessException {
        this.homePanel = homePanel;
        this.cashflowPanel = cashflowPanel;
        this.assetsPanel = assetsPanel;
        this.pasivesPanel = pasivesPanel;
        this.statsPanel = statsPanel;
        this.inventoryPanel = inventoryPanel;
        this.lateralBar = lateralBar;

        setLocationRelativeTo(null);
        setSize(700,700);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        principal.setLayout(cardLayout);
        principal.add(homePanel.$$$getRootComponent$$$(),"1");
        principal.add(cashflowPanel.$$$getRootComponent$$$(),"2");
        principal.add(assetsPanel.$$$getRootComponent$$$(),"3");
        principal.add(pasivesPanel.$$$getRootComponent$$$(),"4");
        principal.add(statsPanel.$$$getRootComponent$$$(),"5");
        principal.add(inventoryPanel.$$$getRootComponent$$$(),"6");
        root.add(lateralBar.$$$getRootComponent$$$(),BorderLayout.WEST);
        root.add(principal,BorderLayout.CENTER);
        cardLayout.show(principal,"1");

        add(root);

        setVisible(true);

    }

}
