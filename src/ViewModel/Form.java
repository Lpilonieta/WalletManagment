package ViewModel;

import ViewModel.Spaces.Manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Form  {
    //forms de ejemplo para db

    private static int lastID=0;

    //Atributos del form
    private String registryDate;
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

    public Form(byte type) {
        this.formType=type;
    }

    public Form(){

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

    public String getRegistryDate() {
        return registryDate;
    }

    public String parseDatetoString(){
        Date fecha=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");

        String Fecha = dateFormat.format(fecha);

        String date = ((Calendar.getInstance().get(Calendar.DAY_OF_WEEK)+6)%7) +"-"+ Fecha;

        return date;
    }

    public String getSource() {
        return source;
    }

    public String getMotive() {
        return motive;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }
}
