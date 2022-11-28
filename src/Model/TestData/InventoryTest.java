package Model.TestData;

import ViewModel.Assets;
import ViewModel.Constants;
import ViewModel.Form;
import ViewModel.Inventory;

public class InventoryTest {
    public Inventory inventoryTest_01 = new Inventory("0-21-11-22", 10000, Constants.SOURCE_LIST[0],"Juguetes", Constants.RENEUE_FORM_TYPE, 3, "Barbie", " ", Constants.CURRENT, 90,  10, 3, 10000F, (byte) 1);
    public Inventory inventoryTest_04 = new Inventory("0-21-11-22", 30000, Constants.SOURCE_LIST[1],"Juguetes", Constants.RENEUE_FORM_TYPE, 1, "Carro", " ", Constants.CURRENT, 90,  15, 3, 20000F, (byte) 1);
    public Inventory inventoryTest_02 = new Inventory("0-21-11-22", 20000, Constants.SOURCE_LIST[1],"Juguetes", Constants.RENEUE_FORM_TYPE, 2, "Pelotas", " ", Constants.CURRENT, 90,  6, 3, 5000F, (byte) 1);
    public Inventory inventoryTest_03 = new Inventory("0-21-11-22", 40000, Constants.SOURCE_LIST[0],"Juguetes", Constants.RENEUE_FORM_TYPE, 3, "Xbox", " ", Constants.CURRENT, 90,  1, 3, 90000F, (byte) 1);

    public Inventory inventoryTest_05 = new Inventory("1-22-11-22", 10000, Constants.SOURCE_LIST[0],"Juguetes", Constants.RENEUE_FORM_TYPE, 3, "Cocina", " ", Constants.CURRENT, 90,  8, 3, 50000F, (byte) 1);
    public Inventory inventoryTest_06 = new Inventory("1-22-11-22", 10000, Constants.SOURCE_LIST[1],"Juguetes", Constants.RENEUE_FORM_TYPE, 3, "HeladeriaCreisel", " ", Constants.CURRENT, 90,  3, 3, 90000F, (byte) 1);
    public Inventory inventoryTest_07 = new Inventory("1-22-11-22", 20000, Constants.SOURCE_LIST[1],"Juguetes", Constants.RENEUE_FORM_TYPE, 1, "Celular", " ", Constants.CURRENT, 90,  10, 1, 90000F, (byte) 1);
    public Inventory inventoryTest_08 = new Inventory("1-22-11-22", 40000, Constants.SOURCE_LIST[0],"Juguetes", Constants.RENEUE_FORM_TYPE, 2, "Computador", " ", Constants.CURRENT, 90,  10, 2, 20000F, (byte) 1);
    public Inventory inventoryTest_09 = new Inventory("1-22-11-22", 30000, Constants.SOURCE_LIST[1],"Juguetes", Constants.RENEUE_FORM_TYPE, 3, "Pollo", " ", Constants.CURRENT, 90,  10, 15, 90000F, (byte) 0);
    public Inventory inventoryTest_10 = new Inventory("1-22-11-22", 10000, Constants.SOURCE_LIST[0],"Juguetes", Constants.RENEUE_FORM_TYPE, 3, "Peluche", " ", Constants.CURRENT, 90,  10, 3, 5000F, (byte) 1);
}
