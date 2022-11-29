package ViewModel.Spaces;

import Model.GeneralRegistry;
import ViewModel.Constants;

public class FinancialSpace {
    public FinancialSpace() {
    name = "Área personal";
    group = Constants.DEFAULT_GROUP;
    id = 0;
    }



    //atributos estáticos:
    private static int lastIdFromDataBase(){
        int id =Manager.getAllFinancialSpaces().size();
        while (GeneralRegistry.getFinancialSpaceHashMap().containsKey(id)){
            System.out.println("ID : "+ id + " ya existe");
            id+=1;
        }return id;
    }

    private String name;
    private String group;
    private int id;

    public FinancialSpace(String name, String group, int id) {
        this.name = name;
        this.id = id;
        this.group = group;
        Manager.save(this);
    }

    public FinancialSpace(String name, String group) {
        this.name = name;
        this.group = group;
        this.id = lastIdFromDataBase();
        Manager.save(this);
    }
    //setters y getters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
