package ViewModel;

import Model.GeneralRegistry;

public class Motive {
    private String name;
    private byte formType;
    private boolean isAsset,isPasive,isInventory,isNewInventory;


    public Motive(String name, byte formType, boolean isAsset, boolean isPasive, boolean isInventory, boolean isNewInventory) {
        this.name = name;
        this.formType = formType;
        this.isAsset = isAsset;
        this.isPasive = isPasive;
        this.isInventory = isInventory;
        this.isNewInventory = isNewInventory;
//        GeneralRegistry.saveMotive(this);
    }




    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getFormType() {
        return formType;
    }

    public void setFormType(byte formType) {
        this.formType = formType;
    }

    public boolean isAsset() {
        return isAsset;
    }

    public void setAsset(boolean asset) {
        isAsset = asset;
    }

    public boolean isPasive() {
        return isPasive;
    }

    public void setPasive(boolean pasive) {
        isPasive = pasive;
    }

    public boolean isInventory() {
        return isInventory;
    }

    public void setInventory(boolean inventory) {
        isInventory = inventory;
    }

    public boolean isNewInventory() {
        return isNewInventory;
    }

    public void setNewInventory(boolean newInventory) {
        isNewInventory = newInventory;
    }
}
