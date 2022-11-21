package Fragment.Spaces;

import Fragment.Constants;
import Model.GeneralRegistry;

public class FinancialSpace {
    //atributos estáticos:
    private static int lastIdFromDataBase(){
        int id =GeneralRegistry.getFinancialSpaceHashMap().size();
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
    }

    public FinancialSpace(String name, String group) {
        this.name = name;
        this.group = group;
        this.id = lastIdFromDataBase();
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
