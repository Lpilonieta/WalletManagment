package view.Components.SalesRegistry;

import view.Services.ObjGraficosService;
import view.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class SalesRegistryTemplate extends JPanel {

    //Servicios

    private ObjGraficosService sOjGraficosService;
    private RecursosService recursosService;

    private SalesRegistryComponent registrySalesComponent;

    //Obj. Graficos

    private JLabel lSelectItem, numVentas, title;
    private JComboBox comboBoxlSelectItem;
    private JTextField textFieldNumVentas;

    private JButton saveData;

    public SalesRegistryTemplate (SalesRegistryComponent registrySalesComponent){

        this.registrySalesComponent = registrySalesComponent;
        this.sOjGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtJTextField();
        this.builtLabels();
        this.builtJComboBox();
        this.builtButton();

        this.setSize(1300, 850);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);

    }

    public void builtLabels (){

        this.title= sOjGraficosService.construirJLabel("Registrar ventas" , (1300 - 260)/2 - 200,
                50, 260,40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "null"
        );
        this.add(title);

        this.lSelectItem = sOjGraficosService.construirJLabel("Seleccionar item" , (1300 - 260)/2 - 200,
                200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lSelectItem);

        this.numVentas= sOjGraficosService.construirJLabel("Numero de ventas", (1300 - 260)/2 - 200,
                250, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(numVentas);


    }

    public void builtJTextField (){

        this.textFieldNumVentas = sOjGraficosService.construirJTextFiel((1300 - 260)/2, 250, 100, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldNumVentas);

    }

    public void builtJComboBox (){

        this.comboBoxlSelectItem = new JComboBox<>();
        this.comboBoxlSelectItem.addItem("5");
        this.comboBoxlSelectItem.addItem("6");
        this.comboBoxlSelectItem.addItem("7");
        this.comboBoxlSelectItem.addItem("8");
        this.comboBoxlSelectItem.setSize(200,40);
        this.comboBoxlSelectItem.setLocation((1300 - 260)/2, 200);
        this.comboBoxlSelectItem.setForeground(Color.DARK_GRAY);
        this.comboBoxlSelectItem.setBackground(Color.WHITE);
        this.comboBoxlSelectItem.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxlSelectItem.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxlSelectItem);
    }

    public void builtButton (){

        saveData = sOjGraficosService.builtButton("Guardar datos", (1300 - 260)/2 - 200, 380, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), recursosService.getMainColor(),
                Color.WHITE, null, null, true, "null");
        this.saveData.addActionListener(registrySalesComponent);
        this.add(saveData);

    }

    public JComboBox getComboBoxlSelectItem() {
        return comboBoxlSelectItem;
    }

    public JTextField getTextFieldNumVentas() {
        return textFieldNumVentas;
    }
}
