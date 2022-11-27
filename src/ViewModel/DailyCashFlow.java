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

    ArrayList DailyCashFlow, ExpensesForms, RevenuesForms;
    String Fecha, FechaDiaAnterior;
    String SaldoInicial, SaldoFinal;

    public ArrayList<Form> DailyRevenuesForms(){
        ArrayList<Form> revenuesForms = new ArrayList<>();
        for (Form form : new GeneralRegistry().getAllRevenuesForms()
        ) {
            String[] idForm = form.getId().split("-");
            if ((Fecha == form.getRegistryDate())) {
                revenuesForms.add(form);
            }
        }
        this.RevenuesForms=revenuesForms;
        return RevenuesForms;
    }
    public ArrayList<Form> DailyExpensesForms(){
        ArrayList<Form> expensesForms = new ArrayList<>();
        for (Form form : new GeneralRegistry().getAllExpensesForms())
        {
            String[] idForm = form.getId().split("-");
            if ((Fecha == form.getRegistryDate())){
                expensesForms.add(form);
            }
        }
        this.ExpensesForms=expensesForms;
        return ExpensesForms;
    }

    public static String SaldoInicial(String fechaDiaAnterior) throws SQLException {

        SQLconection.SqlConection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM tablacashflow WHERE Fecha ='"+fecha+"' ");

        ResultSet result = statement.executeQuery();

        ArrayList<String> Saldos = new ArrayList<>();

        while (result.next()) {
            Saldos.add(result.getString("Saldo"));
        }
        //String SaldoInicial = Saldos.get(Saldos.size()-1);
        System.out.println(Saldos);
        //System.out.println(SaldoInicial);
        String SaldoInicial = "a";
        return SaldoInicial = "a";
    }
    public ArrayList<String> CreateDailyCashFlow(String SaldoInicial){
        DailyCashFlow.add(SaldoInicial);

        for (Object form : RevenuesForms
        ) {
            String value = String.valueOf(form.getPurchaseValue());
            DailyCashFlow.add(value);
        }
        for (Object form : ExpensesForms
        ) {
            String value = "-" + String.valueOf(form.getPurchaseValue());
            DailyCashFlow.add(value);
        }
        return DailyCashFlow;
    }
    public String DiaAnteriorFecha(){
        String[] FechaSplit = Fecha.split("-");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");

        int DiaAnteriorSemana = (Integer.valueOf(FechaSplit[0]) + 6) % 7;
        String fechaAnterior = FechaSplit[1] + "-" + FechaSplit[2] + "-" + FechaSplit[3];

        String FechaAnterior = dateFormat.format(fechaAnterior);

    }

    public DailyCashFlow(String fecha){

        this.Fecha=fecha;
        this.FechaDiaAnterior = DiaAnteriorFecha();
        this.SaldoInicial = SaldoInicial(FechaDiaAnterior);
        this.DailyCashFlow = CreateCashFlowArray(String SaldoInicial);

        }

    }

