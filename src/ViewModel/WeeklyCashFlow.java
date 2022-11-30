package ViewModel;

import java.sql.SQLException;
import java.util.HashMap;

public class WeeklyCashFlow {

    HashMap <String, DailyCashFlow> WeeklyCashFlow=new HashMap<>(7);
    DailyCashFlow lunes, martes, miercoles, jueves, viernes, sabado, domingo;
    String fechaInicial;
    public WeeklyCashFlow(String fechaInicial) throws SQLException {
        this.fechaInicial = fechaInicial;
        this.lunes = new DailyCashFlow(fechaInicial);
        this.martes = new DailyCashFlow(sumarDiasAfecha(fechaInicial,1));
        this.miercoles = new DailyCashFlow(sumarDiasAfecha(fechaInicial,2));
        this.jueves = new DailyCashFlow(sumarDiasAfecha(fechaInicial,4));
        this.viernes = new DailyCashFlow(sumarDiasAfecha(fechaInicial,4));
        this.sabado = new DailyCashFlow(sumarDiasAfecha(fechaInicial,5));
        this.domingo = new DailyCashFlow(sumarDiasAfecha(fechaInicial,6));
        WeeklyCashFlow.put("Lunes"      , lunes);
        WeeklyCashFlow.put("Martes"     ,    martes);
        WeeklyCashFlow.put("Miércoles"  ,miercoles);
        WeeklyCashFlow.put("Jueves"     ,jueves);
        WeeklyCashFlow.put("Viernes"    ,viernes);
        WeeklyCashFlow.put("Sábado"     ,sabado);
        WeeklyCashFlow.put("Domingo"    ,domingo);
        printCashFlow();



    }

    private void printCashFlow() {
        String[] keys = {  "Lunes",
                           "Martes",
                           "Miércoles",
                           "Jueves",
                           "Viernes",
                           "Sábado",
                           "Domingo"
        };
        for (String key :
                keys) {
            if (WeeklyCashFlow.get(key).)
        }
    }

    private String sumarDiasAfecha(String fechaInicial, int numDiasAsumar) {

        String[] splitFecha =fechaInicial.split("-");
        int SS = Integer.valueOf(splitFecha[0]);
        int DD = Integer.valueOf(splitFecha[1]);
        int MM = Integer.valueOf(splitFecha[2]);
        int AA = Integer.valueOf(splitFecha[3]);
        while (numDiasAsumar > 0) {
            if (MM == 12 && DD == 31) {
                AA += 1;
                MM = 1;
                DD = 1;
            } else if (MM == 2 && DD == 28) {
                if (!(AA % 4 == 0)) {
                    MM+=1;
                    DD = 1;
                } else DD += 1;
            } else if (MM == 2 && DD == 29) {
                MM+=1;
                DD = 1;
            } else if (DD == 30 && (MM == 4 || MM == 6 || MM == 9 || MM == 11)) {
                MM+=1;
                DD = 1;
            } else if (DD == 31 && (MM == 1 || MM == 3 || MM == 5 || MM == 7 || MM == 8 || MM == 10)) {
                DD = 1;
                MM +=1;
            }else {
                DD +=1;
            }
            SS = (SS+8)%7;
            numDiasAsumar -= 1;

        }return String.valueOf(SS+"-"+DD+"-"+MM+"-"+AA);
    }
}
