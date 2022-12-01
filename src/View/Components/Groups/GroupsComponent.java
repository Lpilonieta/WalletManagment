package View.Components.Groups;

import Model.SQLconection;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
        FinancialSpace financialSpace = new FinancialSpace(name_Negocio);
        User.newFinancianSpace(name_Negocio);


    }

    public void showArrayList (){

        for (int i = 0; i < negociosCreados.size(); i++) {
            System.out.println(negociosCreados);
        }
    }
    public static ArrayList<String> updateFromDB() {
        ArrayList<String>finSpacesNames = new ArrayList<>(1);

        try {
            ArrayList<FinancialSpace>allFinSpaces = SQLconection.getAllFinancialSpacesBD();
            for (FinancialSpace fin :
                    allFinSpaces) {
                finSpacesNames.add(fin.getName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }if (finSpacesNames.isEmpty())finSpacesNames.add("Área personal");
        return finSpacesNames;
    }


    public ArrayList<String> getNegociosCreados() {
        return negociosCreados;
    }
}
