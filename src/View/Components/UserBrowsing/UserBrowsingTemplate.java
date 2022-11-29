package View.Components.UserBrowsing;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserBrowsingTemplate extends JPanel {


    // Servicios y dependecias
    private UserBrowsingComponent userBrowsingComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    //Obj. Graficos

    private JPanel pUpper, pLower;
    private JLabel lFinanceSpaces, lEslogan, lIconUser, lNameUser, lUserImage;
    private JButton addFinanceSpace, seeMyFinanceSpaces, seeMyPersonalArea, home, seeAdvanceArea;


    // Obj. Decoradores

    private ImageIcon iconUser, iconAdd, iconSee, iconPersonalArea, iconUserImage, iconHome, iAdvanceArea;
    private Border bEmpty;

    public UserBrowsingTemplate(UserBrowsingComponent userBrowsingComponent) {

        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();
        this.userBrowsingComponent = userBrowsingComponent;

        this.builtObjectsDecoratives();
        this.bulitPanels();
        this.builtLabels();
       // this.builtJComboBox();
        this.builtJButtons();

        this.setSize(250, 900);
        this.setLayout(null);
        this.setVisible(true);


    }

    public void builtObjectsDecoratives() {

        this.iconUser = new ImageIcon("Graphics/MainPanel/usuario_navegacion.png");
        this.iconUserImage = new ImageIcon("Graphics/MainPanel/imagenUser.png");
        this.iconAdd = new ImageIcon("Graphics/MainPanel/iconAdd.png");
        this.iconSee = new ImageIcon("Graphics/MainPanel/iconSee.png");
        this.iconPersonalArea = new ImageIcon("Graphics/MainPanel/iconPersonalArea.png");
        this.iAdvanceArea= new ImageIcon("Graphics/MainPanel/iAdvance.png");
        this.iconHome = new ImageIcon("Graphics/MainPanel/iconHome.png");
        this.bEmpty = new EmptyBorder(2, 20, 2, 2);


    }

    public void bulitPanels() {

        this.pUpper = objGraficosService.contruirPanelGenerico(0, 0, 250, 300, recursosService.getMainColor(), null);
        this.add(pUpper);

        this.pLower = objGraficosService.contruirPanelGenerico(0, 300, 250, 800, recursosService.getMainColor(), null);
        this.add(pLower);

    }

    public void builtLabels() {

        //User

        this.lIconUser = objGraficosService.construirJLabel(
                null, 5, 20, 40, 40,
                null, null, null, null,
                iconUser, null, "null");
        this.pUpper.add(lIconUser);

        this.lNameUser = objGraficosService.construirJLabel(
                "Hola, " + " usuario", ((this.pUpper.getWidth() - 210) / 2) + 30, 18, 200, 40,
                Color.WHITE, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.pUpper.add(lNameUser);

        this.lEslogan = objGraficosService.construirJLabel(
                "<html><div align='center'> Admistra tu dinero <br/>Admistra tu gastos</div></html>",
                (this.pUpper.getWidth() - 100) / 2, 230, 180, 40,
                Color.WHITE, null, recursosService.getLightFont(), null, null, null, "null"
        );
        this.pUpper.add(lEslogan);

        this.lUserImage = objGraficosService.construirJLabel(null, 60, 75, 128, 128,
                null, null, null, null, iconUserImage, null, "null");

        this.pUpper.add(lUserImage);
/*
        this.lDialyRecord = objGraficosService.construirJLabel("Registro diario", 65,50, 250,20, Color.WHITE,
                null, recursosService.getMainFont(), null, null, null, "null");
        this.pLower.add(lDialyRecord);
*/
        this.lFinanceSpaces = objGraficosService.construirJLabel("Espacios financieros", 47,100, 250,20, Color.WHITE,
                null, recursosService.getMainFont(), null, null, null, "null");
        this.pLower.add(lFinanceSpaces );

    }
/*
    public void builtJComboBox (){

        this.addDailyRecord = objGraficosService.construirJComboBox(20, 90, 200, 40, recursosService.getFontMediana(), "", recursosService.getMainColor(), Color.WHITE, "null");
        this.addDailyRecord.setBorder(bEmpty);
        this.addDailyRecord.setCursor(recursosService.getCursoMano());
        this.addDailyRecord.addItem("Ingresos");
        this.addDailyRecord.addItem("Egresos");
        this.addDailyRecord.addItem("Pasivos");
        this.addDailyRecord.addItem("Activos");

        ((JLabel) this.addDailyRecord.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        this.addDailyRecord.addActionListener(userBrowsingComponent);
        this.pLower.add(addDailyRecord);
    }
*/
    public void builtJButtons() {


        this.addFinanceSpace = objGraficosService.builtButton(

                "Add Negocio",
                5, 150, 300, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE,
                iconAdd, bEmpty, true, "LEFT"
        );

        this.addFinanceSpace.addActionListener(userBrowsingComponent);
        this.pLower.add(addFinanceSpace);

        this.seeMyFinanceSpaces = objGraficosService.builtButton(

                "Ver negocios",
                5, 190, 200, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE,
                iconSee, bEmpty, true, "LEFT"
        );

        this.seeMyFinanceSpaces.addActionListener(userBrowsingComponent);
        this.pLower.add(seeMyFinanceSpaces);

        this.seeMyPersonalArea = objGraficosService.builtButton(

                "Ver area personal",
                30, 290, 350, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE,
                iconPersonalArea, bEmpty, true, "LEFT"

        );

        this.seeMyPersonalArea .addActionListener(userBrowsingComponent);
        this.pLower.add(seeMyPersonalArea );

        this.seeAdvanceArea = objGraficosService.builtButton(

                " Ver area avanzada",
                20, 340, 350, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE,
                iAdvanceArea, bEmpty, true, "LEFT"
        );

        this.seeAdvanceArea .addActionListener(userBrowsingComponent);
        this.pLower.add(seeAdvanceArea);
/*
        this.home = objGraficosService.builtButton(
                "Home",
                30, 440, 350, 40,
                recursosService.getCursoMano(), recursosService.getFontMediana(), null, Color.WHITE,
                iconHome, bEmpty, true, "LEFT"
        );

        this.home .addActionListener(userBrowsingComponent);
        this.pLower.add(home );

*/
    }

}


