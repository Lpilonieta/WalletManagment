package Model;

import ViewModel.Form;
import ViewModel.Pasives;

import java.util.HashMap;

public class PasivesRegistry {

    private static HashMap<String, Pasives> PASIVES_REGISTRY = new HashMap<>();
    public static void addNewPasiveRegistry(String key, Pasives value){
        PASIVES_REGISTRY.put(key, value);
    }

    public static HashMap<String, Pasives> getPasivesRegistry() {
        return PASIVES_REGISTRY;
    }

    public static void savePasive(Form form) {
        PASIVES_REGISTRY.put(form.getId(), form.getPasive());
    }
}
