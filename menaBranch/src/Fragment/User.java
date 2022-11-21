package Fragment;

import Fragment.Spaces.FinancialSpace;
import Fragment.Spaces.Manager;

public class User {
    Stats stats = new Stats();
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



















































    private static float netWorth = 0;

    public static void setNetWorth(float netWorth) {
        User.netWorth = netWorth;
    }
    public static float getNetWorth() {
        return netWorth;
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
