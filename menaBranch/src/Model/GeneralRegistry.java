package Model;

import Fragment.*;
import Fragment.Spaces.FinancialSpace;
import Fragment.Spaces.Manager;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneralRegistry implements FinacialSpaceRegistry{
    /*
    *
    *       @Overwrite Interface
    *
    */

    @Override
    public ArrayList<Form> getAllForms() {
        int id = Manager.getFinEspId();
        ArrayList<Form> allForms = new ArrayList<>(1);
        for (Form form:GeneralRegistry.getExampleGeneralRegistry().values()
             ) {
            String[] idForm = form.getId().split("-");
            if (idForm[2] == String.valueOf(id)){
                allForms.add(form);
            }

        }
        return allForms;
    }

    @Override
    public ArrayList<Assets> getAllAssets() {
        ArrayList<Assets> allAssets = new ArrayList<>(1);
        for (Form form:getAllForms()
             ) {
            allAssets.add(form.getAsset());
        }
        return allAssets;
    }

    @Override
    public ArrayList<Pasives> getAllPasives() {
        ArrayList<Pasives> allPasives = new ArrayList<>(1);
        for (Form form:getAllForms()
        ) {
            allPasives.add(form.getPasive());
        }
        return allPasives;
    }

    @Override
    public ArrayList<Inventory> getAllInventory() {
        ArrayList<Inventory> allInventoryAssets = new ArrayList<>(1);
        for (Assets assets : getAllAssets()
                ) {
            if (assets.isInventoryItem()){
                allInventoryAssets.add(assets.getInventory());
            }
        }
        return allInventoryAssets;
    }
    //----------------------------------------------------------------------------------------------------------------//

    public static void updateFinancialSpacesID() {
        int hashmapSize = financialSpaceHashMap.size();
        for (int i=1;i+1<hashmapSize;i++) {
            if (!financialSpaceHashMap.containsKey(i)) {
                financialSpaceHashMap.put(i,financialSpaceHashMap.get(i+1));
                financialSpaceHashMap.remove(i+1);
            }
        }

    }


    public void addFinancialSpacesToDB(FinancialSpace espacio) {
        financialSpaceHashMap.put(espacio.getId(),espacio);
    }
    public static void addFinancialSpaceToDB(FinancialSpace espacio) {
        financialSpaceHashMap.put(espacio.getId(),espacio);
    }

    private void saveForm(Form form) {
        EXAMPLE_GENERAL_REGISTRY.put(form.getId(),form);        //TODO: para dejarlo definitivo solo quitar la parte de "EXAMPLE_"
        if (form.isNeedAssetData()){
            AssetsRegistry.saveAsset(form);
        } else if (form.isNeedPasiveData()) {
            PasivesRegistry.savePasive(form);
        }
    }



    public GeneralRegistry() {

    }

    private static HashMap<Integer, FinancialSpace> financialSpaceHashMap = new HashMap<>();
    private static HashMap<String, Form> GENERAL_REGISTRY = new HashMap<>();
    private static HashMap<String, Form> EXAMPLE_GENERAL_REGISTRY = new HashMap<>();
    public static void addNewRegistry(String key, Form value){
        GENERAL_REGISTRY.put(key, value);
    }

    public static HashMap<String, Form> getGeneralRegistry() {
        return GENERAL_REGISTRY;
    }
    public static HashMap<String, Form> getExampleGeneralRegistry(){ return EXAMPLE_GENERAL_REGISTRY; }
    public static HashMap<Integer,FinancialSpace> getFinancialSpaceHashMap(){
        return financialSpaceHashMap;
    }
}
