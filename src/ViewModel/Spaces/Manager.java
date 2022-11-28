package ViewModel.Spaces;

import Model.SQLconection;
import Model.GeneralRegistry;

import java.sql.SQLException;
import java.util.ArrayList;

public class Manager  {
    //private int
    private static int currentID = Constants.AREA_PERSONAL_ID;
    private static FinancialSpace currentFinancialSpace = Constants.AREA_PERSONAL;
    public static int getFinEspId(){
        if (currentID == Constants.NONE){
            currentID = getIdFromDb();
        }
        return currentID;
    }
    private static void updateCurrentID() {
        if (! GeneralRegistry.getFinancialSpaceHashMap().isEmpty()){
        while (GeneralRegistry.getFinancialSpaceHashMap().containsKey(currentID+1)){
            currentID+=1;
        }
        }
    }

    private static int getIdFromDb() {
        return 0;
    }










    public static void deleteFinancialSpace(FinancialSpace financialSpace){
        deleteFinancialSpaceByID(financialSpace.getId());
    }
    public static void deleteFinancialSpaceByID(int id){
        /*
        * revisa que exista la key
        * si existe la borra
        * shiftea todos los id superiores
        * */
        if (GeneralRegistry.getFinancialSpaceHashMap().containsKey(id)){
            GeneralRegistry.getFinancialSpaceHashMap().remove(id);
        }
    }

    public static void save(FinancialSpace financialSpace) {
        GeneralRegistry.addFinancialSpaceToDB(financialSpace);

    }

    public static void switchFinancialSpaceByID(int id){
        if (GeneralRegistry.getFinancialSpaceHashMap().containsKey(id)){
            currentID = id;
            currentFinancialSpace = GeneralRegistry.getFinancialSpaceHashMap().get(id);
        }else {
            System.out.println("\nKEY incorrecta\n");
        }
    }

    public static void switchFinancialSpace(FinancialSpace financialSpace) {
        currentFinancialSpace = financialSpace;
        currentID = financialSpace.getId();
    }
    public ArrayList<FinancialSpace> getAllFinancialSpaces() {
        try {
            return  SQLconection.getAllFinancialSpacesBD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
