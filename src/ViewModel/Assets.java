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
    private byte category;
    private int rentability;
    private int saleValue;
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
        this.saleValue = 0;
        this.category = Constants.NONE;
        setAsset(this);
        GeneralRegistry.save(this);
        getNewId();


    }
    public Assets(byte formtype,String name, String description, String comments, byte type, byte category, int rentability, int saleValue) {
        super(formtype);
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.type = type;
        this.category = category;
        this.rentability = rentability;
        this.saleValue = saleValue;
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

    public byte getCategory() {
        return category;
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

    public int getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(int saleValue) {
        this.saleValue = saleValue;
    }

    public static float getCurrentAssetsValue() {
        updateCurrentValue();
        return currentAssetsValue;
    }

    public static void updateCurrentValue() {
        currentAssetsValue = 0;
        for (Assets asset:totalAssets
             ) {
            //TODO: desarrollar este método
        }
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
            //TODO: desarrollar este método
        }

        return totalAssetsValue;
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
        if (this.getFormType()==Constants.CURRENT){
            return true;
        }else{
            return false;
        }
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
