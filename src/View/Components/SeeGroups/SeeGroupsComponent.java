package View.Components.SeeGroups;

public class SeeGroupsComponent {

    private SeeGroupsTemplate seeFinalcialSpacesTemplate;

    public SeeGroupsComponent(){

        this.seeFinalcialSpacesTemplate = new SeeGroupsTemplate(this);


    }

    public SeeGroupsTemplate getSeeFinalcialSpacesTemplate() {
        return seeFinalcialSpacesTemplate;
    }
}
