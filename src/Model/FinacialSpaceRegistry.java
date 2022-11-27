package Model;

import ViewModel.Assets;
import ViewModel.Form;
import ViewModel.Inventory;
import ViewModel.Pasives;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FinacialSpaceRegistry {
    default ArrayList<Form> getAllForms() throws SQLException {
        return new ArrayList<>(1);
    }
    default ArrayList<Assets> getAllAssets(){
        return new ArrayList<>(1);
    }
    default ArrayList<Pasives> getAllPasives(){
        return new ArrayList<>(1);
    }
    default ArrayList<Inventory> getAllInventory(){ return new ArrayList<>(1);}
    default ArrayList<Form> getAllExpensesForms(){return new ArrayList<>(1);}
    default ArrayList<Form> getAllRevenuesForms(){return new ArrayList<>(1);}
}

