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
    private ArrayList <Form> totalForms;
    private String Fecha, FechaDiaAnterior;
    private String SaldoInicial, SaldoFinal;



    public DailyCashFlow(String saldoInicial, String fecha) {
        this.Fecha=fecha;
        SaldoInicial = saldoInicial;
        this.RevenuesForms =DailyRevenuesForms();
        this.ExpensesForms=DailyExpensesForms();
        this.totalForms = mergeForms();
        SaldoFinal = calcSaldoFinal();
    }

    private ArrayList<Form> mergeForms() {
        ArrayList<Form>totalforms = new ArrayList<>();
        for (Form form : RevenuesForms) {
            totalforms.add(form);
        }
        for (Form form : ExpensesForms) {
            totalforms.add(form);
        }return totalforms;
    }


    public ArrayList<Form> getExpensesForms() {
        return ExpensesForms;
    }
    public ArrayList<Form> getRevenuesForms() {
        return RevenuesForms;
    }
    public ArrayList<String>getTotalValues(){
        ArrayList<String> totalValues = new ArrayList<>();

        for (Form form :
                totalForms) {
            totalValues.add(String.valueOf(form.getPurchaseValue()));
        }if (totalValues.isEmpty())totalValues.add("0");
        return totalValues;
    }//TODO

    public String getFecha() {
        return Fecha;
    }

    public String getSaldoInicial() {
        return SaldoInicial;
    }

    public String getSaldoFinal() {
        return SaldoFinal;
    }

    public ArrayList<Form> DailyRevenuesForms(){

        ArrayList<Form> revenuesForms = new ArrayList<>();
        for (Form form:new GeneralRegistry().getAllRevenuesForms()
             ) {
            if (form.getRegistryDate().equals(Fecha)){
                revenuesForms.add(form);
            }
        }
        return revenuesForms;
    }
    public ArrayList<Form> DailyExpensesForms(){
        ArrayList<Form> expensesForms = new ArrayList<>();
        for (Form form: new GeneralRegistry().getAllExpensesForms()
             ) {
            if (form.getRegistryDate().equals(Fecha)){
                form.setPurchaseValue(-form.getPurchaseValue());
                expensesForms.add(form);
            }
        }
        return expensesForms;
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
        this.RevenuesForms = DailyRevenuesForms();
        this.ExpensesForms =DailyExpensesForms();
        this.totalForms = mergeForms();

        SaldoFinal = calcSaldoFinal();
    }

    private String SaldoInicial(String fechaDiaAnterior) {
        ArrayList<String>saldo=new ArrayList<>(2);
        try {

            SQLconection.SqlConection();

            PreparedStatement statement = con.prepareStatement("SELECT * FROM tablacashflow WHERE Fecha='"+fechaDiaAnterior+"'");
            ResultSet result = statement.executeQuery();

            while (result.next()){
                String[] idSplit = result.getString("Id").split("-");
                if (Integer.valueOf(idSplit[1])==Form.getLastID()-1){
                    saldo.clear();
                    saldo.add(result.getString("Saldo"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return saldo.isEmpty()? "0":saldo.get(0);
    }



}

