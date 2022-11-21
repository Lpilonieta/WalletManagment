package ViewModel.Services;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ObjGraficosService extends JFrame {

    static private ObjGraficosService servicio;

    private JPanel panelGenerico;
    private JButton button;
    private JScrollPane panelScroll;
    private JRadioButton radioButton;
    private JCheckBox checkBox;
    private JLabel label;
    private JTextField textField;
    private JTextArea textArea;
    private JComboBox<String> comboBox;

    private ObjGraficosService(){

    }

    //Patrón singleton

    public static ObjGraficosService getService(){
        if(servicio==null) servicio = new ObjGraficosService();
        return servicio;
    }


    public JPanel contruirPanelGenerico (int ancho, int alto, int x, int y, Color colorFondo, Border borde){

        panelGenerico = new JPanel();
        panelGenerico.setSize(ancho,alto);
        panelGenerico.setLocation(x,y);
        panelGenerico.setLayout(null);
        panelGenerico.setBackground(colorFondo);
        panelGenerico.setBorder(borde);
        return panelGenerico;
   }

    public JButton construirBoton (String texto, int x, int y, int ancho, int alto, Cursor cursor,
                                   Font fuente, Color colorFondo, Color colorFuente, ImageIcon image,
                                   Border border, boolean esSolido, String direccion){

        button = new JButton(texto);
        button.setLocation(x,y);
        button.setSize(ancho, alto);
        button.setFocusable(false);
        button.setCursor(cursor);
        button.setFont(fuente);
        button.setBackground(colorFondo);
        button.setForeground(colorFuente);
        button.setIcon(image);
        button.setBorder(border);
        button.setContentAreaFilled(esSolido);

        switch (direccion){

            case "LEFT":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "RIGHT":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            case "TOP":
                button.setVerticalTextPosition(SwingConstants.TOP);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            case "BOTTOM":
                button.setVerticalTextPosition(SwingConstants.BOTTOM);
                button.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            default:
                break;
        }

        return button;
   }

    public JScrollPane construirPanelBarra (Component componente, int x, int y, int ancho, int alto, Color colorFondo, Border borde){

        panelScroll = new JScrollPane(componente);
        panelScroll.setLocation(x,y);
        panelScroll.setSize(ancho, alto);
        panelScroll.getViewport().setBackground(colorFondo);
        panelScroll.setBorder(borde);

        return panelScroll;
    }

    public  JRadioButton construirRadioButton (String texto, int x, int y, int ancho, int alto, Cursor cursor, Font font, Color colorFuente){

        radioButton = new JRadioButton(texto);
        radioButton.setLocation(x,y);
        radioButton.setSize(ancho, alto);
        radioButton.setFocusable(false);
        radioButton.setBackground(null);
        radioButton.setCursor(cursor);
        radioButton.setFont(font);
        radioButton.setForeground(colorFuente);

        return radioButton;
    }

    public JCheckBox construirJCheckBox (String texto, int x, int y, int ancho, int alto, Cursor cursor, Font font, Color colorFuente){

        checkBox = new JCheckBox(texto);
        checkBox.setLocation(x,y);
        checkBox.setSize(ancho, alto);
        checkBox.setFocusable(false);
        checkBox.setBackground(null);
        checkBox.setCursor(cursor);
        checkBox.setFont(font);
        checkBox.setForeground(colorFuente);

        return checkBox;
    }

    public JLabel construirJLabel (String texto, int x, int y, int ancho, int alto, Color colorFuente,
                                   Color colorFondo, Font font, Cursor cursor, ImageIcon imagen, Border borde, String direccion){

        label = new JLabel(texto);
        label.setLocation(x, y);
        label.setSize(ancho, alto);
        label.setForeground(colorFuente);
        label.setFont(font);
        label.setCursor(cursor);
        label.setIcon(imagen);
        label.setBorder(borde);
        if (colorFondo != null) {
            label.setOpaque(true);
            label.setBackground(colorFondo);
        }
        switch (direccion) {
            case "CENTER":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "RIGHT":
                label.setHorizontalAlignment(SwingConstants.RIGHT);
                label.setHorizontalTextPosition(SwingConstants.LEFT);
                break;
            case "TOP":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalTextPosition(SwingConstants.TOP);
                label.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            case "BOTTOM":
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalTextPosition(SwingConstants.BOTTOM);
                label.setHorizontalTextPosition(SwingConstants.CENTER);
                break;
            default:
                break;
        }

        return label;
    }

    public JTextField construirJTextFiel (int x, int y, int ancho, int alto, String texto, Color colorFuente,
                                          Color colorFondo, Color colorCarte, Color colorCaret, Font font, Border borde, String direccion){

        textField = new JTextField();
        textField.setLocation(x, y);
        textField.setSize(ancho, alto);
        textField.setText(texto);
        textField.setForeground(colorFuente);
        textField.setBackground(colorFondo);
        textField.setCaretColor(colorCaret);
        textField.setFont(font);
        textField.setBorder(borde);
        switch (direccion) {
            case "CENTER":
                textField.setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "RIGHT":
                textField.setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                break;
        }


        return textField;
    }

    public JTextArea construirJTextArea (int x, int y, int ancho, int alto, String texto, Font font,
                                         Color colorFuente, Color colorFondo, Color colorCaret, Border borde){

        textArea = new JTextArea();
        textArea.setLocation(x, y);
        textArea.setSize(ancho, alto);
        textArea.setText(texto);
        textArea.setFont(font);
        textArea.setForeground(colorFuente);
        textArea.setBackground(colorFondo);
        textArea.setCaretColor(colorCaret);
        textArea.setBorder(borde);
        return textArea;

    }

    public JComboBox<String> construirJComboBox (int x, int y, int ancho, int alto, Font font, String cadena, Color colorFondo, Color colorFuente, String direccion ){

        comboBox = new JComboBox<String>();
        comboBox.setLocation(x, y);
        comboBox.setSize(ancho, alto);
        for (String item : cadena.split("_")) {
            comboBox.addItem(item);
        }
        comboBox.setFont(font);
        comboBox.setBackground(colorFondo);
        comboBox.setForeground(colorFuente);
        switch (direccion) {
            case "CENTER":
                ((JLabel) comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "RIGHT":
                ((JLabel) comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                break;
        }

        return comboBox;
    }


}

