package Fragment;

public class MainForm {
    private static int lastID=0;
    private String id,type,value,source, motive, comments;
    private boolean needAssetData, needPasiveData;
    private Assets asset;
    private Pasives pasive;

    public String getId() {
        return id;
    }

    public String getValue() {
        if (value == ""){
            return "0";
        }else {
        return value;
        }
    }

    public void getNewId() {
        this.id = String.valueOf((lastID+1));
        lastID+=1;

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(String value) {
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
        this.asset = asset;
    }

    public void setPasive(Pasives pasive) {
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
