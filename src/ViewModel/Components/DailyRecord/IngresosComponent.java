package ViewModel.Components.DailyRecord;

public class IngresosComponent {

    private IngresosTemplate ingresosTemplate;


    public IngresosComponent (){

        this.ingresosTemplate = new IngresosTemplate(this);

    }

    public IngresosTemplate getIngresosTemplate() {
        return ingresosTemplate;
    }
}
