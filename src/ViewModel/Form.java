package ViewModel;

import ViewModel.Spaces.Manager;

import java.util.Calendar;

public class Form  {
    //forms de ejemplo para db

    private static int lastID=0;

    //Atributos del form
    private Calendar registryDate;
    private String id;
    private int purchaseValue;
    private String source;  // TODO: [ CREAR TABLA EN CONSTANTS ]
    private String motive;  // TODO: cambiar por objeto motivos para gestionar los motivos. [ CREAR TABLA EN CONSTANTS ]
    private String comments;
    private byte formType;
    private boolean needAssetData, needPasiveData;
    private Assets asset;
    private Pasives pasive;
    private int financialSpaceIdRegistered;
    // fin atributos del form


    public int getFinancialSpaceIdRegistered() {
        return financialSpaceIdRegistered;
    }

    // Constructor (s)
    public Form() {
        this.registryDate = Calendar.getInstance();
        this.purchaseValue = 0;
        this.source = "";   //TODO: cambiar por byte [ CREAR TABLA EN CONSTANTS ]
        this.comments = "";
        this.formType = Constants.NONE;
        this.asset = null;
        this.pasive = null;
        this.financialSpaceIdRegistered = Manager.getFinEspId();
//        getNewId();
    }
    public Form(byte type) {
        this.registryDate = Calendar.getInstance();
        this.purchaseValue = 0;
        this.source = "";   //TODO: cambiar por byte [ CREAR TABLA EN CONSTANTS ]
        this.comments = "";
        this.formType = type;
        this.asset = null;
        this.pasive = null;
        this.financialSpaceIdRegistered = Manager.getFinEspId();
//        getNewId();
    }
    //-------------------------------------------------------------------

    public void getNewId() {

        int formType = this.getFormType();
        // numero de registro (hex)
        int numId = lastID;
        lastID+=1;
        // id espacio financiero
        int financialSpaceId = Manager.getFinEspId();


        id = String.valueOf((formType+"-"+numId+"-"+financialSpaceId));


    }

    public byte getFormType() {
        return formType;
    }

    public Assets getAsset() {
        return asset;
    }

    public Pasives getPasive() {
        return pasive;
    }

    public String getId() {
        return id;
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public void setFormType(byte formType) {
        this.formType = formType;
    }

    public void setPurchaseValue(int purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setAsset(Assets asset) {
        needAssetData = true;
        needPasiveData = false;
        this.asset = asset;
    }

    public void setPasive(Pasives pasive) {
        needAssetData = false;
        needPasiveData = true;
        this.pasive = pasive;
    }

    public void setNeedAssetData(int indexThatTriggerAssetForm, int indexSelected) {
        needAssetData = indexThatTriggerAssetForm == indexSelected;

    }

    public void setNeedPasiveData(int indexThatTriggerPasiveForm, int indexSelected) {
        needPasiveData = indexThatTriggerPasiveForm == indexSelected;
    }

    public boolean isNeedAssetData() {
        return needAssetData;
    }

    public boolean isNeedPasiveData() {
        return needPasiveData;
    }
}
