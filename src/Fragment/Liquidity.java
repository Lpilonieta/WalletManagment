package Fragment;

public class Liquidity {
    private static float fondoDeManiobra;
    private static float razonCorriente;
    private static float pruebaAcida;

    public float getRazonCorriente() {
        return razonCorriente;
    }

    public static void calculateRazonCorriente(){
        razonCorriente= Assets.getCurrentAssetsValue()/Pasives.getCurrentPasiveValue();
    }

    public static float getPruebaAcida() {
        return pruebaAcida;
    }
    public static void calculatePruebaAcidatt(){
        pruebaAcida=Assets.getCurrentAssetsValue(); //TODO: falta -Value of inventory.
    }

    public static float getFondoDeManiobra() {
        return fondoDeManiobra;
    }

    public static void calculateFondoDeManiobra() {
        fondoDeManiobra = Assets.getCurrentAssetsValue()-Pasives.getCurrentPasiveValue();
    }


}
