package ViewModel;

public interface Rentability {

     default float calcMargenDeUtilidadBruta() {

        float margenDeUtilidadBruta = 0;        //TODO:  Utilidad Bruta / (ventas Netas*100)
         if (Inventory.calcNetSales() !=Constants.NONE && Inventory.calcBruteUtility() != Constants.NONE){
             margenDeUtilidadBruta += Inventory.calcBruteUtility() / (Inventory.calcNetSales()*100);
         }
        return margenDeUtilidadBruta == 0 ? Constants.NONE : margenDeUtilidadBruta;
    }

     default float calcRentabilidadSobrePatrimonio() {
        float rentabilidadSobrePatrimonio=0;    //TODO: Utiliad Neta / Patrimonio Neto
        if (Inventory.calcNetUtility() != Constants.NONE && User.getNetWorth() != Constants.NONE){
            rentabilidadSobrePatrimonio = Inventory.calcNetUtility()/User.getNetWorth();
        }
        return rentabilidadSobrePatrimonio;
    }
     default float calcRentabilidadSobreActivos() {
        float rentabilidadSobreActivos=0;   //TODO: Utiliad Neta / Valor total activos
         if (Inventory.calcNetUtility() !=0 && Assets.getTotalAssetsValue() !=Constants.NONE){
             rentabilidadSobreActivos = Inventory.calcNetUtility()/Assets.getTotalAssetsValue();
         }
        return rentabilidadSobreActivos == 0 ? Constants.NONE : rentabilidadSobreActivos;
    }

     default float calcRentabilidadSobreVentas() {
        float rentabilidadSobreVentas = 0;  // TODO: Utiliad Neta / (ventas Netas*100)
         if (Inventory.calcNetUtility() !=Constants.NONE && Inventory.calcNetSales() != Constants.NONE){
             rentabilidadSobreVentas = Inventory.calcNetUtility() / (Inventory.calcNetSales()*100);
         }
        return rentabilidadSobreVentas == 0 ? Constants.NONE : rentabilidadSobreVentas;
    }

}
