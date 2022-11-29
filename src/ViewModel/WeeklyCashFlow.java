package ViewModel;

import ViewModel.DailyCashFlow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class WeeklyCashFlow {
    public WeeklyCashFlow(String fecha) throws SQLException {

        HashMap <String, ArrayList> WeeklyCashFlow=new HashMap<String, ArrayList>();

        DailyCashFlow dailyCashFlow = new DailyCashFlow(fecha);// verificar saldo inicial
        //WeeklyCashFlow.put(fecha, dailyCashFlow);



    }
}
