package Fragment;

public class Solvency {
    private static float endeudamientoTotal = -1;
    private static float endeudamientoCP = -1;
    private static float endeudamientoLP = -1;
    private static float apalancamientoTotal = -1;

    public static float getEndeudamientoTotal() {
        return endeudamientoTotal;
    }
    public static void calcEndeudamientoTotal(){
        endeudamientoTotal=Pasives.getTotalPasiveValue()/Assets.getTotalAssetsValue();
    }


    public static float getEndeudamientoCP() {
        return endeudamientoCP;
    }
    public static void calcEndeudamientoCP(){
        endeudamientoCP=Pasives.getCurrentPasiveValue()/User.getNetWorth();
    }
    public static float getEndeudamientoLP() {
        return endeudamientoLP;
    }

    public static void calcEndeudamientoLP() {
        endeudamientoLP = Pasives.getNoCurrentPasiveValue() / User.getNetWorth();
    }
    public static float getApalancamientoTotal() {
        return apalancamientoTotal;
        }
    public static void calcApalancamientoTotal(){
        apalancamientoTotal=Pasives.getNoCurrentPasiveValue()/User.getNetWorth();
    }

}
