package View.Components.Groups;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class GroupsTemplate extends JPanel {

    private GroupsComponent groupComponent;

    private ObjGraficosService sObjGraficosService;

    private RecursosService recursosService;
    private JButton saveData;

    private JLabel nombre_negocio, title;

    private JTextField textFieldNombre_negocio;
    public GroupsTemplate(GroupsComponent groupsComponent) {

        this.groupComponent = groupsComponent;
        this.sObjGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();


        this.builtJLabels();
        this.builtButton();
        this.builtJTextField();


        this.setSize(1300, 850);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void builtJLabels (){

        this.title = sObjGraficosService.construirJLabel("Nuevo negocio" , (1300 - 260)/2 - 200,
                50, 260,40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "null"
        );
        this.add(title);

        this.nombre_negocio = sObjGraficosService.construirJLabel("Nombre negocio" , (1300 - 260)/2 - 290,
                200, 260,40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(nombre_negocio);

    }

    public void builtJTextField (){

        this.textFieldNombre_negocio = sObjGraficosService.construirJTextFiel((1300 - 260)/2 - 100, 200, 400, 40,
                " ", Color.DARK_GRAY, recursosService.getLightFont(), "null",recursosService.getCursoTexto());
        this.add(textFieldNombre_negocio);

    }

    public void builtButton (){

        saveData = sObjGraficosService.builtButton("Guardar grupo", (1300 - 260)/2 - 200, 300, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), recursosService.getMainColor(),
                Color.WHITE, null, null, true, "null");
        this.saveData.addActionListener(groupComponent);
        this.add(saveData);

    }

    public JTextField getTextFieldNombre_negocio() {
        return textFieldNombre_negocio;
    }
}
