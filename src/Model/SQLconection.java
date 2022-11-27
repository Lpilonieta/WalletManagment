package Model;

import ViewModel.*;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLconection {

    public static java.sql.Connection con;

    public static String driver  = "com.cj.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/registros";


    public static void SqlConection() throws SQLException {
        GeneralRegistry saveSqlPasives = new GeneralRegistry();
        con = null;
        //Aca se puede probrar si la conexion fue exitosa

        try {


            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Conexión no exitosa");
        }


    }


    public static ArrayList<Inventory> getallInventoryFromDB() throws SQLException {

        SQLconection.SqlConection();
        ArrayList<Inventory> InventoryForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablaregistro WHERE isInventory ='"+true+"' ");
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

            InventoryForms.add(inventory);
        }
        return InventoryForms;
    }

    public static ArrayList<Pasives> getallPasivesDB() throws SQLException {
        SQLconection.SqlConection();
        ArrayList<Pasives> PasiveForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablaregistro WHERE isPasive ='"+true+"' ");
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
            String SaldoDeuda = result.getString("SaldoDeuda");
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
            pasives.setSaldoDeuda(Integer.parseInt(SaldoDeuda));
            pasives.setInterestPercentage(Integer.parseInt(PorcentajeInteres));
            pasives.setNumberOfInstallments(Integer.parseInt(NumeroCuotas));
            pasives.setInstallmentValue(Float.parseFloat(ValorSiguienteCuota));
            pasives.setPeriodicy(Byte.parseByte(Periodicidad));
            pasives.setEspecificPeriodicy(Integer.parseInt(PeriodicidadEspecifica));


            PasiveForms.add(pasives);

        }
        return PasiveForms;
    }

    public static ArrayList<Assets> getallAssetsDB() throws SQLException {

        SQLconection.SqlConection();
        ArrayList<Assets> assetForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablaregistros WHERE isAsset ='true' ");
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
    public static ArrayList<Form> getallFormsDB() throws SQLException {

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

    public static void deleteAsset(String id) throws SQLException {

        SQLconection.SqlConection();

        PreparedStatement pps = con.prepareStatement("DELETE FROM planetas WHERE Id =' "+id+" ' ");
        pps.executeUpdate();
    }

    public static String SaldoInicial(String fechaDiaAnterior) throws SQLException {
        SQLconection.SqlConection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablacashflow WHERE Fecha ='"+fechaDiaAnterior+"' ");

        ResultSet result = statement.executeQuery();

        ArrayList<String> Saldos = new ArrayList<>();

        while (result.next()) {
            Saldos.clear();
            Saldos.add(result.getString("Saldo"));
        }
        //String SaldoInicial = Saldos.get(Saldos.size()-1);
        System.out.println(Saldos);
        //System.out.println(SaldoInicial);
        //String SaldoInicial = "a";
        return Saldos.get(0);
    }

    public static void modifyPasive(String id, String NuevoSaldo, String NuevoNumeroCuotas) throws SQLException {
        SQLconection.SqlConection();

        PreparedStatement pps = con.prepareStatement("UPDATE"+ "tablaregistros"+" SET SaldoDeuda= ' "+NuevoSaldo+" ' ,NumeroCuotas= ' "+NuevoNumeroCuotas+" ' WHERE Id ="+id);

        pps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos actualizados");
    }

    public static void modifyInventory(String id, String NuevoNumeroStock, String NuevasVentasTotales) throws SQLException {
        SQLconection.SqlConection();

        PreparedStatement pps = con.prepareStatement("UPDATE"+ "tablaregistros"+" SET NumeroStock= ' "+NuevoNumeroStock+" ' ,VentasTotales= ' "+NuevasVentasTotales+" ' WHERE Id ="+id);

        pps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos actualizados");
    }

    public static ArrayList<Form> ArrayFormsDB;
    public static ArrayList<Assets> ArrayAssetsDB;
    public static ArrayList<Pasives> ArrayPasivesDB;
    public static ArrayList<Inventory> ArrayInventoryDB;

    public static void getFormsFromDB() throws SQLException {
        ArrayFormsDB = getallFormsDB();
        ArrayAssetsDB = getallAssetsDB();
        ArrayPasivesDB = getallPasivesDB();
        ArrayInventoryDB = getallInventoryFromDB();
    }

    public static ArrayList<Form> getArrayFormsDB() {
        return ArrayFormsDB;
    }

    public static ArrayList<Assets> getArrayAssetsDB() {
        return ArrayAssetsDB;
    }

    public static ArrayList<Pasives> getArrayPasivesDB() {
        return ArrayPasivesDB;
    }

    public static ArrayList<Inventory> getArrayInventoryDB() {
        return ArrayInventoryDB;
    }
}
