package ViewModel.Components.DailyRecord;

public class EgresosComponent {

    private EgresosTemplate egresosTemplate;


    public EgresosComponent (){

        this.egresosTemplate = new EgresosTemplate(this);
    }

    public EgresosTemplate getEgresosTemplate() {
        return egresosTemplate;
    }
}
