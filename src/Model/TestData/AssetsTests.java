package Model.TestData;

import ViewModel.Assets;
import ViewModel.Constants;

public class AssetsTests {
    public Assets assetTest_01 = new Assets("0-21-11-22", 10000, Constants.SOURCE_LIST[0],"Comida", Constants.EXPENSE_FORM_TYPE, 3, "Pollo", " ", Constants.CURRENT, 90);
    public Assets assetTest_02 = new Assets("0-21-11-22", 50000, Constants.SOURCE_LIST[1],"Ropa", Constants.EXPENSE_FORM_TYPE, 2, "Jean", " ", Constants.CURRENT, 02);
    public Assets assetTest_03 = new Assets("0-21-11-22", 60000, Constants.SOURCE_LIST[0],"Utencilios", Constants.EXPENSE_FORM_TYPE, 1, "JuegoMesa", " ", Constants.CURRENT, 0);
    public Assets assetTest_04 = new Assets("0-21-11-22", 60000, Constants.SOURCE_LIST[1],"VentaZapatos", Constants.RENEUE_FORM_TYPE, 3, "Jordan", " ", Constants.CURRENT, 0);

    public Assets assetTest_05 = new Assets("1-22-11-22", 10000, Constants.SOURCE_LIST[0],"Comida", Constants.EXPENSE_FORM_TYPE, 3, "Pizza", " ", Constants.CURRENT, 5);
    public Assets assetTest_06 = new Assets("1-22-11-22", 50000, Constants.SOURCE_LIST[1],"VentaRopa", Constants.RENEUE_FORM_TYPE, 3, "CamisaPolo", " ", Constants.CURRENT, 30);
    public Assets assetTest_07 = new Assets("1-22-11-22", 8000, Constants.SOURCE_LIST[0],"Planta", Constants.EXPENSE_FORM_TYPE, 1, "Girasol", " ", Constants.NO_CURRENT, 0);
    public Assets assetTest_08 = new Assets("1-22-11-22", 90000, Constants.SOURCE_LIST[1],"VentaTelevisor", Constants.RENEUE_FORM_TYPE, 2, "Lg", " ", Constants.CURRENT, 0);
    public Assets assetTest_09 = new Assets("1-22-11-22", 10000, Constants.SOURCE_LIST[0],"Carro", Constants.EXPENSE_FORM_TYPE, 3, "BMW", " ", Constants.NO_CURRENT, 10);
    public Assets assetTest_10 = new Assets("1-22-11-22", 50000, Constants.SOURCE_LIST[0],"Comida", Constants.EXPENSE_FORM_TYPE, 3, "Pollo", " ", Constants.CURRENT, 0);

    public Assets assetTest_11= new Assets("2-23-11-22", 80000, Constants.SOURCE_LIST[0],"Ropa", Constants.EXPENSE_FORM_TYPE, 2, "Sombrero", " ", Constants.CURRENT, 90);
    public Assets assetTest_12= new Assets("2-23-11-22", 30000, Constants.SOURCE_LIST[1],"Comida", Constants.EXPENSE_FORM_TYPE, 2, "Perro", " ", Constants.CURRENT, 0);
    public Assets assetTest_13= new Assets("2-23-11-22", 90000, Constants.SOURCE_LIST[0],"Televisor", Constants.EXPENSE_FORM_TYPE, 3, "Samsung", " ", Constants.CURRENT, 50);
    public Assets assetTest_14= new Assets("2-23-11-22", 90000, Constants.SOURCE_LIST[1],"VentaCelular", Constants.RENEUE_FORM_TYPE, 1, "Iphone", " ", Constants.CURRENT, 0);
    public Assets assetTest_15= new Assets("2-23-11-22", 50000, Constants.SOURCE_LIST[0],"Maleta", Constants.EXPENSE_FORM_TYPE, 3, "Totto", " ", Constants.CURRENT, 15);

    public Assets assetTest_16= new Assets("3-24-11-22", 7000, Constants.SOURCE_LIST[0],"Comida", Constants.EXPENSE_FORM_TYPE, 1, "Pollo", " ", Constants.CURRENT, 5);
    public Assets assetTest_17= new Assets("3-24-11-22", 80000, Constants.SOURCE_LIST[0],"VentaRopa", Constants.RENEUE_FORM_TYPE, 2, "Jean", " ", Constants.CURRENT, 0);
    public Assets assetTest_18= new Assets("3-24-11-22", 10000, Constants.SOURCE_LIST[1],"Esferos", Constants.EXPENSE_FORM_TYPE, 1, "Prisma", " ", Constants.CURRENT, 10);
    public Assets assetTest_19= new Assets("3-24-11-22", 10000, Constants.SOURCE_LIST[0],"Comida", Constants.EXPENSE_FORM_TYPE, 1, "Pollo", " ", Constants.CURRENT, 25);
    public Assets assetTest_20= new Assets("3-24-11-22", 90000, Constants.SOURCE_LIST[1],"Comida", Constants.EXPENSE_FORM_TYPE, 3, "Pizza", " ", Constants.CURRENT, 0);
}