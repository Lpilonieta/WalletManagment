package ViewModel.Spaces;

import Model.SQLconection;
import ViewModel.Constants;
import Model.GeneralRegistry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Manager  {
    private static ArrayList<FinancialSpace> allFinancialSpacesInDB;
    private static int currentID = Constants.AREA_PERSONAL_ID;
    private static FinancialSpace currentFinancialSpace = Constants.AREA_PERSONAL;



    public static int getFinEspId(){
        return currentID;
    }
    private static void update() {
        Iterator<FinancialSpace> financialSpaceIterator = allFinancialSpacesInDB.iterator();
        FinancialSpace financialSpace;
        while (financialSpaceIterator.hasNext()){
            financialSpace = financialSpaceIterator.next();
            if (financialSpace.getId() > currentID){
                currentFinancialSpace = financialSpace;
                currentID= financialSpace.getId();
            }
        }
    }

    public Manager() {
        allFinancialSpacesInDB = getAllFinancialSpaces();
        update();
    }


    public static void deleteFinancialSpace(FinancialSpace financialSpace){
        allFinancialSpacesInDB.remove(financialSpace);
        try {
            SQLconection.deleteFinancialSpace(String.valueOf(financialSpace.getId()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteFinancialSpaceByID(int id){
        FinancialSpace toEliminate;
        for (FinancialSpace financialSpace :
        allFinancialSpacesInDB) {
            if (id == financialSpace.getId()){
                toEliminate=financialSpace;
                deleteFinancialSpace(toEliminate);
                break;
            }
        }

    }

    public static void save(FinancialSpace financialSpace) {
        SQLconection.SaveSqlFinancialSpaces(financialSpace);
        update();

    }

    public static void switchFinancialSpaceByID(FinancialSpace financialSpace){
        if (allFinancialSpacesInDB.contains(financialSpace)){
            currentID = financialSpace.getId();
            currentFinancialSpace = GeneralRegistry.getFinancialSpaceHashMap().get(financialSpace);
        }else {
            System.out.println("\nKEY incorrecta\n");
        }
    }

    public static void switchFinancialSpace(FinancialSpace financialSpace) {
        currentFinancialSpace = financialSpace;
        currentID = financialSpace.getId();
    }
    public static ArrayList<FinancialSpace> getAllFinancialSpaces() {
        try {
            return  SQLconection.getAllFinancialSpacesBD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
