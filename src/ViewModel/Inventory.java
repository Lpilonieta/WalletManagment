package ViewModel;

import Model.GeneralRegistry;

public class Inventory extends Assets {

    private float stockNumber;
    private float saleNumbers;
    private float totalItemValue;//
    private float unitValue;

    public Inventory(byte formtype, String name, String description, String comments, byte type, byte category, int rentability, int saleValue, float stockNumber, float saleNumbers, float totalItemValue, float unitValue) {
        super(formtype, name, description, comments, type, category, rentability, saleValue);
        this.stockNumber = stockNumber;
        this.saleNumbers = saleNumbers;
        this.totalItemValue = totalItemValue;
        this.unitValue = unitValue;
        setInventory(this);
        GeneralRegistry.save(this);
    }

    public float getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(float stockNumber) {
        this.stockNumber = stockNumber;
    }

    public float getSaleNumbers() {
        return saleNumbers;
    }

    public void setSaleNumbers(float saleNumbers) {
        this.saleNumbers = saleNumbers;
    }

    public float getTotalItemValue() {
        return totalItemValue;
    }

    public void setTotalItemValue(float totalItemValue) {
        this.totalItemValue = totalItemValue;
    }

    public float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(float unitValue) {
        this.unitValue = unitValue;
    }
}
