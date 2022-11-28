package ViewModel.Components.Cards;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardComponent {

    private CardTemplate cardTemplate;

    public CardComponent (String title,ImageIcon image, String text, String textButton){

        this.cardTemplate = new CardTemplate(this, title, image, text);

    }

    public CardTemplate getCardTemplate() {
        return cardTemplate;
    }

}
