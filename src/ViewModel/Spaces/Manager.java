package ViewModel.Spaces;

import Model.SQLconection;
import ViewModel.Constants;
import Model.GeneralRegistry;
import ViewModel.Form;

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
    public static void update() {

        try {
            allFinancialSpacesInDB = SQLconection.getAllFinancialSpacesBD();
            Iterator<FinancialSpace> financialSpaceIterator = allFinancialSpacesInDB.iterator();
            for (Form form:SQLconection.getallFormsDB()){
                String[] splitId = form.getId().split("-");
                if (Form.getLastID()<=Integer.valueOf(splitId[1])){
                    Form.setLastID(Integer.valueOf(splitId[1]));
                }
            }
            FinancialSpace financialSpace;
            while (financialSpaceIterator.hasNext()){
                financialSpace = financialSpaceIterator.next();
                if (financialSpace.getId() > currentID){
                    currentFinancialSpace = financialSpace;
                    currentID= financialSpace.getId();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;


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
