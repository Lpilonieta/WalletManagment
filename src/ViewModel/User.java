package ViewModel;

import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;

public class User extends Stats {
    private boolean mustDeclareRentTax = false;
    private boolean mustIvaTax = false;
    private float totalExpenses = 0;
    private float totalRevenues =0;
    HashMap<String, Float>totalExpensesByMotive = new HashMap<>();
    HashMap<String, Float>totalRenenuesesByMotive = new HashMap<>();
    private Pasives nearestPasivePayment;
    public User()   {
        mustDeclareRentTax = checkRentTaxRequirements();
        mustIvaTax = checkIvaTaxRequirements();
        nearestPasivePayment = Pasives.checkNearPasivePayment();
        calcStats();
    }

    private boolean checkIvaTaxRequirements() {
    if ((getTotalIvaRevenue() >= Constants.MAX_IVA_REVUNES) || getTotalIvaExpenses()>=Constants.MAX_IVA_EXPENSES)return true;
    return false;
    }

    private boolean checkRentTaxRequirements() {
    if (
            getBruteRevenues() >= Constants.MAX_BRUTE_REVENUES ||
                    getBruteWorth() >= Constants.MAX_BRUTE_WORTH ||
                    getTotalExpenses() >= Constants.MAX_EXPENSES ||
                    getTotalRevenue() >= Constants.MAX_BRUTE_REVENUES ||
                    mustIvaTax
    )return true;
    return false;
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

    public static void ChangeFinancialSpace(int idFinancialSpace) throws SQLException {
        for (FinancialSpace finacialSpace :
                Manager.getAllFinancialSpaces()) {
            if (idFinancialSpace == finacialSpace.getId()){
                Manager.switchFinancialSpaceByID(finacialSpace);
                break;
            }
        }
        Assets.updateTotalAssetsFromDB();
        Assets.updateTypeValues();
        Assets.updateCurrentValue();
        Assets.updateNoCurrentValue();

        Pasives.updateTotalPasives();
        Pasives.updateTypeValues();
    }
}
