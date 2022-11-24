package ViewModel.Components.PersonalArea;

public class PersonalAreaComponent {

    private PersonalAreaTemplate personalAreaTemplate;

    public PersonalAreaComponent (){

        this.personalAreaTemplate = new PersonalAreaTemplate(this);

    }


    public PersonalAreaTemplate getPersonalAreaTemplate() {
        return personalAreaTemplate;
    }
}
