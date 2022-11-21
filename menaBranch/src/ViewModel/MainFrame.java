package ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame {
    private JFrame frame = new JFrame("frame");
    private JPanel MainPane;
    private JPanel barraLateral;
    private JPanel centralPane;
    private JButton newRegistryButton;
    private JLabel HomeLabel;
    private JLabel SolvencyLabel;
    private JLabel LiquidityLabel;
    private JLabel AssetsLabel;
    private JLabel PasivesLabel;
    private JLabel InventoryLabel;
    private JLabel RentabilityLabel;
    private RegistryFormPanel registryFormPanel = new RegistryFormPanel();
    private HomePanel homePanel = new HomePanel();
    private SolvencyPanel solvencyPanel = new SolvencyPanel();
    private LiquidityPanel liquidityPanel = new LiquidityPanel();
    private AssetsPanel assetsPanel = new AssetsPanel();
    private PasivesPanel pasivesPanel = new PasivesPanel();
    private InventoryPanel inventoryPanel = new InventoryPanel();
    private RentabilityPanel rentabilityPanel = new RentabilityPanel();
    private static boolean goToHome = false;

    public static boolean isGoToHome() {
        return goToHome;
    }

    public static void setGoToHome(boolean goToHome) {
        MainFrame.goToHome = goToHome;
    }

    public MainFrame() {
        {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
            $$$setupUI$$$();
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add($$$getRootComponent$$$());
        frame.setVisible(true);
        newRegistryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == newRegistryButton) {
                    centralPane.add(registryFormPanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);

                }
            }
        });
        centralPane.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                if (e.getChild() == homePanel.$$$getRootComponent$$$()) ;
                newRegistryButton.setVisible(true);
            }
        });
        HomeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == HomeLabel) {
                    centralPane.add(homePanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);
                    centralPane.add(newRegistryButton);
                    newRegistryButton.setVisible(true);

                }
            }
        });
        SolvencyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == SolvencyLabel) {
                    centralPane.add(solvencyPanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);
                    centralPane.add(newRegistryButton);
                    newRegistryButton.setVisible(true);

                }
            }
        });
        LiquidityLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == LiquidityLabel) {
                    centralPane.add(liquidityPanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);
                    centralPane.add(newRegistryButton);
                    newRegistryButton.setVisible(true);

                }
            }
        });
        AssetsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == AssetsLabel) {
                    centralPane.add(assetsPanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);
                    centralPane.add(newRegistryButton);
                    newRegistryButton.setVisible(true);

                }
            }
        });
        PasivesLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == PasivesLabel) {
                    centralPane.add(pasivesPanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);
                    centralPane.add(newRegistryButton);
                    newRegistryButton.setVisible(true);

                }
            }
        });
        InventoryLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == InventoryLabel) {
                    centralPane.add(inventoryPanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);
                    centralPane.add(newRegistryButton);
                    newRegistryButton.setVisible(true);

                }
            }
        });
        RentabilityLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                centralPane.setVisible(false);
                centralPane.removeAll();
                if (e.getSource() == RentabilityLabel) {
                    centralPane.add(rentabilityPanel.$$$getRootComponent$$$());
                    centralPane.setVisible(true);
                    centralPane.add(newRegistryButton);
                    newRegistryButton.setVisible(true);

                }
            }
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MainPane = new JPanel();
        MainPane.setLayout(new BorderLayout(0, 0));
        barraLateral = new JPanel();
        barraLateral.setLayout(new GridBagLayout());
        barraLateral.setMinimumSize(new Dimension(100, 100));
        barraLateral.setPreferredSize(new Dimension(250, 100));
        barraLateral.setVisible(true);
        MainPane.add(barraLateral, BorderLayout.WEST);
        HomeLabel = new JLabel();
        HomeLabel.setText("Home");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(HomeLabel, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer1, gbc);
        SolvencyLabel = new JLabel();
        SolvencyLabel.setText("Solvency");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(SolvencyLabel, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer2, gbc);
        LiquidityLabel = new JLabel();
        LiquidityLabel.setText("Liquidity");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(LiquidityLabel, gbc);
        AssetsLabel = new JLabel();
        AssetsLabel.setText("Assets");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(AssetsLabel, gbc);
        PasivesLabel = new JLabel();
        PasivesLabel.setText("Pasives");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(PasivesLabel, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer5, gbc);
        InventoryLabel = new JLabel();
        InventoryLabel.setText("Inventory");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(InventoryLabel, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer6, gbc);
        RentabilityLabel = new JLabel();
        RentabilityLabel.setText("Rentability");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(RentabilityLabel, gbc);
        final JSeparator separator1 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.BOTH;
        barraLateral.add(separator1, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Espacios Financieros");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label1, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 17;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer8, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Área personal");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 18;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label2, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 19;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer9, gbc);
        final JSeparator separator2 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 20;
        gbc.fill = GridBagConstraints.BOTH;
        barraLateral.add(separator2, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 21;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer10, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Grupo de chazas");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 22;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label3, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 23;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer11, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Chaza obleas");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 24;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label4, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer12, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 25;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer13, gbc);
        centralPane = new JPanel();
        centralPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        MainPane.add(centralPane, BorderLayout.CENTER);
        newRegistryButton = new JButton();
        newRegistryButton.setText("Nuevo Registro");
        centralPane.add(newRegistryButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainPane;
    }

}
