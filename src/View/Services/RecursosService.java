package View.Services;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RecursosService {

    private Color mainColor, colorSecundario, colorGrisClaro, colorGrisOscuro;
    private Cursor cursoMano, cursoTexto;
    private ImageIcon iconLogin;
    private Border bInferiorVerde, grayBorder, bVerde;
    private Font mainFont, specialTitle, cursivafont, lightFont, fontMediana, fontSubtitulo;


    static private RecursosService servicio;

    private RecursosService (){

        this.crearColores();
        this.crearFuentes();
        this.crearBordes();
        this.crearImagenes();
        this.crearCursores();

    }
    public Color getColorSecundario() {
        return colorSecundario;
    }


    public void crearCursores (){
        cursoMano = new Cursor(Cursor.HAND_CURSOR);
        cursoTexto = new Cursor(Cursor.TEXT_CURSOR);
    }

    private void crearColores (){
        mainColor = new Color(76,175,80);
        colorSecundario = new Color(66, 235, 209);
        colorGrisClaro = new Color(249,246, 249);
        colorGrisOscuro = new Color(80,80,80);
    }

    public Font getLightFont() {
        return lightFont;
    }

    private void crearFuentes (){

        mainFont = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        specialTitle = new Font("Rockwell Extra Bold", Font.PLAIN, 18);
        cursivafont = new Font("Calibri (Cuerpo)", Font.ITALIC, 17);
        lightFont = new Font("LuzSans-Book", Font.PLAIN,12);
        fontMediana = new Font("LuzSans-Book",Font.PLAIN,15);
        fontSubtitulo = new Font("Forte", Font.PLAIN,13);
    }

    public Border getGrayBorder() {
        return grayBorder;
    }

    public Border getbVerde() {
        return bVerde;
    }

    public Color getColorGrisClaro() {
        return colorGrisClaro;
    }

    private void crearBordes (){

        bInferiorVerde = BorderFactory.createMatteBorder(0,0,3,0,mainColor);
        grayBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY,2, true);
        bVerde = BorderFactory.createLineBorder(mainColor, 2, true);

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

    public Font getFontMediana() {
        return fontMediana;
    }

    public Font getFontSubtitulo() {
        return fontSubtitulo;
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

    public Color getColorGrisOscuro() {
        return colorGrisOscuro;
    }

    public static RecursosService getService(){
        if (servicio==null) servicio = new RecursosService();
        return servicio;
    }

}
