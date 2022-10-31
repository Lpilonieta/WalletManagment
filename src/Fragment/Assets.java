package Fragment;

public class Assets {

    private String id;
    private String name;
    private String description;
    private int value;
    private byte type;
    private int rentability;
    private int saleValue;

    private static float currentAssetsValue = Assets.getPreviousValue();
    private static float noCurrentAssetsValue = Assets.getPreviousValue();
    //todo error de recursividad
    private static float totalAssetsValue = Assets.getTotalAssetsValue();

    public static final byte NONE = -1;
    public static final byte NO_CURRENT = 0;
    public static final byte CURRENT = 1;

    private static int getPreviousValue() {
        // todo hacer method que traiga el valor de la base de datos
        return 0;
    }

    private static Assets[] totalAssets = getTotalAssetsFromDB();




    public Assets() {
        this.id = "";
        this.name = "";
        this.description = "";
        this.value = -1;
        this.type = NONE;
        this.rentability = 0;
        this.saleValue = 0;

    }

    public Assets(String id, String name, String description, int value, byte type, int rentability, int saleValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.type = type;
        this.rentability = rentability;
        this.saleValue = saleValue;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getRentability() {
        return rentability;
    }

    public void setRentability(int rentability) {
        this.rentability = rentability;
    }

    public int getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(int saleValue) {
        this.saleValue = saleValue;
    }

    public static float getCurrentAssetsValue() {
        return currentAssetsValue;
    }

    private static void setCurrentAssetsValue(float currentAssetsValue) {
        Assets.currentAssetsValue = currentAssetsValue;
    }

    public static float getNoCurrentAssetsValue() {
        return noCurrentAssetsValue;
    }

    private static void setNoCurrentAssetsValue(float noCurrentAssetsValue) {
        Assets.noCurrentAssetsValue = noCurrentAssetsValue;
    }

    public static Assets[] getTotalAssets() {
        return totalAssets;
    }
    //todo implementar que se recuperen assets de acuerdo al intervalo especificado
    public static void setTotalAssets(Assets[] totalAssets) {
        Assets.totalAssets = totalAssets;
    }
    public static void setTotalAssetsValue(Assets[] totalAssets) {

        Assets.totalAssetsValue =0;
        for (Assets asset:totalAssets
        ) {
            Assets.totalAssetsValue = Assets.totalAssetsValue + asset.value;
        }
    }
    //todo posible method para una interfaz
    public static void updateTypeValues(Assets[] totalAssets){
        Assets.setNoCurrentAssetsValue(0);
        Assets.setCurrentAssetsValue(0);
        for (Assets asset:totalAssets
             ) {
            if (asset.isCurrentType()){
                Assets.setCurrentAssetsValue(Assets.currentAssetsValue+asset.value);
                System.out.println(getCurrentAssetsValue());
            }else{
                Assets.setNoCurrentAssetsValue(Assets.noCurrentAssetsValue+asset.value);
                System.out.println(Assets.getNoCurrentAssetsValue());
            }
        }
    }

    private boolean isCurrentType() {
        if (this.getType()==CURRENT){
            return true;
        }else{
            return false;
        }
    }
    // modificar para que devuelva la cantidad de assets que se le pide
    private static Assets[] getTotalAssetsFromDB() {
        Assets asset1= new Assets("1","name1","",100,Assets.CURRENT,0,0);
        Assets asset2 = new Assets("2","name1","",200,Assets.NO_CURRENT,0,0);

        Assets[] totalAssets = {
                asset1,
                asset2
        };
        return totalAssets;
    }

    private static float getTotalAssetsValue() {
        return Assets.totalAssetsValue;
    }
}
