package ViewModel;

//import Model.GeneralRegistry;

import Model.GeneralRegistry;

import java.util.ArrayList;

public class Assets extends Form {

    // Assets Attributes

    private String name;
    private String description;
    private String comments;
    private byte type;
    private int rentability;
    private boolean isInventory=false;
    private Inventory inventory = null;




    private static float currentAssetsValue = 0;//Assets.getPreviousValue();
    private static float noCurrentAssetsValue = 0;//Assets.getPreviousValue();
    private static ArrayList<Assets> totalAssets = new ArrayList<>(1);

    private static float totalAssetsValue =0;

    //inventory attributes



    public Assets() {
        this.name = "";
        this.description = "";
        this.comments = "";
        this.type = Constants.NONE;
        this.rentability = 0;
        setAsset(this);
        GeneralRegistry.save(this);
        getNewId();


    }
    public Assets(byte formtype,String name, String description, String comments, byte type, byte category, int rentability) {
        super(formtype);
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.type = type;
        this.rentability = rentability;
        setAsset(this);
        GeneralRegistry.save(this);
        getNewId();



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

    public byte getType() {
        return type;
    }

    public void setFormType(byte formType) {
        this.type = formType;
    }

    public int getRentability() {
        return rentability;
    }

    public void setRentability(int rentability) {
        this.rentability = rentability;
    }

    public static float getCurrentAssetsValue() {
        updateCurrentValue();
        return currentAssetsValue;
    }

    public static void updateCurrentValue() {
        updateTotalAssetsFromDB();
        currentAssetsValue = 0;
        for (Assets asset:totalAssets
             )
            if (asset.isCurrentType())
                currentAssetsValue += asset.getPurchaseValue();
        currentAssetsValue = currentAssetsValue == 0 ? Constants.NONE : currentAssetsValue;
    }

    private static void setCurrentAssetsValue(float currentAssetsValue) {
        Assets.currentAssetsValue = currentAssetsValue;
    }

    public static float getNoCurrentAssetsValue() {
        updateNoCurrentValue();
        return noCurrentAssetsValue;
    }

    private static void setNoCurrentAssetsValue(float noCurrentAssetsValue) {
        Assets.noCurrentAssetsValue = noCurrentAssetsValue;
    }
    public static void updateNoCurrentValue() {
        noCurrentAssetsValue = 0;
        for (Assets asset:totalAssets
        ) {
                //TODO: desarrollar este método
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

        return totalAssetsValue == 0 ? Constants.NONE : totalAssetsValue;
    }

    public static void updateTotalAssetsFromDB()  {
        totalAssets = new GeneralRegistry().getAllAssets();
    }
    public static void setTotalAssets(ArrayList<Assets> totalAssets) {
        Assets.totalAssets = totalAssets;
    }

    //todo posible method para una interfaz
    public static void updateTypeValues(){
        Assets.setNoCurrentAssetsValue(0);
        Assets.setCurrentAssetsValue(0);
        for (Assets asset:totalAssets
             ) {
            if (asset.isCurrentType()){
                //Assets.setCurrentAssetsValue(Assets.currentAssetsValue+asset.purchaseValue);
                System.out.println(getCurrentAssetsValue());
            }else{
                //Assets.setNoCurrentAssetsValue(Assets.noCurrentAssetsValue+asset.purchaseValue);
                System.out.println(Assets.getNoCurrentAssetsValue());
            }
        }
    }

    private boolean isCurrentType() {
        return this.getType() == Constants.CURRENT;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        isInventory = true;
        setAsset(inventory);
    }

    public boolean isInventoryItem() {
        return isInventory;
    }
}
