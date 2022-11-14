package Model;

import Fragment.Assets;
import Fragment.Constants;
import Fragment.Form;
import Fragment.Pasives;

import java.util.HashMap;

public class GeneralRegistry {
    // assets de ejemplo
    private Assets assetTest_1 = new Assets("","name asset test 1","description AssetTest1",0, Constants.CURRENT,0,80, Constants.NONE);
    private Assets assetTest_2 = new Assets("","name asset test 2","description AssetTest2",0,Constants.CURRENT,0,180, Constants.NONE);
    private Assets assetTest_3 = new Assets("","name asset test 3","description AssetTest3",0,Constants.NO_CURRENT,5,500, Constants.NONE);
    private Assets assetTest_4 = new Assets("","name asset test 4","description AssetTest4",0,Constants.CURRENT,0,380, Constants.NONE);
    private Assets assetTest_5 = new Assets("","name asset test 5","description AssetTest5",0,Constants.NO_CURRENT,10,550, Constants.NONE);

    // pasivos de ejemplo
    private Pasives pasiveTest_1 = new Pasives("","name pasiveTest 1","deudor 1", "description pasiveTest 1", 0 , Constants.LINEAL_INTEREST, 1,1,Constants.NO_CURRENT,Constants.MONTHLY,1);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_2 = new Pasives("","name pasiveTest 2","deudor 2", "description pasiveTest 2", 0 , Constants.COMPOUND_INTEREST, 2,2,Constants.CURRENT,Constants.WEEKLY,2);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_3 = new Pasives("","name pasiveTest 3","deudor 3", "description pasiveTest 3", 0 , Constants.LINEAL_INTEREST, 3,3,Constants.CURRENT,Constants.DAILY,3);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_4 = new Pasives("","name pasiveTest 4","deudor 4","description pasiveTest 4", 0 , Constants.COMPOUND_INTEREST, 4,4,Constants.NO_CURRENT,Constants.YEARLY,1);  // TODO: incluir fecha de pago mas cercana al contructor
    private Pasives pasiveTest_5 = new Pasives("","name pasiveTest 5","deudor 5", "description pasiveTest 5", 0 , Constants.LINEAL_INTEREST, 5,5,Constants.CURRENT,Constants.WEEKLY,2);  // TODO: incluir fecha de pago mas cercana al contructor

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

    private void saveForm(Form form) {
        EXAMPLE_GENERAL_REGISTRY.put(form.getId(),form);        //TODO: para dejarlo definitivo solo quitar la parte de "EXAMPLE_"
        if (form.isNeedAssetData()){
            AssetsRegistry.saveAsset(form);
        } else if (form.isNeedPasiveData()) {
            PasivesRegistry.savePasive(form);
        }
    }

    private void setUpForms() {
        formTest_0.getNewId();
        formTest_0.setValue(10);
        formTest_0.setType(Constants.RENEUE_FORM_TYPE);
        formTest_0.setSource("fuente testForm_0");
        formTest_0.setMotive("venta Activo");
        formTest_0.setAsset(assetTest_1);
        assetTest_1.setId(formTest_0.getId());
        assetTest_1.setPurchaseValue(formTest_0.getValue());
        formTest_0.setComments("comments formTest0");

        formTest_1.getNewId();
        formTest_1.setValue(100);
        formTest_1.setType(Constants.RENEUE_FORM_TYPE);
        formTest_1.setSource("fuente testForm_1");
        formTest_1.setMotive("venta Activo");
        formTest_1.setAsset(assetTest_2);
        assetTest_2.setId(formTest_1.getId());
        assetTest_2.setPurchaseValue(formTest_2.getValue());
        formTest_1.setComments("comments formTest1");

        formTest_2.getNewId();
        formTest_2.setValue(200);
        formTest_2.setType(Constants.EXPENSE_FORM_TYPE);
        formTest_2.setSource("fuente testForm_2");
        formTest_2.setMotive("Compra Activo");
        formTest_2.setAsset(assetTest_3);
        assetTest_3.setId(formTest_2.getId());
        formTest_2.setComments("comments formTest2");

        formTest_3.getNewId();
        formTest_3.setValue(300);
        formTest_3.setType(Constants.EXPENSE_FORM_TYPE);
        formTest_3.setSource("fuente testForm_3");
        formTest_3.setMotive("compra Activo");
        formTest_3.setAsset(assetTest_4);
        assetTest_4.setId(formTest_3.getId());
        assetTest_4.setPurchaseValue(formTest_3.getValue());
        formTest_3.setComments("comments formTest3");

        formTest_4.getNewId();
        formTest_4.setValue(400);
        formTest_4.setType(Constants.RENEUE_FORM_TYPE);
        formTest_4.setSource("fuente testForm_4");
        formTest_4.setMotive("venta Activo");
        formTest_4.setAsset(assetTest_5);
        assetTest_5.setId(formTest_4.getId());
        assetTest_5.setPurchaseValue(formTest_4.getValue());
        formTest_4.setComments("comments formTest4");

        formTest_5.getNewId();
        formTest_5.setValue(500);
        formTest_5.setType(Constants.RENEUE_FORM_TYPE);
        formTest_5.setSource("fuente testForm_5");
        formTest_5.setMotive("nuevo pasivo");
        formTest_5.setPasive(pasiveTest_1);
        pasiveTest_1.setId(formTest_5.getId());
        pasiveTest_1.setPurchaseValue(formTest_5.getValue());
        formTest_5.setComments("comments formTest5");

        formTest_6.getNewId();
        formTest_6.setValue(600);
        formTest_6.setType(Constants.RENEUE_FORM_TYPE);
        formTest_6.setSource("fuente testForm_6");
        formTest_6.setMotive("pago pasivo");
        formTest_6.setPasive(pasiveTest_2);
        pasiveTest_2.setId(formTest_6.getId());
        pasiveTest_2.setPurchaseValue(formTest_6.getValue());
        formTest_6.setComments("comments formTest6");

        formTest_7.getNewId();
        formTest_7.setValue(700);
        formTest_7.setType(Constants.RENEUE_FORM_TYPE);
        formTest_7.setSource("fuente testForm_7");
        formTest_7.setMotive("pago pasivo");
        formTest_7.setPasive(pasiveTest_3);
        pasiveTest_3.setId(formTest_7.getId());
        pasiveTest_3.setPurchaseValue(formTest_7.getValue());
        formTest_7.setComments("comments formTest7");

        formTest_8.getNewId();
        formTest_8.setValue(800);
        formTest_8.setType(Constants.RENEUE_FORM_TYPE);
        formTest_8.setSource("fuente testForm_8");
        formTest_8.setMotive("nuevo pasivo");
        formTest_8.setPasive(pasiveTest_4);
        pasiveTest_4.setId(formTest_8.getId());
        pasiveTest_4.setPurchaseValue(formTest_8.getValue());
        formTest_8.setComments("comments formTest8");

        formTest_9.getNewId();
        formTest_9.setValue(900);
        formTest_9.setType(Constants.RENEUE_FORM_TYPE);
        formTest_9.setSource("fuente testForm_9");
        formTest_9.setMotive("nuevo pasivo");
        formTest_9.setPasive(pasiveTest_5);
        pasiveTest_5.setId(formTest_9.getId());
        pasiveTest_5.setPurchaseValue(formTest_9.getValue());
        formTest_9.setComments("comments formTest9");


    }

    public GeneralRegistry() {
        setExampleGeneralRegistry();
    }

    private static HashMap<String, Form> GENERAL_REGISTRY = new HashMap<>();
    private static HashMap<String, Form> EXAMPLE_GENERAL_REGISTRY = new HashMap<>();
    public static void addNewRegistry(String key, Form value){
        GENERAL_REGISTRY.put(key, value);
    }

    public static HashMap<String, Form> getGeneralRegistry() {
        return GENERAL_REGISTRY;
    }
    public static HashMap<String, Form> getExampleGeneralRegistry(){ return EXAMPLE_GENERAL_REGISTRY; }
}
