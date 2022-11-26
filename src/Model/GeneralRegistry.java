package Model;

import ViewModel.*;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

public class GeneralRegistry implements FinacialSpaceRegistry{
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
    /*
    *
    *       @Overwrite Interface
    *
    */

    @Override
    public ArrayList<Form> getAllForms() {
        int id = Manager.getFinEspId();
        ArrayList<Form> allForms = new ArrayList<>(1);
        if (!EXAMPLE_GENERAL_REGISTRY.isEmpty()){
            for (Form form : GeneralRegistry.getExampleGeneralRegistry().values()
            ) {
                String[] idForm = form.getId().split("-");
                if (Integer.valueOf(idForm[2]) == id) {
                    allForms.add(form);
                }

            }
        }else {
            allForms.add(new Form());
        }
        return allForms;
    }

    @Override
    public ArrayList<Assets> getAllAssets() {
        ArrayList<Assets> allAssets = new ArrayList<>(1);
        for (Form form:getAllForms()
             ) {
            if (form.getAsset() != null){
                if (!form.getAsset().isInventoryItem()) {allAssets.add(form.getAsset());}
            }
        }
        return allAssets;
    }

    @Override
    public ArrayList<Pasives> getAllPasives() {
        ArrayList<Pasives> allPasives = new ArrayList<>(1);
        for (Form form:getAllForms()
        ) {
            if (form.getPasive() != null) {

                allPasives.add(form.getPasive());
            }
        }
        return allPasives;
    }

    @Override
    public ArrayList<Inventory> getAllInventory() {
        ArrayList<Inventory> allInventoryAssets = new ArrayList<>(1);
        for (Form form : getAllForms()
                ) {
            if (form.getAsset() != null) {
                if (form.getAsset().isInventoryItem()){
                    allInventoryAssets.add(form.getAsset().getInventory());
                }
            }
        }
        return allInventoryAssets;
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

    @Override
    public ArrayList<Form> getAllRevenuesForms() {
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
    public static void addFinancialSpaceToDB(FinancialSpace espacio) {
        financialSpaceHashMap.put(espacio.getId(),espacio);
    }

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

    public void SaveSqlAssets(Assets assets){
        PreparedStatement consulta;
        try {
            consulta = SQLconection.con.prepareStatement("INSERT INTO "+ "tablaregistros" +
                    "(Fecha,Id, Nombre, Descripcion, Tipo, PorcentajeRentabilidad) VALUES(?,?,?,?)");

            consulta.setDouble(1, Double.parseDouble(Id.getText()));
            consulta.setString(2, Nombre.getText());
            consulta.setString(3, Apellido.getText());
            consulta.setString(4, Deporte.getText());


            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atleta agregado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
