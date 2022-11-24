package ViewModel.Components.FinancialSpaces;

public class FinalcialSpacesComponent {

    private FinalcialSpacesTemplate finalcialSpacesTemplate;

    public FinalcialSpacesComponent (){

        this.finalcialSpacesTemplate = new FinalcialSpacesTemplate(this);

    }

    public FinalcialSpacesTemplate getFinalcialSpacesTemplate() {
        return finalcialSpacesTemplate;
    }
}
