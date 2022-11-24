package ViewModel;

public interface Liquidity {


     static float calculateRazonCorriente(){
        float razonCorriente = Assets.getCurrentAssetsValue() / Pasives.getCurrentPasiveValue();
        return razonCorriente;
    }


     static float calculatePruebaAcida(){
        float pruebaAcida = Assets.getCurrentAssetsValue(); //TODO: falta -Value of inventory.
        return pruebaAcida;
    }



     static float calculateFondoDeManiobra() {
        float fondoDeManiobra = Assets.getCurrentAssetsValue() - Pasives.getCurrentPasiveValue();

        return fondoDeManiobra;
    }


}
