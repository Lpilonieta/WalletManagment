package Model;

import ViewModel.*;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Model.SQLconection.*;

public class GeneralRegistry implements FinacialSpaceRegistry {
    public static HashMap<String, Inventory> getInventoryHashmap() {
        return INVENTORY_REGISTRY;
    }

    public static void save(Form form) {
        if(form.isNeedAssetData()) {
            GENERAL_REGISTRY.put(form.getId(), form.getAsset());
        } else if (form.isNeedPasiveData()) {
            GENERAL_REGISTRY.put(form.getId(), form.getPasive());
        }else {
            GENERAL_REGISTRY.put(form.getId(), form);
        }
    }

    public static void updatePasiveInDatabase() {
        //TODO: actualizar pasivo en la base de datos
    }
    /*
    *
    *       @Overwrite Interface
    *
    */

    @Override
    public ArrayList<Form> getAllForms() {
        try {
            ArrayList<Form>allForms = SQLconection.getallFormsDB();
            ArrayList<Form>sortedForms = new ArrayList<>();
            for (Form form: allForms
                 ) {
                String splitId[] = form.getId().split("-");
                if (Integer.valueOf(splitId[2])== Manager.getFinEspId())sortedForms.add(form);
            }
            return sortedForms;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Assets> getAllAssets() {
        try {
            ArrayList<Assets>allForms = SQLconection.getallAssetsDB();
            ArrayList<Assets>sortedAssets = new ArrayList<>();
            for (Assets assets: allForms
            ) {
                String splitId[] = assets.getId().split("-");
                if (Integer.valueOf(splitId[2]) == Manager.getFinEspId()) sortedAssets.add(assets);
            }
            return SQLconection.getallAssetsDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Pasives> getAllPasives() {
        try {
            ArrayList<Pasives>allForms = SQLconection.getallPasivesDB();
            ArrayList<Pasives>sortedForms = new ArrayList<>();
            for (Pasives pasives: allForms
            ) {
                String splitId[] = pasives.getId().split("-");
                if (Integer.valueOf(splitId[2]) == Manager.getFinEspId()) sortedForms.add(pasives);
            }
            return SQLconection.getallPasivesDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Inventory> getAllInventory() {
        try {
            ArrayList<Inventory>allForms = SQLconection.getArrayInventoryDB();
            ArrayList<Inventory>sortedForms = new ArrayList<>();
            for (Inventory inventory: allForms
            ) {
                String splitId[] = inventory.getId().split("-");
                if (Integer.valueOf(splitId[2]) == Manager.getFinEspId()) sortedForms.add(inventory);
            }
            return SQLconection.getallInventoryFromDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Form> getAllExpensesForms() {
        ArrayList<Form> Expenses = new ArrayList<>(1);
        for (Form form : getAllForms()
        ) {
            String[] idForm = form.getId().split("-");
            if (Integer.valueOf(idForm[0]) == Constants.EXPENSE_FORM_TYPE) {
                Expenses.add(form);
            }
        }
        return Expenses;
    }

    public ArrayList<Form> getAllRevenuesForms()  {
        ArrayList<Form> Revenues = new ArrayList<>(1);
        for (Form form : getAllForms()
        ) {
            String[] idForm = form.getId().split("-");
            if (Integer.valueOf(idForm[0]) == Constants.RENEUE_FORM_TYPE) {
                Revenues.add(form);
            }
        }
        return Revenues;
    }













    //----------------------------------------------------------------------------------------------------------------//






    public void addFinancialSpacesToDB(FinancialSpace espacio) {
        financialSpaceHashMap.put(espacio.getId(),espacio);
    }
//    public static void addFinancialSpaceToDB(FinancialSpace espacio) {
//        financialSpaceHashMap.put(espacio.getId(),espacio);
//    }

    private void saveForm(Form form) {
        EXAMPLE_GENERAL_REGISTRY.put(form.getId(),form);        //TODO: para dejarlo definitivo solo quitar la parte de "EXAMPLE_"
        if (form.isNeedAssetData()){
            saveAsset(form);
        } else if (form.isNeedPasiveData()) {
            PasivesRegistry.savePasive(form);
        }
    }

    private void saveAsset(Form form) {
        ASSETS_REGISTRY.put(form.getId(), form.getAsset());
    }


    public GeneralRegistry() {

    }

    private static HashMap<Integer, FinancialSpace> financialSpaceHashMap = new HashMap<>();
    private static HashMap<String, Form> GENERAL_REGISTRY = new HashMap<>();
    private static HashMap<String, Form> EXAMPLE_GENERAL_REGISTRY = new HashMap<>();
    public static void addNewRegistry(String key, Form value){
        GENERAL_REGISTRY.put(key, value);
    }
    public static void addNewAssetRegistry(String key, Assets value){
        ASSETS_REGISTRY.put(key, value);
    }
    public static void addNewItemToInventory(String key, Inventory value){
        INVENTORY_REGISTRY.put(key, value);
    }
    public static void addUnitsToItems(Assets inventoryItem, int numberToAdd){//TODO: implementar?
        }


    public static HashMap<String, Form> getGeneralRegistry() {
        return GENERAL_REGISTRY;
    }
    public static HashMap<String, Form> getExampleGeneralRegistry(){ return EXAMPLE_GENERAL_REGISTRY; }
    public static HashMap<Integer,FinancialSpace> getFinancialSpaceHashMap(){
        return financialSpaceHashMap;
    }
    private static HashMap <String, Assets> ASSETS_REGISTRY = new HashMap<>();
    private static HashMap <String, Inventory> INVENTORY_REGISTRY = new HashMap<>();



}
