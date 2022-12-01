package ViewModel;

import Model.SQLconection;
import ViewModel.Spaces.Manager;

import java.sql.Array;
import java.sql.SQLException;

public class MainCashFlow {
    public static void main(String[] args) throws SQLException {
        SQLconection.SqlConection();

        Manager.update();
     WeeklyCashFlow cashFlow = new WeeklyCashFlow("4-1-12-2022");
     cashFlow.printCashFlow();


    }
}
