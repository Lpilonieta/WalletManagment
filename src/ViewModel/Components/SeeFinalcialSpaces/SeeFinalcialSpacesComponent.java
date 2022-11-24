package ViewModel.Components.SeeFinalcialSpaces;

public class SeeFinalcialSpacesComponent {

    private SeeFinalcialSpacesTemplate seeFinalcialSpacesTemplate;

    public SeeFinalcialSpacesComponent (){

        this.seeFinalcialSpacesTemplate = new SeeFinalcialSpacesTemplate(this);


    }

    public SeeFinalcialSpacesTemplate getSeeFinalcialSpacesTemplate() {
        return seeFinalcialSpacesTemplate;
    }
}
