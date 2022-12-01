package ViewModel;

import Model.GeneralRegistry;
import Model.SQLconection;
import ViewModel.Spaces.FinancialSpace;

import java.sql.SQLException;

public class Inventory extends Assets {

    private float stockNumber;
    private float saleNumbers;
    private float unitValue;

    private String finSpaceName;

    private static float inventoryValue;

    private byte category;

    public Inventory(String registryDate, int purchaseValue, String source, String motive, byte formType, int financialSpaceIdRegistered, String name, String description, byte type, int rentability, float stockNumber, float saleNumbers, float unitValue,String categ, byte category) {
        super(registryDate, purchaseValue, source, motive, formType, financialSpaceIdRegistered, name, description, type, rentability);
        this.stockNumber = stockNumber;
        this.saleNumbers = saleNumbers;
        this.unitValue = unitValue;
        this.category = category;
        this.finSpaceName = setFinSpaceName(financialSpaceIdRegistered);
    }

    private String setFinSpaceName(int financialSpaceIdRegistered) {
        try {
            for (FinancialSpace financialSpace : SQLconection.getAllFinancialSpacesBD()
            ) {
                if (financialSpace.getId() ==this.getFinancialSpaceIdRegistered() ){
                    return financialSpace.getName();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Constants.AREA_PERSONAL.getName();
    }

    public Inventory() {
    }

    public String getFinSpaceName() {
        return finSpaceName;
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


    public float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(float unitValue) {
        this.unitValue = unitValue;
    }

    public void setCategory(byte category) {
        this.category = category;
    }

    public static float getInventoryValue() {
        inventoryValue = Constants.NONE;
        for (Inventory inventoryItem:new GeneralRegistry().getAllInventory()
             ) {
            inventoryValue+= inventoryItem.getUnitValue()* inventoryItem.getStockNumber();
        }

        return inventoryValue;
    }


    public byte getCategory() {
        return category;
    }

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


}
