package View.Components.TitleBar;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;

import javax.swing.*;
import java.awt.*;

public class TitleBarTemplate extends JPanel {

    // Servicios y dependencias
    private TitleBarComponent titleBarComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    // Obj. Graficos
    private JLabel lLogo, lTitle;

    //Decoradores
    private ImageIcon imageApp;
    private Font fTitleBar;

    public TitleBarTemplate(TitleBarComponent titleBarComponent) {

        this.titleBarComponent = titleBarComponent;
        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();

        this.builtObjectsDecoratives();
        this.builtJlabels();


        this.setSize(1300,50);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);

    }

   public void builtObjectsDecoratives (){

        imageApp = new ImageIcon("Graphics/MainPanel/large-wallet-icon-in-flat-style-save-money-in-wallet-cartoon-illustration-vector.jpg");
        fTitleBar = new Font("Britannic Bold", Font.PLAIN, 24);

   }

    public JLabel getlLogo() {
        return lLogo;
    }

    public JLabel getlTitle() {
        return lTitle;
    }

    public ImageIcon getImageApp() {
        return imageApp;
    }

    public Font getfTitleBar() {
        return fTitleBar;
    }

    public TitleBarComponent getTitleBarComponent() {
        return titleBarComponent;
    }

    public ObjGraficosService getObjGraficosService() {
        return objGraficosService;
    }

    public RecursosService getRecursosService() {
        return recursosService;
    }

    public void builtJlabels (){

        lLogo = objGraficosService.construirJLabel(
                null, 20,0,50, 50,
                null, null, null, null,
                imageApp, null, "null"
        );
        this.add(lLogo);

        lTitle = objGraficosService.construirJLabel(
                "WalletManagment",
                65,5,200,40,
                recursosService.getMainColor(), null, fTitleBar,
                null, null, null, "null"
        );
        this.add(lTitle);

   }
}
