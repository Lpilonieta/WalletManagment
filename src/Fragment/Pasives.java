package Fragment;

public class Pasives {

    private String id;
    private String name;
    private String deudor;
    private String description;
    private int value;
    private int interestType;
    private int interestPercentage;
    private int numberOfInstallments;
    private float installmentPrice;
    private byte type;
    private byte periodicy;
    private int especificPeriodicy;
    private  static Pasives[] totalPasives = Pasives.getTotalPasivesFromDB();

    private static float currentPasiveValue = Pasives.getPreviousValue();
    private static float noCurrentPasiveValue = Pasives.getPreviousValue();
    //todo error de recursividad
    private static float totalPasiveValue = Pasives.getTotalPasiveValue();

    public static final byte NONE = -1;
    public static final byte NO_CURRENT = 0;
    public static final byte CURRENT = 1;
    public static final byte DAILY = 2;
    public static final byte WEEKLY = 3;
    public static final byte MONTHLY = 4;
    public static final byte YEARLY = 5;
    public static final byte LINEAL_INTEREST = 6;
    public static final byte COMPOUND_INTEREST = 7;

    public Pasives() {
        this.id = "";
        this.name = "";
        this.description = "";
        this.value = 0;
        this.interestType = Pasives.NONE;
        this.interestPercentage = Pasives.NONE;
        this.numberOfInstallments = Pasives.NONE;
        this.type = Pasives.NONE;
        this.periodicy = Pasives.NONE;
        this.especificPeriodicy = Pasives.NONE;
    }

    public Pasives(String id,
                   String name,
                   String description,
                   int value,
                   int interestType,
                   int interestPercentage,
                   int numberOfInstallments,
                   byte type,
                   byte periodicy,
                   int especificPeriodicy)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getInterestType() {
        return interestType;
    }

    public void setInterestType(int interestType) {
        this.interestType = interestType;
    }

    public int getInterestPercentage() {
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

    public float getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(float installmentPrice) {
        this.installmentPrice = installmentPrice;
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

    public static Pasives[] getTotalPasives() {
        return totalPasives;
    }

    public static void setTotalPasives(Pasives[] totalPasives) {
        Pasives.totalPasives = totalPasives;
    }



    private static int getPreviousValue() {
        // todo hacer method que traiga el valor de la base de datos
        return 0;
    }
    public static float getTotalPasiveValue(){
        return Pasives.totalPasiveValue;
    }

    public static void setTotalPasiveValue(Pasives[] totalPasives) {
        //todo ajustar que en el valor de los pasivos se tenga en cuenta el interés
        Pasives.totalPasiveValue =0;
        for (Pasives pasive:totalPasives
        ) {
            Pasives.totalPasiveValue = Pasives.totalPasiveValue + pasive.value;
        }
    }

    private boolean isCurrentType() {
        if (this.getType()==CURRENT){
            return true;
        }else{
            return false;
        }
    }


    public static float getCurrentPasiveValue() {
        return currentPasiveValue;
    }

    public static void setCurrentPasiveValue(float currentPasiveValue) {
        Pasives.currentPasiveValue = currentPasiveValue;
    }

    public static float getNoCurrentPasiveValue() {
        return noCurrentPasiveValue;
    }

    public static void setNoCurrentPasiveValue(float noCurrentPasiveValue) {
        Pasives.noCurrentPasiveValue = noCurrentPasiveValue;
    }

    //todo posible method para una interfaz
    public static void updateTypeValues(Pasives[] totalPasives){
        Pasives.setNoCurrentPasiveValue(0);
        Pasives.setCurrentPasiveValue(0);
        for (Pasives pasive:totalPasives
        ) {
            if (pasive.isCurrentType()){
                Pasives.setCurrentPasiveValue(Pasives.currentPasiveValue+pasive.value);
                System.out.println(getNoCurrentPasiveValue());
            }else{
                Pasives.setNoCurrentPasiveValue(Pasives.noCurrentPasiveValue+pasive.value);
                System.out.println(Pasives.getCurrentPasiveValue());
            }
        }
    }

    // modificar para que devuelva la cantidad de assets que se le pide
    private static Pasives[] getTotalPasivesFromDB() {
        Pasives pasive1= new Pasives("1",
                "name1",
                "",
                100,
                Pasives.LINEAL_INTEREST,
                0,
                1,
                Pasives.CURRENT,
                Pasives.MONTHLY,
                1
        );
        Pasives pasive2 = new Pasives("2",
                "name1",
                "",
                200,
                Pasives.COMPOUND_INTEREST,
                0,
                2,
                Pasives.NO_CURRENT,
                Pasives.MONTHLY,
                1
        );

        Pasives[] totalPasives = {
                pasive1,
                pasive2
        };
        return totalPasives;
    }


}
