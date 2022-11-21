package Model;

import Fragment.Assets;
import Fragment.Constants;
import Fragment.Form;
import Fragment.Pasives;
import Fragment.Spaces.FinancialSpace;
import Fragment.Spaces.Manager;

public class EJEMPLO {
    private FinancialSpace espacio1 = new FinancialSpace("espacio 1","grupo 1", 0x1);
    private FinancialSpace espacio2 = new FinancialSpace("espacio 1","grupo 1", 0x2);
    private FinancialSpace espacio3 = new FinancialSpace("espacio 1","grupo 2", 0x3);
    private FinancialSpace espacio4 = new FinancialSpace("espacio 1","sin grupo", 0x4);
    // assets de ejemplo
    private Assets assetTest_1 = new Assets("name asset test 1","description AssetTest1","", Constants.CURRENT, (byte) 0,80, Constants.NONE);
    private Assets assetTest_2 = new Assets("name asset test 2","description AssetTest2","",Constants.CURRENT, (byte) 0,180, Constants.NONE);
    private Assets assetTest_3 = new Assets("name asset test 3","description AssetTest3","",Constants.NO_CURRENT, (byte) 5,500, Constants.NONE);
    private Assets assetTest_4 = new Assets("name asset test 4","description AssetTest4","",Constants.CURRENT, (byte) 0,380, Constants.NONE);
    private Assets assetTest_5 = new Assets("name asset test 5","description AssetTest5","",Constants.NO_CURRENT, (byte) 10,550, Constants.NONE);

    // pasivos de ejemplo
    private Pasives pasiveTest_1 = new Pasives("name pasiveTest 1","deudor 1", "description pasiveTest 1", Constants.LINEAL_INTEREST, 1,1,Constants.NO_CURRENT,Constants.MONTHLY,1);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_2 = new Pasives("name pasiveTest 2","deudor 2", "description pasiveTest 2", Constants.COMPOUND_INTEREST, 2,2,Constants.CURRENT,Constants.WEEKLY,2);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_3 = new Pasives("name pasiveTest 3","deudor 3", "description pasiveTest 3", Constants.LINEAL_INTEREST, 3,3,Constants.CURRENT,Constants.DAILY,3);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_4 = new Pasives("name pasiveTest 4","deudor 4","description pasiveTest 4", Constants.COMPOUND_INTEREST, 4,4,Constants.NO_CURRENT,Constants.YEARLY,1);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_5 = new Pasives("name pasiveTest 5","deudor 5", "description pasiveTest 5", Constants.LINEAL_INTEREST, 5,5,Constants.CURRENT,Constants.WEEKLY,2);  // TODO: incluir fecha de pago mas cercana al contructor

    private Form formTest_0 = new Form();
    private Form formTest_1 = new Form();
    private Form formTest_2 = new Form();
    private Form formTest_3 = new Form();
    private Form formTest_4 = new Form();
    private Form formTest_5 = new Form();
    private Form formTest_6 = new Form();
    private Form formTest_7 = new Form();
    private Form formTest_8 = new Form();
    private Form formTest_9 = new Form();


    public void setExampleGeneralRegistry(){


        setUpFinancialSpaces();
        setUpForms();
        saveForm(formTest_0);
        saveForm(formTest_1);
        saveForm(formTest_2);
        saveForm(formTest_3);
        saveForm(formTest_4);
        saveForm(formTest_5);
        saveForm(formTest_6);
        saveForm(formTest_7);
        saveForm(formTest_8);
        saveForm(formTest_9);
    }

    private void setUpFinancialSpaces() {
        addFinancialSpacesToDB(espacio1);
        addFinancialSpacesToDB(espacio2);
        addFinancialSpacesToDB(espacio3);
        addFinancialSpacesToDB(espacio4);
    }
    public void addFinancialSpacesToDB(FinancialSpace espacio) {

        GeneralRegistry.getFinancialSpaceHashMap().put(espacio.getId(),espacio);
    }
    public static void addFinancialSpaceToDB(FinancialSpace espacio) {
        GeneralRegistry.getFinancialSpaceHashMap().put(espacio.getId(),espacio);
    }

    private void saveForm(Form form) {
        GeneralRegistry.getExampleGeneralRegistry().put(form.getId(),form);        //TODO: para dejarlo definitivo solo quitar la parte de "EXAMPLE_"
        if (form.isNeedAssetData()){
            AssetsRegistry.saveAsset(form);
        } else if (form.isNeedPasiveData()) {
            PasivesRegistry.savePasive(form);
        }
    }
    private void setUpForms() {

        formTest_0.setPurchaseValue(10);
        formTest_0.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_0.setSource("fuente testForm_0");
        formTest_0.setMotive("venta Activo");
        formTest_0.setAsset(assetTest_1);
        assetTest_1.setPurchaseValue(formTest_0.getPurchaseValue());
        formTest_0.setComments("comments formTest0");


        Manager.switchFinancialSpaceByID(0x1);

        formTest_1.setPurchaseValue(100);
        formTest_1.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_1.setSource("fuente testForm_1");
        formTest_1.setMotive("venta Activo");
        formTest_1.setAsset(assetTest_2);
        assetTest_2.setPurchaseValue(formTest_2.getPurchaseValue());
        formTest_1.setComments("comments formTest1");


        formTest_2.setPurchaseValue(200);
        formTest_2.setFormType(Constants.EXPENSE_FORM_TYPE);
        formTest_2.setSource("fuente testForm_2");
        formTest_2.setMotive("Compra Activo");
        formTest_2.setAsset(assetTest_3);
        formTest_2.setComments("comments formTest2");



        Manager.switchFinancialSpaceByID(0x2);

        formTest_3.setPurchaseValue(300);
        formTest_3.setFormType(Constants.EXPENSE_FORM_TYPE);
        formTest_3.setSource("fuente testForm_3");
        formTest_3.setMotive("compra Activo");
        formTest_3.setAsset(assetTest_4);
        assetTest_4.setPurchaseValue(formTest_3.getPurchaseValue());
        formTest_3.setComments("comments formTest3");


        formTest_4.setPurchaseValue(400);
        formTest_4.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_4.setSource("fuente testForm_4");
        formTest_4.setMotive("venta Activo");
        formTest_4.setAsset(assetTest_5);
        assetTest_5.setPurchaseValue(formTest_4.getPurchaseValue());
        formTest_4.setComments("comments formTest4");


        formTest_5.setPurchaseValue(500);
        formTest_5.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_5.setSource("fuente testForm_5");
        formTest_5.setMotive("nuevo pasivo");
        formTest_5.setPasive(pasiveTest_1);
        formTest_5.setComments("comments formTest5");


        Manager.switchFinancialSpaceByID(0x3);

        formTest_6.setPurchaseValue(600);
        formTest_6.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_6.setSource("fuente testForm_6");
        formTest_6.setMotive("pago pasivo");
        formTest_6.setPasive(pasiveTest_2);
        formTest_6.setComments("comments formTest6");


        formTest_7.setPurchaseValue(700);
        formTest_7.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_7.setSource("fuente testForm_7");
        formTest_7.setMotive("pago pasivo");
        formTest_7.setPasive(pasiveTest_3);
        formTest_7.setComments("comments formTest7");


        formTest_8.setPurchaseValue(800);
        formTest_8.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_8.setSource("fuente testForm_8");
        formTest_8.setMotive("nuevo pasivo");
        formTest_8.setPasive(pasiveTest_4);
        formTest_8.setComments("comments formTest8");
        Manager.switchFinancialSpaceByID(0x4);

        formTest_9.setPurchaseValue(900);
        formTest_9.setFormType(Constants.RENEUE_FORM_TYPE);
        formTest_9.setSource("fuente testForm_9");
        formTest_9.setMotive("nuevo pasivo");
        formTest_9.setPasive(pasiveTest_5);
        formTest_9.setComments("comments formTest9");



    }

    public EJEMPLO() {
        setExampleGeneralRegistry();
    }
}
