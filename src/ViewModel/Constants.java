package ViewModel;

import ViewModel.Spaces.FinancialSpace;

public class Constants {
    public static final byte NONE = -125;
    public static final FinancialSpace AREA_PERSONAL= new FinancialSpace("Area personal","",0x0);
    public static final int AREA_PERSONAL_ID = 0x0;
    // asset-pasive types
    public static final byte NO_CURRENT = 0;
    public static final byte CURRENT = 1;
    // periodicy
    public static final byte DAILY = 2;
    public static final byte WEEKLY = 3;
    public static final byte MONTHLY = 4;
    public static final byte YEARLY = 5;
    //interest types
    public static final byte LINEAL_INTEREST = 6;
    public static final byte COMPOUND_INTEREST = 7;
    //form types
    public static final byte RENEUE_FORM_TYPE = 8;
    public static final byte EXPENSE_FORM_TYPE = 9;
    public static final String DEFAULT_GROUP = "";

    String[] ProductosSinIVA={
            "Arroz", "Pan", "OtrosProductosPanaderia", "Papa", "Yuca",
    };

}
