package ViewModel;

import Model.GeneralRegistry;
import Model.SQLconection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static Model.SQLconection.con;


public class DailyCashFlow extends ArrayList {

    private ArrayList <Form> ExpensesForms;
    private ArrayList <Form> RevenuesForms;
    private String Fecha, FechaDiaAnterior;
    private String SaldoInicial, SaldoFinal;

    public DailyCashFlow(String saldoInicial, String fecha) {
        this.Fecha=fecha;
        SaldoInicial = saldoInicial;
        DailyRevenuesForms();
        DailyExpensesForms();
        SaldoFinal = calcSaldoFinal();
    }

    public ArrayList<Form> getExpensesForms() {
        return ExpensesForms;
    }

    public ArrayList<Form> getRevenuesForms() {
        return RevenuesForms;
    }
    public ArrayList<String>getExpensesValues(){
        ArrayList<String> expensesValues = new ArrayList<>();

        for (Form form :
                ExpensesForms) {
            expensesValues.add(String.valueOf(form.getPurchaseValue()));
        }if (expensesValues.isEmpty())expensesValues.add("0");
        return expensesValues;
    }
    public ArrayList<String>getRevenueValues(){
        ArrayList<String> renevueValues = new ArrayList<>();

        for (Form form :
                RevenuesForms) {
            renevueValues.add(String.valueOf(form.getPurchaseValue()));
        }if (renevueValues.isEmpty())renevueValues.add("0");
        return renevueValues;
    }

    public String getFecha() {
        return Fecha;
    }

    public String getSaldoInicial() {
        return SaldoInicial;
    }

    public String getSaldoFinal() {
        return SaldoFinal;
    }

    public void DailyRevenuesForms(){

        ArrayList<Form> revenuesForms = new ArrayList<>();
        for (Form form:new GeneralRegistry().getAllRevenuesForms()
             ) {
            if (form.getRegistryDate().equals(Fecha)){
                revenuesForms.add(form);
            }
        }
        RevenuesForms=revenuesForms;
    }
    public void DailyExpensesForms(){
        ArrayList<Form> expensesForms = new ArrayList<>();
        for (Form form: new GeneralRegistry().getAllExpensesForms()
             ) {
            if (form.getRegistryDate().equals(Fecha))expensesForms.add(form);
        }
        ExpensesForms = expensesForms;
    }



    public String DiaAnteriorFecha(){
        String[] FechaSplit = Fecha.split("-");
        int SS = Integer.valueOf(FechaSplit[0]);
        int DD = Integer.valueOf(FechaSplit[1]);
        int MM = Integer.valueOf(FechaSplit[2]);
        int AA = Integer.valueOf(FechaSplit[3]);
        String FechaAnterior;
        if(DD !=1){
            DD -=1;
        }else {
            if (MM == 1){
                DD = 31;
                MM = 12;
            } else if (MM == 3) {
                MM-=1;
                DD = (AA%4 ==0) ? 29 : 28;

            } else if (MM == 8) {
                MM-=1;
                DD = 31;

            } else if (MM == 5 || MM == 7 || MM == 10 || MM == 12) {
                MM -=1;
                DD = 30;
            }else {
                MM-=1;
                DD = 31;
            }
        }
        SS = (SS+6)%7;
        return FechaAnterior = String.valueOf(SS+"-"+DD+"-"+MM+"-"+AA);

    }

    private String calcSaldoFinal(){
        float totalDailyRevenue = Float.parseFloat(getSaldoInicial());
        float totalDailyExpenses = 0;
        for (Form form:ExpensesForms
             ) {
            totalDailyExpenses+=form.getPurchaseValue();
        }
        for (Form form:RevenuesForms
             ) {
            totalDailyRevenue+= form.getPurchaseValue();
        }return String.valueOf(totalDailyRevenue-totalDailyExpenses);
    }


    public DailyCashFlow(String fecha) throws SQLException {

        this.Fecha=fecha;
        FechaDiaAnterior = DiaAnteriorFecha();
        SaldoInicial = SaldoInicial(FechaDiaAnterior);
        DailyRevenuesForms();
        DailyExpensesForms();
        SaldoFinal = calcSaldoFinal();
    }

    private String SaldoInicial(String fechaDiaAnterior) {
        ArrayList<String>saldo=new ArrayList<>(2);
        try {

            SQLconection.SqlConection();

            PreparedStatement statement = con.prepareStatement("SELECT * FROM tablacashflow WHERE Fecha='"+fechaDiaAnterior+"'");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                saldo.clear();
                saldo.add(result.getString("Saldo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return saldo.isEmpty()? "0":saldo.get(0);
    }



}

