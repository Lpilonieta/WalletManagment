package ViewModel;

import Model.GeneralRegistry;
import Model.SQLconection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static Model.SQLconection.con;


public class DailyCashFlow extends ArrayList {

    ArrayList <Form> ExpensesForms;
    ArrayList <Form> RevenuesForms;
    String Fecha, FechaDiaAnterior;
    String SaldoInicial, SaldoFinal;


    public void DailyRevenuesForms(){

        ArrayList<Form> revenuesForms = new ArrayList<>();
        for (Form form:new GeneralRegistry().getAllRevenuesForms()
             ) {
            if (form.getRegistryDate() == Fecha)revenuesForms.add(form);
        }
        RevenuesForms=revenuesForms;
    }
    public void DailyExpensesForms(){
        ArrayList<Form> expensesForms = new ArrayList<>();
        for (Form form: new GeneralRegistry().getAllExpensesForms()
             ) {
            if (form.getRegistryDate() == Fecha)expensesForms.add(form);
        }
        ExpensesForms = expensesForms;
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
        float totalDailyRevenue = 0;
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
        System.out.println(FechaDiaAnterior);
        System.out.println(Fecha);

        }

}

