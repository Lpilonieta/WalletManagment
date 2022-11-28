package Model;

import ViewModel.*;
import ViewModel.Spaces.FinancialSpace;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLconection {

    public static java.sql.Connection con;

    public static String driver  = "com.cj.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/registros";


    public static void SqlConection() throws SQLException {
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

    public static void SaveSqlFinancialSpaces(FinancialSpace financialSpace) {
        PreparedStatement consulta;
        try {
            consulta = SQLconection.con.prepareStatement("INSERT INTO "+ "tablaregistros" +
                    "(Id, Nombre, Grupo) VALUES(?,?,?)");

            consulta.setString(1, String.valueOf(financialSpace.getId()));
            consulta.setString(2, financialSpace.getName());
            consulta.setString(3, financialSpace.getGroup());
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "algo salió mal");

            Logger.getLogger(SQLconection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public static ArrayList<Inventory> getallInventoryFromDB() throws SQLException {

        SQLconection.SqlConection();
        ArrayList<Inventory> InventoryForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablaregistros WHERE isInventory ='"+true+"' ");
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

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablaregistros WHERE isPasive ='"+true+"' ");
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

        PreparedStatement pps = con.prepareStatement("DELETE FROM tablaregistros WHERE Id =' "+id+" ' ");
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

    public static void deleteFinancialSpace(String id) throws SQLException {

        PreparedStatement pps = con.prepareStatement("DELETE FROM tablaEspaciosfinancieros WHERE Id =' "+id+" ' ");
        pps.executeUpdate();
    }
    public static void addFinancialSpace(){
        PreparedStatement consulta;
        FinancialSpace financialSpace = new FinancialSpace();
        try {
            consulta = SQLconection.con.prepareStatement("INSERT INTO "+ "tablaEspaciosfinancieros" +
                    "(Id, Nombre, Grupo) VALUES(?,?,?)");

            consulta.setString(1, String.valueOf(financialSpace.getId()));
            consulta.setString(2, financialSpace.getName());
            consulta.setInt(3, Integer.parseInt(financialSpace.getGroup()));



            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente");

        } catch (SQLException ex) {
            Logger.getLogger(SQLconection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<FinancialSpace> getAllFinancialSpacesBD() throws SQLException {

        ArrayList<FinancialSpace> allForms = new ArrayList<>(1);

        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablaEspaiosfinancieros");
        ResultSet result = statement.executeQuery();

        while (result.next()) {


            String Id = result.getString("Id");
            String Nombre = result.getString("Nombre");
            String Grupo = result.getString("Grupo");

            FinancialSpace financialSpace =new FinancialSpace();

            financialSpace.setId(Integer.parseInt(Id));
            financialSpace.setName(Nombre);
            financialSpace.setGroup(Grupo);

            allForms.add(financialSpace);
        }
        return allForms;
    }

    public static void modifyFinancialSpace(String id, String NuevoNombre, String NuevoGrupo) throws SQLException {
        SQLconection.SqlConection();

        PreparedStatement pps = con.prepareStatement("UPDATE"+ "tablaEspaciosfinancieros"+" SET Nombre= ' "+NuevoNombre+" ' ,Grupo= ' "+NuevoGrupo+" ' WHERE Id ="+id);

        pps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos actualizados");
    }
    public static ArrayList<Form> ArrayFormsDB;
    public static ArrayList<Assets> ArrayAssetsDB;
    public static ArrayList<Pasives> ArrayPasivesDB;

    public static ArrayList<Inventory> ArrayInventoryDB;


    public static ArrayList<FinancialSpace> ArrayFinancialSpaceDB;


    public static void getFormsFromDB() throws SQLException {
        ArrayFormsDB = getallFormsDB();
        ArrayAssetsDB = getallAssetsDB();
        ArrayPasivesDB = getallPasivesDB();
        ArrayInventoryDB = getallInventoryFromDB();


        ArrayFinancialSpaceDB = getAllFinancialSpacesBD();

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

    public static ArrayList<FinancialSpace> getArrayFinancialSpaceDB() {
        return ArrayFinancialSpaceDB;
    }

}
