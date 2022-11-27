package Model;

import ViewModel.Assets;
import ViewModel.Form;
import ViewModel.Inventory;
import ViewModel.Pasives;

import java.util.ArrayList;

public interface FinacialSpaceRegistry {
    default ArrayList<Form> getAllForms(){
        return new ArrayList<>(1);
    }
    default ArrayList<Assets> getAllAssets(){
        return new ArrayList<>(1);
    }
    default ArrayList<Pasives> getAllPasives(){
        return new ArrayList<>(1);
    }
    default ArrayList<Inventory> getAllInventory(){
        return new ArrayList<>(1);
    }
}