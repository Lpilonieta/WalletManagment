package Model.TestData;

import ViewModel.Assets;
import ViewModel.Constants;
import ViewModel.Form;

public class FormTest {
    public Form formTest_01new = new Form("0-21-11-22", 10000, Constants.SOURCE_LIST[0],"Comida", Constants.EXPENSE_FORM_TYPE, 3);
    public Form formTest_03new = new Form("0-21-11-22", 50000, Constants.SOURCE_LIST[1],"Ropa", Constants.EXPENSE_FORM_TYPE, 2);
    public Form formTest_02new = new Form("0-21-11-22", 60000, Constants.SOURCE_LIST[0],"Utencilios", Constants.EXPENSE_FORM_TYPE, 1);
    public Form formTest_04new = new Form("0-21-11-22", 60000, Constants.SOURCE_LIST[1],"VentaZapatos", Constants.RENEUE_FORM_TYPE, 3);

    public Form formTest_05 = new Form("1-22-11-22", 10000, Constants.SOURCE_LIST[2],"Deuda", Constants.RENEUE_FORM_TYPE, 3);
    public Form formTest_06 = new Form("1-22-11-22", 50000, Constants.SOURCE_LIST[0],"Deuda", Constants.EXPENSE_FORM_TYPE, 3);
    public Form formTest_07 = new Form("1-22-11-22", 30000, Constants.SOURCE_LIST[1],"Comida", Constants.RENEUE_FORM_TYPE, 3);
    public Form formTest_08 = new Form("1-22-11-22", 20000, Constants.SOURCE_LIST[0],"Ropa", Constants.EXPENSE_FORM_TYPE, 3);
    public Form formTest_09 = new Form("1-22-11-22", 10000, Constants.SOURCE_LIST[0],"Deuda", Constants.RENEUE_FORM_TYPE, 3);
    public Form formTest_10 = new Form("1-22-11-22", 10000, Constants.SOURCE_LIST[0],"Servicios", Constants.EXPENSE_FORM_TYPE, 3);
}
