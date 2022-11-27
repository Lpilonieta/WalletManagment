package ViewModel;

public interface Solvency {


     default float calcEndeudamientoTotal(){
        float endeudamientoTotal = 0;
        if (Pasives.getTotalPasiveValue() != Constants.NONE && Assets.getTotalAssetsValue()!= Constants.NONE)
            endeudamientoTotal = Pasives.getTotalPasiveValue() / Assets.getTotalAssetsValue();
        return endeudamientoTotal == 0 ? Constants.NONE : endeudamientoTotal;
    }



     default float calcEndeudamientoCP(){
        float endeudamientoCP = 0;
        if (Pasives.getCurrentPasiveValue() != Constants.NONE && User.getNetWorth() != Constants.NONE)
            endeudamientoCP =Pasives.getCurrentPasiveValue()/User.getNetWorth();
        return endeudamientoCP == 0 ? Constants.NONE : endeudamientoCP;
    }

     default float calcEndeudamientoLP() {
        float endeudamientoLP = 0;
        if (Pasives.getNoCurrentPasiveValue()!= Constants.NONE && User.getNetWorth() != Constants.NONE)
            endeudamientoLP = Pasives.getNoCurrentPasiveValue() / User.getNetWorth();
        return endeudamientoLP == 0 ? Constants.NONE : endeudamientoLP ;
    }

     default float calcApalancamientoTotal(){
        float apalancamientoTotal = 0;
        if (Pasives.getNoCurrentPasiveValue() != Constants.NONE && User.getNetWorth()!= Constants.NONE)
            apalancamientoTotal = Pasives.getNoCurrentPasiveValue() / User.getNetWorth();
        return apalancamientoTotal == 0 ? Constants.NONE : apalancamientoTotal;
    }

}
