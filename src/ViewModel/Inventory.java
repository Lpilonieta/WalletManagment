package ViewModel;

import Model.GeneralRegistry;

public class Inventory extends Assets {

    private float stockNumber;
    private float saleNumbers;
    private float totalItemValue;//
    private float unitValue;

    private static float inventoryValue;
    private byte category;

    public Inventory(byte formtype, String name, String description, String comments, byte type, byte category, int rentability, int saleValue, float stockNumber, float saleNumbers, float totalItemValue, float unitValue) {
        super(formtype, name, description, comments, type, category, rentability);
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

    public static float getInventoryValue() {
        inventoryValue = Constants.NONE;
        for (Inventory inventoryItem:new GeneralRegistry().getAllInventory()
             ) {
            inventoryValue+= inventoryItem.getUnitValue()* inventoryItem.getStockNumber();
        }

        return inventoryValue;
    }
<<<<<<< HEAD

    public byte getCategory() {
        return category;
    }
=======
    public static float calcBruteUtility(){
        float bruteUtility = 0;
        for (Inventory inventoryItem: new GeneralRegistry().getAllInventory()
        ) {
            //Ventas totales – Costo de mercancía vendida = Utilidad bruta
            bruteUtility += inventoryItem.getSaleNumbers()*(inventoryItem.getUnitValue() - inventoryItem.getPurchaseValue());
        }
        return bruteUtility==0 ? Constants.NONE : bruteUtility;
    }  //check
    public static float calcNetSales(){
        return calcBruteSales();    //no se registran devoluciones o descuentos
    }
    public static float calcBruteSales(){
        float bruteSales = 0;
        for (Inventory inventoryItem: new GeneralRegistry().getAllInventory()
        ) {
            bruteSales += (inventoryItem.getSaleNumbers() * inventoryItem.getUnitValue());
        }
        return bruteSales==0 ? Constants.NONE : bruteSales;
    }   //check
    public static float calcNetUtility(){
        //utilidad bruta - iva
        float netUtility = 0;
        if (calcBruteUtility() != Constants.NONE && calcIvaTax()!= Constants.NONE){
            netUtility += calcBruteUtility() - calcIvaTax();
        }
        return netUtility == 0 ? Constants.NONE : netUtility;
    }
    private static float calcIvaTax() {
        float ivaTax = 0;
        for (Inventory inventoryItem:new GeneralRegistry().getAllInventory() // TODO: tomar sólo los item del inventario que se les cobra iva
             ) {
            ivaTax += (inventoryItem.getUnitValue()*0.19) - (inventoryItem.getPurchaseValue()*0.19);
        }
        return ivaTax == 0 ? Constants.NONE : ivaTax;
    }

>>>>>>> 766647f1dfc1db9bfbcb72790170b00127a539f1
}
