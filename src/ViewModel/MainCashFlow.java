package ViewModel;

import Model.SQLconection;

import java.sql.Array;
import java.sql.SQLException;

public class MainCashFlow {
    public static void main(String[] args) throws SQLException {
     WeeklyCashFlow cashFlow = new WeeklyCashFlow("0-20-11-2022");
     cashFlow.printCashFlow();


    }
}
