package view.Components.InfoUtil;

import javax.swing.*;

public class InfoUtilComponent {

    private InfoUtilTemplate infoUtilTemplate;

    public InfoUtilComponent(String title, String text, ImageIcon image){

        this.infoUtilTemplate = new InfoUtilTemplate(this, title, text, image);

    }

    public InfoUtilTemplate getInfoUtilTemplate() {
        return infoUtilTemplate;
    }
}
