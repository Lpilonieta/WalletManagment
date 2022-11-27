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

import static Model.SQLconection.con;

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


    public ArrayList<Form> getallFormsDB() throws SQLException {
        SQLconection.SqlConection();
        ArrayList<Form> allForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablaregistros");
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            String Fecha = result.getString("Fecha");
            String Id = result.getString("Id");
            String Valor = result.getString("Valor");
            String Fuente = result.getString("Fuente");
            String Motivo = result.getString("Motivo");


            Form form = new Form();
            form.setRegistryDate(Fecha);
            form.setId(Id);
            form.setPurchaseValue(Integer.parseInt(Valor));
            form.setSource(Fuente);
            form.setMotive(Motivo);

            allForms.add(form);
        }
        return allForms;
    }

    public ArrayList<Form> getallAssetsDB() throws SQLException {

        SQLconection.SqlConection();
        ArrayList<Form> assetForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablacashflow WHERE isAsset ='"+true+"' ");
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            String Fecha = result.getString("Fecha");
            String Id = result.getString("Id");
            String Valor = result.getString("Valor");
            String Fuente = result.getString("Fuente");
            String Motivo = result.getString("Motivo");
            String Nombre = result.getString("Nombre");
            String Descripcion = result.getString("Descripcion");
            String Tipo = result.getString("Tipo");
            String PorcentajeRentabilidad = result.getString("PorcentajeRentabilidad");


            Assets assets=new Assets();
            assets.setRegistryDate(Fecha);
            assets.setId(Id);
            assets.setPurchaseValue(Integer.parseInt(Valor));
            assets.setSource(Fuente);
            assets.setMotive(Motivo);
            assets.setName(Nombre);
            assets.setDescription(Descripcion);
            assets.setType(Byte.parseByte(Tipo));
            assets.setRentability(Integer.parseInt(PorcentajeRentabilidad));

            assetForms.add(assets);
        }
        return assetForms;
    }



    public ArrayList<Form> getallPasivesDB() throws SQLException {
        SQLconection.SqlConection();
        ArrayList<Form> PasiveForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablacashflow WHERE isPasive ='"+true+"' ");
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            String Fecha = result.getString("Fecha");
            String Id = result.getString("Id");
            String Valor = result.getString("Valor");
            String Fuente = result.getString("Fuente");
            String Motivo = result.getString("Motivo");
            String Nombre = result.getString("Nombre");
            String Descripcion = result.getString("Descripcion");
            String Tipo = result.getString("Tipo");
            String TipoInteres = result.getString("TipoInteres");
            String PorcentajeInteres = result.getString("PorcentajeInteres");
            String NumeroCuotas = result.getString("NumeroCuotas");
            String ValorSiguienteCuota = result.getString("ValorSiguienteCuota");
            String Periodicidad = result.getString("Periodicidad");
            String PeriodicidadEspecifica = result.getString("PeriodicidadEspecifica");


            Pasives pasives=new Pasives();
            pasives.setRegistryDate(Fecha);
            pasives.setId(Id);
            pasives.setPurchaseValue(Integer.parseInt(Valor));
            pasives.setSource(Fuente);
            pasives.setMotive(Motivo);
            pasives.setName(Nombre);
            pasives.setDescription(Descripcion);
            pasives.setType(Byte.parseByte(Tipo));
            pasives.setInterestType(Integer.parseInt(TipoInteres));
            pasives.setInterestPercentage(Integer.parseInt(PorcentajeInteres));
            pasives.setNumberOfInstallments(Integer.parseInt(NumeroCuotas));
            pasives.setInstallmentValue(Float.parseFloat(ValorSiguienteCuota));
            pasives.setPeriodicy(Byte.parseByte(Periodicidad));
            pasives.setEspecificPeriodicy(Integer.parseInt(PeriodicidadEspecifica));


            PasiveForms.add(pasives);

        }
        return PasiveForms;
    }

    public ArrayList<Form> getallInventoryFromDB() throws SQLException {

        SQLconection.SqlConection();
        ArrayList<Form> InventoryForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablacashflow WHERE isInventory ='"+true+"' ");
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            String Fecha = result.getString("Fecha");
            String Id = result.getString("Id");
            String Valor = result.getString("Valor");
            String Fuente = result.getString("Fuente");
            String Motivo = result.getString("Motivo");
            String Nombre = result.getString("Nombre");
            String Descripcion = result.getString("Descripcion");
            String Tipo = result.getString("Tipo");
            String PorcentajeRentabilidad = result.getString("PorcentajeRentabilidad");
            String NumeroStock = result.getString("NumeroStock");
            String VentasTotales = result.getString("VentasTotales");
            String ValorUnidad = result.getString("ValorUnidad");
            String Categoria = result.getString("Categoria");

            Inventory inventory=new Inventory();
            inventory.setRegistryDate(Fecha);
            inventory.setId(Id);
            inventory.setPurchaseValue(Integer.parseInt(Valor));
            inventory.setSource(Fuente);
            inventory.setMotive(Motivo);
            inventory.setName(Nombre);
            inventory.setDescription(Descripcion);
            inventory.setType(Byte.parseByte(Tipo));
            inventory.setRentability(Integer.parseInt(PorcentajeRentabilidad));
            inventory.setStockNumber(Float.parseFloat(NumeroStock));
            inventory.setSaleNumbers(Float.parseFloat(VentasTotales));
            inventory.setUnitValue(Float.parseFloat(ValorUnidad));
            inventory.setCategory(Byte.parseByte(Categoria));

            PorcentajeRentabilidad, NumeroStock, VentasTotales, ValorUnidad, Categoria
            InventoryForms.add(inventory);
        }
        return InventoryForms;
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
                    "(Fecha,Id, Valor, Fuente, Motivo, Nombre, Descripcion, Tipo, TipoInteres, PorcentajeInteres, NumeroCuotas, ValorSiguienteCuota, Periodicidad, periodicidadEspecifica) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            consulta.setString(1, pasives.getRegistryDate());
            consulta.setString(2, pasives.getId());
            consulta.setInt(3, pasives.getPurchaseValue());
            consulta.setString(4, pasives.getSource());
            consulta.setString(5, pasives.getMotive());
            consulta.setString(6, pasives.getName());
            consulta.setString(7, pasives.getDescription());
            consulta.setInt(8, pasives.getType());
            consulta.setInt(9, pasives.getInterestType());
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
