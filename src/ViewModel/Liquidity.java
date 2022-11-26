package ViewModel;

public interface Liquidity {


     static float calculateRazonCorriente(){
        float razonCorriente = Constants.NONE;
        if (Pasives.getCurrentPasiveValue()!=0) razonCorriente = Assets.getCurrentAssetsValue() / Pasives.getCurrentPasiveValue();
        return razonCorriente;
    }


     static float calculatePruebaAcida(){
         float acidTets = Constants.NONE;
         if (Assets.getCurrentAssetsValue() != Constants.NONE && Inventory.getInventoryValue() != Constants.NONE)
             acidTets = Assets.getCurrentAssetsValue() - Inventory.getInventoryValue();
         return acidTets;
     }



     static float calculateFondoDeManiobra() {
        float fondoDeManiobra = Constants.NONE;
        if (Assets.getCurrentAssetsValue()!=Constants.NONE && Pasives.getCurrentPasiveValue() != Constants.NONE) {
            fondoDeManiobra = Assets.getCurrentAssetsValue() - Pasives.getCurrentPasiveValue();
        }
         return fondoDeManiobra;
     }


}
