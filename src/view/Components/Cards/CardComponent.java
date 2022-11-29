package view.Components.Cards;

import javax.swing.*;

public class CardComponent {

    private CardTemplate cardTemplate;

    public CardComponent (String title,ImageIcon image, String text, String textButton){

        this.cardTemplate = new CardTemplate(this, title, image, text);

    }

    public CardTemplate getCardTemplate() {
        return cardTemplate;
    }

}
