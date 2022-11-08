package Model;

import Fragment.MainForm;

import java.util.HashMap;

public class GeneralRegistry {
    private static HashMap<String, MainForm> GENERAL_REGISTRY = new HashMap<>();
    public static void addNewRegistry(String key, MainForm value){
        GENERAL_REGISTRY.put(key, value);
    }

    public static HashMap<String, MainForm> getGeneralRegistry() {
        return GENERAL_REGISTRY;
    }
}
