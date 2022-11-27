package ViewModel;

import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import javax.swing.*;

public class User extends Stats {
    /*TODO: El usuario puede
    crear nuevos espacios financieros---check---
    eliminar espacios financieros ---check---
    seleccionar un espacio financiero:
        calcular indices financieros a partir de los registros que pertenecen a este espacio financiero ** hacer esto en stats**
          solo si el espacio financiero es distinto de area personal calcula los indices de inventario y rentabilidad ** hacer esto en stats**
            indicar si no se puede calcular ** hacer esto en stats**
            indicar que significa el indice financiero ** hacer esto en consejos financieros**
        hacer registros
        añadir items al inventario del espacio financiero
        registrar las ventas de uno de los productos del invnetario
            actualizar el stock
        ver cuanto impuesto por ventas tiene que pagar

    ATT: esDeclarante? ** hacer esto en stats**
        solo si cumple con los requisitos
    ver el flujo de caja.
    */



    public void newFinancianSpace(String name, String group){
        /*
        *       Objetivos de éste método
        * 1. crear el espacio financiero
        * 2. guardarlo en el registro de espacios financieros
        * 3. cambiar el espacio financiero actual a el recién creado
        *
        */
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
