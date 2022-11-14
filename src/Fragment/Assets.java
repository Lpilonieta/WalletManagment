package Fragment;

import Model.AssetsRegistry;
import Model.PasivesRegistry;

import java.util.ArrayList;

public class Assets implements Inventory {





    // Assets Attributes
    private String id;
    private String name;
    private String description;
    private String comments;
    private int purchaseValue;
    private byte type;
    private byte category;
    private int rentability;
    private int saleValue;

    private static float currentAssetsValue = 0;//Assets.getPreviousValue();
    private static float noCurrentAssetsValue = 0;//Assets.getPreviousValue();
    private static ArrayList<Assets> totalAssets = new ArrayList<>(1);

    private static float totalAssetsValue =0;


    private static int getPreviousValue() {
        // todo hacer method que traiga el valor de la base de datos
        return 0;
    }

    public Assets() {
        this.id = "";
        this.name = "";
        this.description = "";
        this.comments = "";
        this.purchaseValue = 0;
        this.type = Constants.NONE;
        this.rentability = 0;
        this.saleValue = 0;
        this.category = Constants.NONE;

    }

    public Assets(String id, String name, String description, int purchaseValue, byte type, int rentability, int saleValue, byte category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.purchaseValue = purchaseValue;
        this.type = type;
        this.rentability = rentability;
        this.saleValue = saleValue;
        this.category = category;
        this.comments = "";
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

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(int purchaseValue) {
        this.purchaseValue = purchaseValue;
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
        updateCurrentValueFromDB();
        return currentAssetsValue;
    }

    private static void updateCurrentValueFromDB() {
        currentAssetsValue = 0;
        for (Assets asset:AssetsRegistry.getAssetsRegistry().values()
             ) {
            if (asset.isCurrentType()) currentAssetsValue += asset.getPurchaseValue();
        }
    }

    private static void setCurrentAssetsValue(float currentAssetsValue) {
        Assets.currentAssetsValue = currentAssetsValue;
    }

    public static float getNoCurrentAssetsValue() {
        updateNoCurrentValueFromDB();
        return noCurrentAssetsValue;
    }

    private static void setNoCurrentAssetsValue(float noCurrentAssetsValue) {
        Assets.noCurrentAssetsValue = noCurrentAssetsValue;
    }
    private static void updateNoCurrentValueFromDB() {
        noCurrentAssetsValue = 0;
        for (Assets asset:AssetsRegistry.getAssetsRegistry().values()
        ) {
            if (! asset.isCurrentType()) noCurrentAssetsValue += asset.getPurchaseValue();
        }
    }

    public static ArrayList<Assets> getTotalAssets() {
        updateTotalAssetsFromDB();
        return totalAssets;
    }
    public static float getTotalAssetsValue(){
        updateTotalAssetsFromDB();
        totalAssetsValue =0;
        for (Assets asset:totalAssets
             ) {
            totalAssetsValue+= asset.getPurchaseValue();
        }

        return totalAssetsValue;
    }

    private static void updateTotalAssetsFromDB()  {
        totalAssets.clear();
        if (! AssetsRegistry.getAssetsRegistry().isEmpty()){
            for (Assets asset:AssetsRegistry.getAssetsRegistry().values()
                 ) {
                totalAssets.add(asset);
            }
        }
    }

    //todo implementar que se recuperen assets de acuerdo al intervalo especificado
    public static void setTotalAssets(ArrayList<Assets> totalAssets) {
        Assets.totalAssets = totalAssets;
    }

    //todo posible method para una interfaz
    public static void updateTypeValues(Assets[] totalAssets){
        Assets.setNoCurrentAssetsValue(0);
        Assets.setCurrentAssetsValue(0);
        for (Assets asset:totalAssets
             ) {
            if (asset.isCurrentType()){
                Assets.setCurrentAssetsValue(Assets.currentAssetsValue+asset.purchaseValue);
                System.out.println(getCurrentAssetsValue());
            }else{
                Assets.setNoCurrentAssetsValue(Assets.noCurrentAssetsValue+asset.purchaseValue);
                System.out.println(Assets.getNoCurrentAssetsValue());
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


    public void setId(String id) {
        this.id = id;
    }
}
