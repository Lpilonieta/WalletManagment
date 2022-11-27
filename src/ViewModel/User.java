package ViewModel;

import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import javax.swing.*;

public class User extends Stats {
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

    public void createNewRegistry(Motive motive,Form form){
        if (motive.getFormType()==Constants.RENEUE_FORM_TYPE){
            if (motive.isPasive()){
                //registrar nuevo pasivo
            } else if (motive.isAsset()) {
                if (motive.isInventory()){
                    //seleccionar item del inventario
                    //añadir # de ventas al item seleccionado
                    //reducir el stock del item seleccionado
                }else {
                    //seleccionar activo existente
                    //eliminar activo del registo de activos
                }
            }else {
                // guardar registro con la clase form
            }
        }else {
            if (motive.isPasive()){
                //seleccionar pasivo existente
                //disminuir valor pagado a la deuda
                //si la deuda llega a 0, borrarla del registro
            } else if (motive.isAsset()) {
                if (motive.isInventory()){
                    if (motive.isNewInventory()) {
                    // registrar un nuevo item de inventario
                    }else {
                        //seleccionar item del inventario
                        //sumar al stock del item seleccionado
                    }
                }
            }else {
                //registrar egreso con clase form
            }
        }
    }
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
