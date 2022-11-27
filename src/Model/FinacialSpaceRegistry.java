package Model;

import ViewModel.Assets;
import ViewModel.Form;
import ViewModel.Inventory;
import ViewModel.Pasives;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FinacialSpaceRegistry {
    ArrayList<Form> getAllForms();
    ArrayList<Assets> getAllAssets();
    ArrayList<Pasives> getAllPasives();
    ArrayList<Inventory> getAllInventory();
    ArrayList<Form> getAllExpensesForms();
    ArrayList<Form> getAllRevenuesForms();
}

