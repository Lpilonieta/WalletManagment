package View.Components.NewItemInventory;


import View.Services.ObjGraficosService;
import View.Services.RecursosService;
import View.Components.Groups.GroupsComponent;
import ViewModel.Constants;


import javax.swing.*;
import java.awt.*;

public class NewItemInventoryTemplate extends JPanel {

    //Servicios

    private ObjGraficosService sOjGraficosService;
    private RecursosService recursosService;


    //Obj. Graficos

    private JLabel title, name, description, category, lValorStock, lValorxUnidad, type, lNegocio, lValor, lMotivo, lFuente;
    private JComboBox comboBoxCategory, comboBoxType, comboBoxNegocio, comboBoxFuente, comboBoxMotivo;

    private JTextField textFieldName, textFieldDescription, textFielValorStock, textFielValorxUnidad, textFieldValor;
    private JButton saveData;

    private NewItemInventoryComponent newItemInventoryComponent;

    public NewItemInventoryTemplate(NewItemInventoryComponent newItemInventoryComponent) {

        this.newItemInventoryComponent = newItemInventoryComponent;
        this.sOjGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtJComboBox();
        this.builtJTextField();
        this.builtLabels();
        this.builtButton();

        this.setSize(1300, 850);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void builtLabels (){

        this.lValor = sOjGraficosService.construirJLabel("Valor" , (1300 - 260)/2 - 200,
                100, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lValor);

        this.lMotivo = sOjGraficosService.construirJLabel("Motivo", (1300 - 260)/2 - 200,
                200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.add(lMotivo);

        this.lFuente = sOjGraficosService.construirJLabel("Fuente", (1300 - 260)/2 - 200,
                150, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.add(lFuente);

        this.title = sOjGraficosService.construirJLabel("Registro de inventario" , (1300 - 260)/2 - 200,
                50, 260,40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "null"
        );
        this.add(title);

        this.name = sOjGraficosService.construirJLabel("Nombre" , (1300 - 260)/2 - 200,
                250, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(name);

        this.description = sOjGraficosService.construirJLabel("Descripción", (1300 - 260)/2 - 200,
                300, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(description);

        this.type = sOjGraficosService.construirJLabel("Tipo", (1300 - 260)/2 - 200,
                400, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.add(type);

        this.category = sOjGraficosService.construirJLabel("Categoria", (1300 - 260)/2 - 200,
                350, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.add(category);

        this.lValorStock = sOjGraficosService.construirJLabel("Valor de stock", (1300 - 260)/2 - 200,
                450, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.add(lValorStock);

        this.lValorxUnidad = sOjGraficosService.construirJLabel("Valor por unidad", (1300 - 260)/2 - 200,
                500, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.add(lValorxUnidad);

        this.lNegocio = sOjGraficosService.construirJLabel("Negocio", (1300 - 260)/2 - 200,
                550, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null");
        this.add(lNegocio);

    }

    public void builtJTextField (){

        this.textFieldValor= sOjGraficosService.construirJTextFiel((1300 - 260)/2, 100, 400, 40,
                "", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldValor);


        this.textFieldName = sOjGraficosService.construirJTextFiel((1300 - 260)/2, 250, 400, 40,
                "", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldName);


        this.textFieldDescription = sOjGraficosService.construirJTextFiel((1300 - 260)/2, 300, 400, 40, ""
                , Color.DARK_GRAY, recursosService.getLightFont(), "null", recursosService.getCursoTexto());
        this.add(textFieldDescription );

        this.textFielValorStock = sOjGraficosService.construirJTextFiel((1300 - 260)/2 , 450, 100, 40, ""
                , Color.DARK_GRAY, recursosService.getLightFont(), "null", recursosService.getCursoTexto());
        this.add(textFielValorStock);

        this.textFielValorxUnidad = sOjGraficosService.construirJTextFiel((1300 - 260)/2 , 500, 100, 40, ""
                ,Color.DARK_GRAY, recursosService.getLightFont(), "null", recursosService.getCursoTexto());
        this.add(textFielValorxUnidad);
    }

    public void builtJComboBox (){
        Constants constants= new Constants();
        this.comboBoxCategory = new JComboBox<>(constants.TODAS_LAS_CATEGORIAS.toArray());
        //this.comboBoxCategory.add(Constants.ProductosSinIVA);
        this.comboBoxCategory.setSize(220,40);
        this.comboBoxCategory.setLocation((1300 - 260)/2, 350);
        this.comboBoxCategory.setForeground(Color.DARK_GRAY);
        this.comboBoxCategory.setBackground(Color.WHITE);
        this.comboBoxCategory.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxCategory.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxCategory);

        this.comboBoxFuente = new JComboBox<>();
        this.comboBoxFuente.addItem("Efectivo");
        this.comboBoxFuente.addItem("Transferencia");
        this.comboBoxFuente.setSize(200,40);
        this.comboBoxFuente.setLocation((1300 - 260)/2, 150);
        this.comboBoxFuente.setForeground(Color.DARK_GRAY);
        this.comboBoxFuente.setBackground(Color.WHITE);
        this.comboBoxFuente.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxFuente.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxFuente);


        this.comboBoxMotivo= new JComboBox<>();
        this.comboBoxMotivo.addItem("Ninguno");
        this.comboBoxMotivo.addItem("Salario");
        this.comboBoxMotivo.addItem("Regalo");
        this.comboBoxMotivo.addItem("Venta Activo");
        this.comboBoxMotivo.setSize(200,40);
        this.comboBoxMotivo.setLocation((1300 - 260)/2, 200);
        this.comboBoxMotivo.setForeground(Color.DARK_GRAY);
        this.comboBoxMotivo.setBackground(Color.WHITE);
        this.comboBoxMotivo.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxMotivo.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxMotivo);


        this.comboBoxType = new JComboBox<>();
        this.comboBoxType.addItem("Corriente");
        this.comboBoxType.addItem("No corriente");
        this.comboBoxType.setSize(220,40);
        this.comboBoxType.setLocation((1300 - 260)/2, 400);
        this.comboBoxType.setForeground(Color.DARK_GRAY);
        this.comboBoxType.setBackground(Color.WHITE);
        this.comboBoxType.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxType.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxType);

        this.comboBoxNegocio = new JComboBox<>(GroupsComponent.updateFromDB().toArray());
        this.comboBoxNegocio.setSize(220,40);
        this.comboBoxNegocio.setLocation((1300 - 260)/2, 550);
        this.comboBoxNegocio.setForeground(Color.DARK_GRAY);
        this.comboBoxNegocio.setBackground(Color.WHITE);
        this.comboBoxNegocio.setCursor(recursosService.getCursoMano());
        ((JLabel) comboBoxNegocio.getRenderer()).setHorizontalAlignment(SwingUtilities.CENTER);
        this.add(comboBoxNegocio);

    }


    public void builtButton (){

        saveData = sOjGraficosService.builtButton("Guardar datos", (1300 - 260)/2 - 200, 680, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), recursosService.getMainColor(),
                Color.WHITE, null, null, true, "null");
        this.saveData.addActionListener(newItemInventoryComponent);
        this.add(saveData);

    }


    public JComboBox getComboBoxCategory() {
        return comboBoxCategory;
    }

    public JComboBox getComboBoxType() {
        return comboBoxType;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldDescription() {
        return textFieldDescription;
    }

    public JTextField getTextFielValorStock() {
        return textFielValorStock;
    }

    public JTextField getTextFielValorxUnidad() {
        return textFielValorxUnidad;
    }

    public JComboBox getComboBoxNegocio() {
        return comboBoxNegocio;
    }

    public JComboBox getComboBoxFuente() {
        return comboBoxFuente;
    }

    public JComboBox getComboBoxMotivo() {
        return comboBoxMotivo;
    }

    public JTextField getTextFieldValor() {
        return textFieldValor;
    }
}
