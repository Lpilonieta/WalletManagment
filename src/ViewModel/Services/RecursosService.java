package ViewModel.Services;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RecursosService {

    private Color mainColor;

    private Cursor cursoMano;
    private Cursor cursoTexto;
    private ImageIcon iconLogin, iConUser, iConPassword, iconExit;

    private Border bInferiorVerde;
    private Font mainFont, specialTitle, cursivafont;

    static private RecursosService servicio;

    private RecursosService (){


    }


    private void crearColores (){
        mainColor = new Color(76,175,80);
    }

    private void crearFuentes (){

        mainFont = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        specialTitle = new Font("Rockwell Extra Bold", Font.PLAIN, 18);
        cursivafont = new Font("Calibri (Cuerpo)", Font.ITALIC, 17);

    }

    private void crearBordes (){

        bInferiorVerde = BorderFactory.createMatteBorder(0,0,3,0,mainColor);
    }

    private void crearImagenes (){

        iconLogin = new ImageIcon("WalletManagment-master/Graphics/Login/8801574.png");

    }

    public Color getMainColor() {
        return mainColor;
    }

    public Cursor getCursoMano() {
        return cursoMano;
    }

    public Cursor getCursoTexto() {
        return cursoTexto;
    }

    public ImageIcon getIconLogin() {
        return iconLogin;
    }

    public ImageIcon getiConUser() {
        return iConUser;
    }

    public ImageIcon getiConPassword() {
        return iConPassword;
    }

    public ImageIcon getIconExit() {
        return iconExit;
    }

    public Border getbInferiorVerde() {
        return bInferiorVerde;
    }

    public Font getMainFont() {
        return mainFont;
    }

    public Font getSpecialTitle() {
        return specialTitle;
    }

    public Font getCursivafont() {
        return cursivafont;
    }

    public static RecursosService getServicio() {
        return servicio;
    }

    public static RecursosService getService(){
        if (servicio==null) servicio = new RecursosService();
        return servicio;
    }

}
