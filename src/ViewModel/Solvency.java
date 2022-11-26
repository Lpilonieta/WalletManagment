package ViewModel;

public interface Solvency {


     static float calcEndeudamientoTotal(){
        float endeudamientoTotal = Constants.NONE;
        if (Pasives.getTotalPasiveValue() != Constants.NONE && Assets.getTotalAssetsValue()!= Constants.NONE)
            endeudamientoTotal = Pasives.getTotalPasiveValue() / Assets.getTotalAssetsValue();
        return endeudamientoTotal;
    }



     static float calcEndeudamientoCP(){
        float endeudamientoCP = Constants.NONE;
        if (Pasives.getCurrentPasiveValue() != Constants.NONE && User.getNetWorth() != Constants.NONE);
        endeudamientoCP =Pasives.getCurrentPasiveValue()/User.getNetWorth();
        return endeudamientoCP;
    }

     static float calcEndeudamientoLP() {
        float endeudamientoLP = Constants.NONE;
        if (Pasives.getNoCurrentPasiveValue()!= Constants.NONE && User.getNetWorth() != Constants.NONE)
            endeudamientoLP = Pasives.getNoCurrentPasiveValue() / User.getNetWorth();
        return endeudamientoLP;
    }

     static float calcApalancamientoTotal(){
        float apalancamientoTotal = Constants.NONE;
        if (Pasives.getNoCurrentPasiveValue() != Constants.NONE && User.getNetWorth()!= Constants.NONE)
            apalancamientoTotal = Pasives.getNoCurrentPasiveValue() / User.getNetWorth();
        return apalancamientoTotal;
    }

}
