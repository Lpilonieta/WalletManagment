package Model;

import Fragment.Assets;

import java.util.HashMap;

public class AssetsRegistry {
    private static HashMap <String, Assets> ASSETS_REGISTRY = new HashMap<>();
    public static void addNewAssetRegistry(String key, Assets value){
        ASSETS_REGISTRY.put(key, value);
    }

    public static HashMap<String, Assets> getAssetsRegistry() {
        return ASSETS_REGISTRY;
    }
}
