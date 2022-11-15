package Fragment.Spaces;

public class FinancialSpace {
    private String name;
    private String group;
    private int id;

    public FinancialSpace(String name, String group, int id) {
        this.name = name;
        this.group = group;
        this.id = id;
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
