package Fragment;

import Fragment.Spaces.Manager;

public class User {
    private static int financialSpaceID;
    private static float netWorth = 0;

    public static int getFinancialSpaceID() {
        return Manager.getFinEspId();
    }

    public static void setNetWorth(float netWorth) {
        User.netWorth = netWorth;
    }

    public static float getNetWorth() {
        return netWorth;
    }
}
