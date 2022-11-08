package ViewModel;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JPanel MainPane;
    private JPanel barraLateral;
    private JPanel centralPane;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
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
        final JLabel label1 = new JLabel();
        label1.setText("Home");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Solvency");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label2, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Liquidity");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Assets");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Pasives");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label5, gbc);
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
        final JLabel label6 = new JLabel();
        label6.setText("Inventory");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label6, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer6, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("Rentability");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label7, gbc);
        final JSeparator separator1 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.fill = GridBagConstraints.BOTH;
        barraLateral.add(separator1, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("Espacios Financieros");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label8, gbc);
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
        final JLabel label9 = new JLabel();
        label9.setText("Área personal");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 18;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label9, gbc);
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
        final JLabel label10 = new JLabel();
        label10.setText("Grupo de chazas");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 22;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label10, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 23;
        gbc.fill = GridBagConstraints.VERTICAL;
        barraLateral.add(spacer11, gbc);
        final JLabel label11 = new JLabel();
        label11.setText("Chaza obleas");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 24;
        gbc.anchor = GridBagConstraints.WEST;
        barraLateral.add(label11, gbc);
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
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainPane;
    }
}
