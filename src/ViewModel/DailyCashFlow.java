package ViewModel;

import Model.GeneralRegistry;

import java.util.ArrayList;


public class DailyCashFlow extends ArrayList {

    ArrayList DailyCashFlow, ExpensesForms, RevenuesForms;

    public ArrayList<Form> DailyRevenuesForms(String fecha){
        ArrayList<Form> RevenueForms;
        for (Form form : new GeneralRegistry().getAllRevenuesForms()
        ) {
            String[] idForm = form.getId().split("-");
            if (("a" == fecha)) {//hacer getDate()
                RevenuesForms.add(form);
            }
        }
        return RevenuesForms;
    }
    public ArrayList<Form> DailyExpensesForms(String fecha){
        ArrayList<Form> ExpensesForms = new ArrayList<>();
        for (Form form : new GeneralRegistry().getAllExpensesForms())
        {
            String[] idForm = form.getId().split("-");
            if (("a" == fecha)){//hacer getDate()
                ExpensesForms.add(form);
            }
        }
        return ExpensesForms;
    }
    public DailyCashFlow(String fecha, int SaldoInicial){
        ArrayList DailyCashFlow = new ArrayList<>();

        DailyCashFlow.add(SaldoInicial);

        for (Form form : DailyRevenuesForms(fecha)
        ) {
                String value = String.valueOf(form.getPurchaseValue());
                DailyCashFlow.add(value);
            }
        for (Form form : DailyExpensesForms(fecha)
        ) {
            String value = "-" + String.valueOf(form.getPurchaseValue());
            DailyCashFlow.add(value);
        }
        }

    }

