package ViewModel.Components.DailyRecord;

public class ActivosComponent {

    private ActivosTemplate activosTemplate;

    public ActivosComponent (){

        this.activosTemplate = new ActivosTemplate(this);
    }

    public ActivosTemplate getActivosTemplate() {
        return activosTemplate;
    }
}
