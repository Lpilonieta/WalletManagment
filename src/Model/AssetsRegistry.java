package Model;

import Fragment.Assets;
import Fragment.Form;

import java.util.HashMap;

public class AssetsRegistry {

    private static HashMap <String, Assets> ASSETS_REGISTRY = new HashMap<>();
    private static HashMap <String, Assets> INVENTORY_REGISTRY = new HashMap<>();
    public static void addNewAssetRegistry(String key, Assets value){
        ASSETS_REGISTRY.put(key, value);
    }
    public static void addNewItemToInventory(String key, Assets value){
        INVENTORY_REGISTRY.put(key, value);
    }

    public static void addUnitsToItems(Assets inventoryItem, int numberToAdd){inventoryItem.setStockNumber(inventoryItem.getStockNumber()+numberToAdd);}

    public static HashMap<String, Assets> getAssetsRegistry() {
        return ASSETS_REGISTRY;
    }

    public static void saveAsset(Form form) {
        ASSETS_REGISTRY.put(form.getId(), form.getAsset());
    }
}
