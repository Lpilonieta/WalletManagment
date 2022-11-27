package Model;

import ViewModel.Assets;
import ViewModel.Constants;
import ViewModel.Form;
import ViewModel.Pasives;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

public class EJEMPLO {

        private final FinancialSpace espacio1 = new FinancialSpace("espacio 1", "grupo 1", 0x1);
        private FinancialSpace espacio2 = new FinancialSpace("espacio 2", "grupo 1", 0x2);
        private FinancialSpace espacio3 = new FinancialSpace("espacio 3", "grupo 2", 0x3);
        private FinancialSpace espacio4 = new FinancialSpace("espacio 4", "sin grupo", 0x4);

        // assets de ejemplo
        public Assets assetTest_1;
        private Assets assetTest_2;
        private Assets assetTest_3;
        private Assets assetTest_4;
        private Assets assetTest_5;

        // pasivos de ejemplo
        public Pasives pasiveTest_1;
        private Pasives pasiveTest_2;
        private Pasives pasiveTest_3;
        private Pasives pasiveTest_4;
        private Pasives pasiveTest_5;

    public void setExampleGeneralRegistry(){
        setUpForms();
        saveForm(assetTest_1);
        saveForm(assetTest_2);
        saveForm(assetTest_3);
        saveForm(assetTest_4);
        saveForm(assetTest_5);
        saveForm(pasiveTest_1);
        saveForm(pasiveTest_2);
        saveForm(pasiveTest_3);
        saveForm(pasiveTest_4);
        saveForm(pasiveTest_5);
    }

    private void saveForm(Form form) {
        GeneralRegistry.getExampleGeneralRegistry().put(form.getId(),form);        //TODO: para dejarlo definitivo solo quitar la parte de "EXAMPLE_"
        if (form.isNeedAssetData()){
            GeneralRegistry.addNewAssetRegistry(form.getAsset().getId(),form.getAsset());
        } else if (form.isNeedPasiveData()) {
            PasivesRegistry.savePasive(form);
        }
    }
    private void saveFormInDB(Form form) {
        GeneralRegistry.getExampleGeneralRegistry().put(form.getId(),form);        //TODO: para dejarlo definitivo solo quitar la parte de "EXAMPLE_"
        if (form.isNeedAssetData()){
            GeneralRegistry.addNewAssetRegistry(form.getAsset().getId(),form.getAsset());
        } else if (form.isNeedPasiveData()) {
            PasivesRegistry.savePasive(form);
        }
    }
    public void setUpForms() {

        assetTest_1 = new Assets(Constants.RENEUE_FORM_TYPE, "name asset test 1", "description AssetTest1", "", Constants.CURRENT, (byte) 0, 80);
        assetTest_1.setPurchaseValue(10);
        assetTest_1.setSource("fuente testForm_0");
        assetTest_1.setMotive("venta Activo");
        assetTest_1.setComments("comments formTest0");


        Manager.switchFinancialSpaceByID(0x1);

        assetTest_2 = new Assets(Constants.RENEUE_FORM_TYPE, "name asset test 2", "description AssetTest2", "", Constants.CURRENT, (byte) 0, 180);
        assetTest_2.setPurchaseValue(100);
        assetTest_2.setSource("fuente testForm_1");
        assetTest_2.setMotive("venta Activo");
        assetTest_2.setComments("comments formTest1");


        assetTest_3 = new Assets(Constants.RENEUE_FORM_TYPE, "name asset test 3", "description AssetTest3", "", Constants.NO_CURRENT, (byte) 5, 500);
        assetTest_3.setPurchaseValue(200);
        assetTest_3.setSource("fuente testForm_2");
        assetTest_3.setMotive("Compra Activo");
        assetTest_3.setComments("comments formTest2");

        Manager.switchFinancialSpaceByID(0x2);

        assetTest_4 = new Assets(Constants.RENEUE_FORM_TYPE, "name asset test 4", "description AssetTest4", "", Constants.CURRENT, (byte) 0, 380);
        assetTest_4.setPurchaseValue(300);
        assetTest_4.setSource("fuente testForm_3");
        assetTest_4.setMotive("compra Activo");
        assetTest_4.setComments("comments formTest3");


        assetTest_5 = new Assets(Constants.RENEUE_FORM_TYPE, "name asset test 5", "description AssetTest5", "", Constants.NO_CURRENT, (byte) 10, 550);
        assetTest_5.setPurchaseValue(400);
        assetTest_5.setSource("fuente testForm_4");
        assetTest_5.setMotive("venta Activo");
        assetTest_5.setComments("comments formTest4");

        pasiveTest_1 = new Pasives(Constants.RENEUE_FORM_TYPE, "name pasiveTest 1", "deudor 1", "description pasiveTest 1", Constants.LINEAL_INTEREST, 1, 1, Constants.NO_CURRENT, Constants.MONTHLY, 1);  // TODO: incluir fecha de pago mas cercana al contructor
        pasiveTest_1.setPurchaseValue(500);
        pasiveTest_1.setSource("fuente testForm_5");
        pasiveTest_1.setMotive("nuevo pasivo");
        pasiveTest_1.setComments("comments formTest5");


        Manager.switchFinancialSpaceByID(0x3);

        pasiveTest_2 = new Pasives(Constants.RENEUE_FORM_TYPE, "name pasiveTest 2", "deudor 2", "description pasiveTest 2", Constants.COMPOUND_INTEREST, 2, 2, Constants.CURRENT, Constants.WEEKLY, 2);  // TODO: incluir fecha de pago mas cercana al contructor
        pasiveTest_2.setPurchaseValue(600);
        pasiveTest_2.setSource("fuente testForm_6");
        pasiveTest_2.setMotive("pago pasivo");
        pasiveTest_2.setComments("comments formTest6");


        pasiveTest_3 = new Pasives(Constants.EXPENSE_FORM_TYPE, "name pasiveTest 3", "deudor 3", "description pasiveTest 3", Constants.LINEAL_INTEREST, 3, 3, Constants.CURRENT, Constants.DAILY, 3);  // TODO: incluir fecha de pago mas cercana al contructor
        pasiveTest_3.setPurchaseValue(700);
        pasiveTest_3.setSource("fuente testForm_7");
        pasiveTest_3.setMotive("pago pasivo");
        pasiveTest_3.setComments("comments formTest7");


        pasiveTest_4 = new Pasives(Constants.EXPENSE_FORM_TYPE, "name pasiveTest 4", "deudor 4", "description pasiveTest 4", Constants.COMPOUND_INTEREST, 4, 4, Constants.NO_CURRENT, Constants.YEARLY, 1);  // TODO: incluir fecha de pago mas cercana al contructor
        pasiveTest_4.setPurchaseValue(800);
        pasiveTest_4.setSource("fuente testForm_8");
        pasiveTest_4.setMotive("nuevo pasivo");
        pasiveTest_4.setComments("comments formTest8");
        Manager.switchFinancialSpaceByID(0x4);

        pasiveTest_5 = new Pasives(Constants.RENEUE_FORM_TYPE, "name pasiveTest 5", "deudor 5", "description pasiveTest 5", Constants.LINEAL_INTEREST, 5, 5, Constants.CURRENT, Constants.WEEKLY, 2);  // TODO: incluir fecha de pago mas cercana al contructor
        pasiveTest_5.setPurchaseValue(900);
        pasiveTest_5.setSource("fuente testForm_9");
        pasiveTest_5.setMotive("nuevo pasivo");
        pasiveTest_5.setComments("comments formTest9");



    }
}
