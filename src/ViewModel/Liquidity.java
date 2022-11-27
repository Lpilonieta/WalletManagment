package ViewModel;

public interface Liquidity {


     default float calculateRazonCorriente(){
        float razonCorriente = 0;
        if (Pasives.getCurrentPasiveValue()!= Constants.NONE && Assets.getCurrentAssetsValue() != Constants.NONE) razonCorriente = Assets.getCurrentAssetsValue() / Pasives.getCurrentPasiveValue();
        return razonCorriente == 0 ? Constants.NONE :razonCorriente;
    }


     default float calculatePruebaAcida(){
         float acidTets = 0;
         if (Assets.getCurrentAssetsValue() != Constants.NONE && Inventory.getInventoryValue() != Constants.NONE)
             acidTets = Assets.getCurrentAssetsValue() - Inventory.getInventoryValue();
         return acidTets == 0 ? Constants.NONE : acidTets;
     }



     default float calculateFondoDeManiobra() {
        float fondoDeManiobra = 0;
        if (Assets.getCurrentAssetsValue()!=Constants.NONE && Pasives.getCurrentPasiveValue() != Constants.NONE) {
            fondoDeManiobra = Assets.getCurrentAssetsValue() - Pasives.getCurrentPasiveValue();
        }
         return fondoDeManiobra == 0 ? Constants.NONE : fondoDeManiobra;
     }


}
