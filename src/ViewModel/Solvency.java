package ViewModel;

public interface Solvency {


     static float calcEndeudamientoTotal(){
        float endeudamientoTotal = Pasives.getTotalPasiveValue() / Assets.getTotalAssetsValue();
        return endeudamientoTotal;
    }



     static float calcEndeudamientoCP(){
        float endeudamientoCP=Pasives.getCurrentPasiveValue()/User.getNetWorth();
        return endeudamientoCP;
    }

     static float calcEndeudamientoLP() {
        float endeudamientoLP = Pasives.getNoCurrentPasiveValue() / User.getNetWorth();
        return endeudamientoLP;
    }

     static float calcApalancamientoTotal(){
        float apalancamientoTotal = Pasives.getNoCurrentPasiveValue() / User.getNetWorth();
        return apalancamientoTotal;
    }

}
