package ViewModel;

import ViewModel.DailyCashFlow;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class WeeklyCashFlow {
    private DailyCashFlow Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo;

    private HashMap <String, DailyCashFlow> WeeklyCashFlow=new HashMap<>();

    public String FechaDiaSiguiente(String fecha){
        String[] FechaSplit = fecha.split("-");

        int DiaSemana = (Integer.parseInt(FechaSplit[0])+7)/8;

        String input = FechaSplit[3] +" "+ FechaSplit[2]+" "+FechaSplit[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy MM dd" );

        LocalDate localDate = formatter.parse ( input , LocalDate :: from );
        LocalDate Wek =localDate.plusDays(1);

        String[] fechaSplitDiaSiguiente = String.valueOf(Wek).split("-");

        String fechaDiaSiguiente = DiaSemana+"-"+fechaSplitDiaSiguiente[2]+"-"+fechaSplitDiaSiguiente[1]+"-"+fechaSplitDiaSiguiente[0];
        return fechaDiaSiguiente;
    }

    public WeeklyCashFlow(String fecha) throws SQLException {

        DailyCashFlow Lunes = new DailyCashFlow(fecha);
        WeeklyCashFlow.put(fecha, Lunes);


        for(int i=0; i<6;i++){
            fecha = FechaDiaSiguiente(fecha);
            DailyCashFlow dia = new DailyCashFlow(fecha);
            WeeklyCashFlow.put(fecha, dia);
        }




    }
}
