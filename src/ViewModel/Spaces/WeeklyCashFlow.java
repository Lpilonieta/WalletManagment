package ViewModel.Spaces;

import ViewModel.DailyCashFlow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class WeeklyCashFlow {
    public WeeklyCashFlow(String fecha){

        HashMap <String, ArrayList> WeeklyCashFlow=new HashMap<String, ArrayList>();

        DailyCashFlow dailyCashFlow = new DailyCashFlow(fecha, 0);// verificar saldo inicial
        WeeklyCashFlow.put(fecha, dailyCashFlow);

    }
}
