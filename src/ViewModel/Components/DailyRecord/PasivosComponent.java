package ViewModel.Components.DailyRecord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasivosComponent implements ActionListener {

    private PasivosTemplate pasivosTemplate;

    public PasivosComponent (){

        this.pasivosTemplate = new PasivosTemplate(this);

    }

    public PasivosTemplate getPasivosTemplate() {
        return pasivosTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {




    }
}
