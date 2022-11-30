package View.Components.CashFlow;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class RegistryNewAssetTemplate extends JPanel {

    //Servicios

    private ObjGraficosService sOjGraficosService;
    private RecursosService recursosService;
    private RegistryNewAssetComponent registryNewAssetComponent;

    //Obj. Garficos

    private JLabel name_asset, description_asset, type_asset, percetRentability, title;
    private JTextField textFieldName, textFieldDescription, textFieldRentability;
    private JComboBox comboBoxType;
    private JButton saveData;

    public RegistryNewAssetTemplate (RegistryNewAssetComponent registryNewAssetComponent){

        this.registryNewAssetComponent = registryNewAssetComponent;
        this.sOjGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtJTextField();
        this.builtLabels();
        this.builtJComboBox();
        this.builtButton();

        this.setSize(1300, 550);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);

    }
    public void builtLabels (){

        this.title= sOjGraficosService.construirJLabel("Registrar un activo" , (1300 - 260)/2 - 200,
                50, 260,40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "null"
        );
        this.add(title);

        this.name_asset= sOjGraficosService.construirJLabel("Nombre" , (1300 - 260)/2 - 200,
                150, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(name_asset);

        this.description_asset = sOjGraficosService.construirJLabel("Descripción" , (1300 - 260)/2 - 200,
                200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(description_asset);

        this.percetRentability= sOjGraficosService.construirJLabel("% Rentabilidad", (1300 - 260)/2 - 200,
                300, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(percetRentability);

        this.type_asset= sOjGraficosService.construirJLabel("Tipo", (1300 - 260)/2 - 200,
                250, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(type_asset);

    }

    public void builtJTextField (){

        this.textFieldName= sOjGraficosService.construirJTextFiel((1300 - 260)/2, 150, 400, 40,
                "", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldName);

        this.textFieldDescription= sOjGraficosService.construirJTextFiel((1300 - 260)/2, 200, 400, 40,
                "", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldDescription);

        this.textFieldRentability= sOjGraficosService.construirJTextFiel((1300 - 260)/2, 300, 100, 40,
                "", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldRentability);

    }

    public void builtJComboBox (){

        this.comboBoxType= new JComboBox<>();
        this.comboBoxType.addItem("Corriente");
        this.comboBoxType.addItem("No corriente");
        this.comboBoxType.setSize(200,40);
        this.comboBoxType.setLocation((1300 - 260)/2, 250);
        this.comboBoxType.setForeground(Color.DARK_GRAY);
        this.comboBoxType.setBackground(Color.WHITE);
        this.comboBoxType.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxType.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxType);
    }

    public void builtButton (){

        saveData = sOjGraficosService.builtButton("Guardar datos", (1300 - 260)/2 - 200, 400, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), recursosService.getMainColor(),
                Color.WHITE, null, null, true, "null");
        this.saveData.addActionListener(registryNewAssetComponent);
        this.add(saveData);

    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldDescription() {
        return textFieldDescription;
    }

    public JTextField getTextFieldRentability() {
        return textFieldRentability;
    }

    public JComboBox getComboBoxType() {
        return comboBoxType;
    }
}
