package Model;

import ViewModel.*;
import ViewModel.Spaces.FinancialSpace;

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
    /*
    *
    *       @Overwrite Interface
    *
    */

    @Override
    public ArrayList<Form> getAllForms() {
        try {
            return  SQLconection.getallFormsDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Assets> getAllAssets() {
        try {
            return SQLconection.getallAssetsDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Pasives> getAllPasives() {
        try {
            return SQLconection.getallPasivesDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Inventory> getAllInventory() {
        try {
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

    public static void SaveSqlForms(Assets assets){
        PreparedStatement consulta;
        try {
            consulta = SQLconection.con.prepareStatement("INSERT INTO "+ "tablaregistros" +
                    "(Fecha,Id, Valor, Fuente, Motivo) VALUES(?,?,?,?,?)");

            consulta.setString(1, assets.getRegistryDate());
            consulta.setString(2, assets.getId());
            consulta.setInt(3, assets.getPurchaseValue());
            consulta.setString(4, assets.getSource());
            consulta.setString(5, assets.getMotive());





            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(SQLconection.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static void SaveSqlAssets(Assets assets){
        PreparedStatement consulta;
        try {
            consulta = SQLconection.con.prepareStatement("INSERT INTO "+ "tablaregistros" +
                    "(Fecha,Id, Valor, Fuente, Motivo, Nombre, Descripcion, Tipo, PorcentajeRentabilidad) VALUES(?,?,?,?,?,?,?,?,?)");

            consulta.setString(1, assets.getRegistryDate());
            consulta.setString(2, assets.getId());
            consulta.setInt(3, assets.getPurchaseValue());
            consulta.setString(4, assets.getSource());
            consulta.setString(5, assets.getMotive());
            consulta.setString(6, assets.getName());
            consulta.setString(7, assets.getDescription());
            consulta.setByte(8, assets.getType());
            consulta.setInt(9, assets.getRentability());



            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(SQLconection.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    public static void SaveSqlPasives(Pasives pasives){
        PreparedStatement consulta;
        try {
            consulta = SQLconection.con.prepareStatement("INSERT INTO "+ "tablaregistros" +
                    "(Fecha,Id, Valor, Fuente, Motivo, Nombre, Descripcion, Tipo, SaldoDeuda, PorcentajeInteres, NumeroCuotas, ValorSiguienteCuota, Periodicidad, periodicidadEspecifica) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            consulta.setString(1, pasives.getRegistryDate());
            consulta.setString(2, pasives.getId());
            consulta.setInt(3, pasives.getPurchaseValue());
            consulta.setString(4, pasives.getSource());
            consulta.setString(5, pasives.getMotive());
            consulta.setString(6, pasives.getName());
            consulta.setString(7, pasives.getDescription());
            consulta.setInt(8, pasives.getType());
            consulta.setInt(9, pasives.getSaldoDeuda());
            consulta.setFloat(10, pasives.getInterestPercentage());
            consulta.setInt(11, pasives.getNumberOfInstallments());
            consulta.setFloat(12, pasives.getInstallmentValue());
            consulta.setInt(13, pasives.getPeriodicy());
            consulta.setInt(14, pasives.getEspecificPeriodicy());



            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(SQLconection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void SaveSqlInventory(Inventory inventory) {
        PreparedStatement consulta;
        try {
            consulta = SQLconection.con.prepareStatement("INSERT INTO " + "tablaregistros" +
                    "(Fecha,Id, Valor, Fuente, Motivo, Nombre, Descripcion, Tipo, PorcentajeRentabilidad, NumeroStock, VentasTotales, ValorUnidad, Categoria) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");

            consulta.setString(1, inventory.parseDatetoString());
            consulta.setString(2, inventory.getId());
            consulta.setInt(3, inventory.getPurchaseValue());
            consulta.setString(4, inventory.getSource());
            consulta.setString(5, inventory.getMotive());
            consulta.setString(6, inventory.getName());
            consulta.setString(7, inventory.getDescription());
            consulta.setByte(8, inventory.getType());
            consulta.setInt(9, inventory.getRentability());
            consulta.setFloat(10, inventory.getStockNumber());
            consulta.setFloat(11, inventory.getSaleNumbers());
            consulta.setFloat(12, inventory.getUnitValue());
            consulta.setInt(13, inventory.getCategory());


            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(SQLconection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
