package Fragment;

import Model.PasivesRegistry;

import java.util.ArrayList;

public class Pasives {


    // Pasive Attributes.
    private String id;
    private String name;
    private String deudor;
    private String description;
    private int purchaseValue;
    private byte type;
    private float interestPercentage;
    private int interestType;
    private int numberOfInstallments;   //numero de cuotas;
    private float installmentValue;     //valor de pago por cuota.
    private byte periodicy;
    private int especificPeriodicy;

    //variables de interés para los calculas de las estadísticas

    private static ArrayList<Pasives> totalPasives = new ArrayList<>(1);
    private static float currentPasiveValue = 0;
    private static float noCurrentPasiveValue = 0;


    public Pasives() {
        this.id = "";
        this.deudor = "";
        this.name = "";
        this.description = "";
        this.purchaseValue = Constants.NONE;
        this.interestType = Constants.NONE;
        this.interestPercentage = Constants.NONE;
        this.numberOfInstallments = Constants.NONE;
        this.type = Constants.NONE;
        this.periodicy = Constants.NONE;
        this.especificPeriodicy = Constants.NONE;

    }

    public Pasives(String id,
                   String name,
                   String deudor,
                   String description,
                   int value,
                   int interestType,
                   int interestPercentage,
                   int numberOfInstallments,
                   byte type,
                   byte periodicy,
                   int especificPeriodicy
    )
    {
        this.id = id;
        this.name = name;
        this.deudor = deudor;
        this.description = description;
        this.purchaseValue = value;
        this.interestType = interestType;
        this.interestPercentage = interestPercentage;
        this.numberOfInstallments = numberOfInstallments;
        this.type = type;
        this.periodicy = periodicy;
        this.especificPeriodicy = especificPeriodicy;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeudor() {
        return deudor;
    }

    public void setDeudor(String deudor) {
        this.deudor = deudor;
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(int purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public int getInterestType() {
        return interestType;
    }

    public void setInterestType(int interestType) {
        this.interestType = interestType;
    }

    public float getInterestPercentage() {
        return interestPercentage;
    }

    public void setInterestPercentage(int interestPercentage) {
        this.interestPercentage = interestPercentage;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public float getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(float installmentValue) {
        this.installmentValue = installmentValue;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getPeriodicy() {
        return periodicy;
    }

    public void setPeriodicy(byte periodicy) {
        this.periodicy = periodicy;
    }

    public int getEspecificPeriodicy() {
        return especificPeriodicy;
    }

    public void setEspecificPeriodicy(int especificPeriodicy) {
        this.especificPeriodicy = especificPeriodicy;
    }

    public static ArrayList<Pasives> getTotalPasives() {
        return totalPasives;
    }

    public static void setTotalPasives(ArrayList<Pasives> totalPasives) {
        Pasives.totalPasives = totalPasives;
    }




    public static float getTotalPasiveValue(){
        updateTotalPasivesFromDB();
        //todo ajustar que en el valor de los pasivos se tenga en cuenta el interés
        float value;
        value=0;

        for (Pasives asset:totalPasives
        ) {
            value+= asset.getPurchaseValue();
        }

        return value;
    }

    private static void updateTotalPasivesFromDB() {
        totalPasives.clear();
        if (! PasivesRegistry.getPasivesRegistry().isEmpty()){
            for (Pasives pasive:PasivesRegistry.getPasivesRegistry().values()
                 ) {
                totalPasives.add(pasive);
            }
        }
    }


    private boolean isCurrentType() {
        if (this.getType()==Constants.CURRENT){
            return true;
        }else{
            return false;
        }
    }
    //todo: posible method para una interfaz
    private static void updateCurrentValueFromDB() {
        currentPasiveValue = 0;
        for (Pasives pasive: PasivesRegistry.getPasivesRegistry().values()
        ) {
            if (pasive.isCurrentType()) currentPasiveValue += pasive.getPurchaseValue();
        }
    }
    public static float getCurrentPasiveValue() {
        updateCurrentValueFromDB();
        return currentPasiveValue;
    }

    public static void setCurrentPasiveValue(float currentPasiveValue) {
        Pasives.currentPasiveValue = currentPasiveValue;
    }

    public static float getNoCurrentPasiveValue() {
        updateNoCurrentValueFromDB();
        return noCurrentPasiveValue;
    }
    //todo: posible method para una interfaz
    private static void updateNoCurrentValueFromDB() {
        noCurrentPasiveValue = 0;
        for (Pasives pasive: PasivesRegistry.getPasivesRegistry().values()
        ) {
            if (! pasive.isCurrentType()) noCurrentPasiveValue += pasive.getPurchaseValue();
        }
    }

    public static void setNoCurrentPasiveValue(float noCurrentPasiveValue) {
        Pasives.noCurrentPasiveValue = noCurrentPasiveValue;
    }

    //todo: posible method para una interfaz
    public static void updateTypeValues(Pasives[] totalPasives){
        Pasives.setNoCurrentPasiveValue(0);
        Pasives.setCurrentPasiveValue(0);
        for (Pasives pasive:totalPasives
        ) {
            if (pasive.isCurrentType()){
                Pasives.setCurrentPasiveValue(Pasives.currentPasiveValue+pasive.purchaseValue);
                System.out.println(getNoCurrentPasiveValue());
            }else{
                Pasives.setNoCurrentPasiveValue(Pasives.noCurrentPasiveValue+pasive.purchaseValue);
                System.out.println(Pasives.getCurrentPasiveValue());
            }
        }
    }

    public void setId(String id) {
        this.id = id;
    }
}
