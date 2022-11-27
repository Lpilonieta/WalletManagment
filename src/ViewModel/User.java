package ViewModel;

import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import javax.swing.*;
import java.util.HashMap;

public class User extends Stats {
    private boolean mustDeclareRentTax = false;
    private boolean mustIvaTax = false;
    private float totalExpenses = 0;
    private float totalRevenues =0;
    HashMap<String, Float>totalExpensesByMotive = new HashMap<>();
    HashMap<String, Float>totalRenenuesesByMotive = new HashMap<>();
    private Pasives nearestPasivePayment;
    public User(){
        mustDeclareRentTax = checkRentTaxRequirements();
        mustIvaTax = checkIvaTaxRequirements();
        nearestPasivePayment = Pasive.checkNearPasivePayment();
        calcStats();

    }

    private boolean checkRentTaxRequirements() {

    }

    public void newFinancianSpace(String name, String group){
        FinancialSpace newFinancialSpace = new FinancialSpace(name, group);
        Manager.save(newFinancialSpace);
        Manager.switchFinancialSpace(newFinancialSpace);
    }
    public void openFinancialSpace(FinancialSpace financialSpace){

        Manager.switchFinancialSpace(financialSpace);
    }

    public void deleteFinancialSpace(FinancialSpace financialSpace){Manager.deleteFinancialSpace(financialSpace);}
    public void deleteFinancialSpaceByID (int id ){Manager.deleteFinancialSpaceByID(id);}

    public static void ChangeFinancialSpace(int idFinancialSpace){
        Manager.switchFinancialSpaceByID(idFinancialSpace);

        Assets.updateTotalAssetsFromDB();
        Assets.updateTypeValues();
        Assets.updateCurrentValue();
        Assets.updateNoCurrentValue();

        Pasives.updateTotalPasives();
        Pasives.updateTypeValues();
    }
}
