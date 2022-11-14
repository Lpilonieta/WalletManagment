package Model;

import Fragment.Assets;
import Fragment.Constants;
import Fragment.Form;

import java.util.HashMap;

public class AssetsRegistry {

    private static HashMap <String, Assets> ASSETS_REGISTRY = new HashMap<>();
    public static void addNewAssetRegistry(String key, Assets value){
        ASSETS_REGISTRY.put(key, value);
    }

    public static HashMap<String, Assets> getAssetsRegistry() {
        return ASSETS_REGISTRY;
    }

    public static void saveAsset(Form form) {
        ASSETS_REGISTRY.put(form.getId(), form.getAsset());
    }
}
