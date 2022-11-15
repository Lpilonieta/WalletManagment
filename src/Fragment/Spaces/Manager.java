package Fragment.Spaces;

import Fragment.Constants;
import Model.GeneralRegistry;

public class Manager {
    //private int
    private static int currentID = Constants.AREA_PERSONAL_ID;
    private static FinancialSpace currentFinancialSpace = Constants.AREA_PERSONAL;
    public static int getFinEspId(){
        if (currentID == Constants.NONE){
            currentID = getIdFromDb();
        }
        return currentID;
    }
    public static void newFinancialSpace(String name, String group, int id){
        updateCurrentID();
        save(new FinancialSpace(name, group, id));
    }
    public static void selectFinancialSpaceByID(int id){
        if (GeneralRegistry.getFinancialSpaceHashMap().containsKey(id)){
            currentID = id;
            currentFinancialSpace = GeneralRegistry.getFinancialSpaceHashMap().get(id);
        }else {
            System.out.println("\nKEY incorrecta\n");
        }
    }


    private static void updateCurrentID() {
        if (! GeneralRegistry.getFinancialSpaceHashMap().isEmpty()){
        while (GeneralRegistry.getFinancialSpaceHashMap().containsKey(currentID+1)){
            currentID+=1;
        }
        }
    }

    private static void save(FinancialSpace financialSpace) {
        GeneralRegistry.addFinancialSpaceToDB(financialSpace);

    }

    private static int getIdFromDb() {
        return 0;
    }
}
