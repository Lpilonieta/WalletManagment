package Fragment;

import Fragment.Spaces.Manager;

import java.util.Calendar;

public class Form {
    //forms de ejemplo para db

    private static int lastID=0;

    //Atributos del form
    private Calendar registryDate;
    private String id;
    private int value;
    private String source;  // TODO: [ CREAR TABLA EN CONSTANTS ]
    private String motive;  // TODO: cambiar por objeto motivos para gestionar los motivos. [ CREAR TABLA EN CONSTANTS ]
    private String comments;
    private byte type;
    private boolean needAssetData, needPasiveData;
    private Assets asset;
    private Pasives pasive;
    // fin atributos del form

    // Constructor (s)
    public Form() {
        this.registryDate = Calendar.getInstance();
        this.id = "";
        this.value = 0;
        this.source = "";   //TODO: cambiar por byte [ CREAR TABLA EN CONSTANTS ]
        this.comments = "";
        this.type = Constants.NONE;
        this.asset = null;
        this.pasive = null;
    }
    //-------------------------------------------------------------------

    public void getNewId() {

        int formType = this.getType();
        // numero de registro (hex)
        int numId = lastID;
        lastID+=1;
        // id espacio financiero
        int financialSpaceId = Manager.getFinEspId();


        id = String.valueOf((formType+"-"+numId+"-"+financialSpaceId));


    }

    public byte getType() {
        return type;
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

    public int getValue() {
        return value;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
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
        if (indexThatTriggerAssetForm==indexSelected){
            needAssetData = true;
        }else {
            needAssetData=false;
        }

    }

    public void setNeedPasiveData(int indexThatTriggerPasiveForm, int indexSelected) {
        if (indexThatTriggerPasiveForm == indexSelected) {
            needPasiveData = true;

        }else {
            needPasiveData= false;
        }
    }

    public boolean isNeedAssetData() {
        return needAssetData;
    }

    public boolean isNeedPasiveData() {
        return needPasiveData;
    }
}
