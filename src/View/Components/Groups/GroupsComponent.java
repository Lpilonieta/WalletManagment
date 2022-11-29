package View.Components.Groups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GroupsComponent implements ActionListener {

    private GroupsTemplate groupTemplate;

    private String name_Negocio;

    public static ArrayList<String> negociosCreados = new ArrayList<>();

    public GroupsComponent(){
        this.groupTemplate = new GroupsTemplate(this);
    }


    public GroupsTemplate getGroupTemplate() {
        return groupTemplate;
    }

    public GroupsTemplate getFinalcialSpacesTemplate() {
        return groupTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.getDataGroupForm();
        this.addInToArrayList();
        this.showArrayList();

    }

    public void getDataGroupForm (){

        name_Negocio = groupTemplate.getTextFieldNombre_negocio().getText();

    }


    public void addInToArrayList (){
        this.negociosCreados.add(name_Negocio);

    }

    public void showArrayList (){

        for (int i = 0; i < negociosCreados.size(); i++) {
            System.out.println(negociosCreados);
        }
    }

    public ArrayList<String> getNegociosCreados() {
        return negociosCreados;
    }
}
