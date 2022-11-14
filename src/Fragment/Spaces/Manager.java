package Fragment.Spaces;

import Fragment.Constants;

public class Manager {
    private static int id = Constants.NONE;
    public static int getFinEspId(){
        if (id == Constants.NONE){
            id = getIdFromDb();
        }
        return id;
    }

    private static int getIdFromDb() {
        return 0;
    }
}
