package ViewModel;

import Model.GeneralRegistry;

public class Stats implements Liquidity, Solvency, Rentability{
    public float getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(float networth) {
        netWorth=networth;
    }

    //stats generales
    private float netWorth;
    private float bruteWorth;
    private float bruteRevenues;
    private float totalRevenue;
    private float totalExpenses;
    private float totalIvaExpenses;
    private float totalIvaRevenue;



    //liquidez
    private float fondoDeManiobra;
    private float razonCorriente;
    private float pruebaAcida;
    //solvencia
    private float endeudamientoTotal;
    private float endeudamientoCortoPlazo;
    private float endeudamientoLargoPlazo;
    private float apalancamientoTotal;
    //rentabilidad
    private float margenDeUtilidadBruta;
    private float rentabilidadSobreActivos;
    private float rentabilidadSobrePatrimonio;
    private float rentabilidadSobreVentas;



    public void calcStats() {
        calculateTotalRevenue();
        calculateTotalExpenses();
        calculateNethWorth();
        calculateBruteWorth();
        calculateBruteRevenues();
        calculateIvaExpenses();
        calculateIvaRevenues();
        fondoDeManiobra = calcWorkingCapital();
        razonCorriente = calcCurrentReason();
        pruebaAcida = calcAcidTest();
        endeudamientoTotal = calcTotalIndebtedness();
        endeudamientoCortoPlazo = calcShortIndebtedness();
        endeudamientoLargoPlazo = calcLongIndebtedness();
        margenDeUtilidadBruta = calcGrossProfitMargin();
        rentabilidadSobrePatrimonio = calcReturnOnEquity();
        rentabilidadSobreActivos = calcRenturnOnAssets();
        rentabilidadSobreVentas = calcRenturnOnSales();   //check 'til here
    }

    private void calculateBruteWorth() {
        bruteWorth = 0;
        for (Form form: new GeneralRegistry().getAllForms()
             ) {
            if (!form.isNeedPasiveData()) {
                bruteWorth+=form.getPurchaseValue();
            }
        }
    }
    private void calculateBruteRevenues() {
        bruteRevenues = 0;
        for (Form form: new GeneralRegistry().getAllForms()
             ) {
            if (form.getFormType() == Constants.RENEUE_FORM_TYPE) {
                bruteRevenues+=form.getPurchaseValue();
            }
        }
    }
    private void calculateIvaRevenues(){
        totalIvaRevenue = 0;
        for (Inventory inventory:new GeneralRegistry().getAllInventory()
             ) {
            totalIvaRevenue += inventory.getSaleNumbers()* inventory.getUnitValue();
        }
    }
    private void calculateIvaExpenses(){
        totalIvaExpenses = 0;
        for (Inventory inventory:new GeneralRegistry().getAllInventory()
        ) {
            totalIvaExpenses += inventory.getPurchaseValue();
        }
    }

    private void calculateNethWorth() {
        netWorth = totalRevenue-totalExpenses;
        if (netWorth<1){
            netWorth=1;
        }
    }

    private void calculateTotalRevenue() {
        for (Form form:new GeneralRegistry().getAllForms()
             ) {
            if (form.getFormType() == Constants.RENEUE_FORM_TYPE){
                totalRevenue+=form.getPurchaseValue();
            }
        }
    }
    private void calculateTotalExpenses() {
        for (Form form:new GeneralRegistry().getAllForms()
             ) {
            if (form.getFormType() == Constants.EXPENSE_FORM_TYPE){
                totalExpenses+=form.getPurchaseValue();
            }
        }
    }

    public void printAllStats(){
        System.out.println("fondo de maniobra: "+ this.fondoDeManiobra);
        System.out.println("razon corriente: "+ this.razonCorriente);
        System.out.println("prueba acida: "+ this.pruebaAcida);
        System.out.println("endeudamiento total: "+ this.endeudamientoTotal);
        System.out.println("endeudamiento corto plazo: "+ this.endeudamientoCortoPlazo);
        System.out.println("endeudamiento largo plazo: "+ this.endeudamientoLargoPlazo);
        System.out.println("apalncamiento total: "+ this.apalancamientoTotal);
//        System.out.println("margen de utilidad bruta: "+ this.margenDeUtilidadBruta);
//        System.out.println("rentabilidad sobre el patrimonio: "+ this.rentabilidadSobrePatrimonio);
//        System.out.println("rentabilidad sobre activos: "+ this.rentabilidadSobreActivos);
//        System.out.println("rentabilidad sobre ventas: "+ this.rentabilidadSobreVentas);
    }

    public float getBruteWorth() {
        return bruteWorth;
    }

    public float getBruteRevenues() {
        return bruteRevenues;
    }

    public float getTotalRevenue() {
        return totalRevenue;
    }

    public float getTotalExpenses() {
        return totalExpenses;
    }

    public float getTotalIvaExpenses() {
        return totalIvaExpenses;
    }

    public float getTotalIvaRevenue() {
        return totalIvaRevenue;
    }

    // @overwrite interfaz Rentabilidad
    @Override
    public float calcGrossProfitMargin() {
        float margenDeUtilidadBruta = 0;        //TODO:  Utilidad Bruta / (ventas Netas*100)
        if (Inventory.calcNetSales() !=Constants.NONE && Inventory.calcBruteUtility() != Constants.NONE){
            margenDeUtilidadBruta += Inventory.calcBruteUtility() / (Inventory.calcNetSales()*100);
        }
        return margenDeUtilidadBruta == 0 ? Constants.NONE : margenDeUtilidadBruta;
    }

    @Override
    public float calcReturnOnEquity() {
        float rentabilidadSobrePatrimonio=0;    //TODO: Utiliad Neta / Patrimonio Neto
        if (Inventory.calcNetUtility() != Constants.NONE && getNetWorth() != Constants.NONE){
            rentabilidadSobrePatrimonio = Inventory.calcNetUtility()/getNetWorth();
        }
        return rentabilidadSobrePatrimonio;
    }

    @Override
    public float calcRenturnOnAssets() {
            float rentabilidadSobreActivos=0;   //TODO: Utiliad Neta / Valor total activos
            if (Inventory.calcNetUtility() !=0 && Assets.getTotalAssetsValue() !=Constants.NONE){
                rentabilidadSobreActivos = Inventory.calcNetUtility()/Assets.getTotalAssetsValue();
            }
            return rentabilidadSobreActivos == 0 ? Constants.NONE : rentabilidadSobreActivos;
    }

    @Override
    public float calcRenturnOnSales() {float rentabilidadSobreVentas = 0;  // TODO: Utiliad Neta / (ventas Netas*100)
        if (Inventory.calcNetUtility() !=Constants.NONE && Inventory.calcNetSales() != Constants.NONE){
            rentabilidadSobreVentas = Inventory.calcNetUtility() / (Inventory.calcNetSales()*100);
        }
        return rentabilidadSobreVentas == 0 ? Constants.NONE : rentabilidadSobreVentas;
    }
    //STATUS
    @Override
    public String statusGrossProfitMargin() {
        String meaning = "Los productos de su inventario le dejan un margen de utilidad Bruta de: ";
        String cant= "No se puede calcular";
        if (calcGrossProfitMargin() == Constants.NONE) return cant;
        return meaning + calcGrossProfitMargin();
    }

    @Override
    public String returnOnEquity() {
        if (calcReturnOnEquity() != Constants.NONE && calcRenturnOnAssets() != Constants.NONE){
            if (calcRenturnOnAssets() == calcReturnOnEquity())return "felicidades, No tiene deudas";
            if (calcRenturnOnAssets()>calcReturnOnEquity())return "El coste medio de sus deudas es mayor que la rentabilidad";
            else return "Tiene una buena rentabilidad financiera";
        }return "No se puede calcular";
    }

    @Override
    public String returnOnAssets() {
        if (calcRenturnOnAssets() != Constants.NONE){
            return calcRenturnOnAssets()<5?"La empresa no es rentable, aún" : "La empresa es rentable";
        }return "no se puede calcular";
    }

    @Override
    public String returnOnSales() {
        if (calcRenturnOnSales() != Constants.NONE) {
            return calcRenturnOnSales()<1?"los gastos son mayores que los benefifios" : "Los beneficios son mayores que los gastos";
        }return "no se puede calcular";
    }

    // @overwrite Solvency
    @Override
    public float calcTotalIndebtedness() {

        float totalIndebtedness = 0;
        if (Pasives.getTotalPasiveValue() != Constants.NONE && Assets.getTotalAssetsValue()!= Constants.NONE)
            totalIndebtedness = Pasives.getTotalPasiveValue() / Assets.getTotalAssetsValue();
        return totalIndebtedness == 0 ? Constants.NONE : totalIndebtedness;
    }

    @Override
    public float calcShortIndebtedness() {
        //TODO: cambiar valor de pasivos corrientes por valor de cuotas de pasivos corrientes.
        float shortIndebtedness = 0;
        if (Pasives.getCurrentPasiveValue() != Constants.NONE && getNetWorth() != Constants.NONE)
            shortIndebtedness =Pasives.getCurrentPasiveValue()/getNetWorth();
        return shortIndebtedness == 0 ? Constants.NONE : shortIndebtedness;
    }

    @Override
    public float calcLongIndebtedness() {

        float longIndebtedness = 0;
        if (Pasives.getNoCurrentPasiveValue()!= Constants.NONE && getNetWorth() != Constants.NONE)
            longIndebtedness = Pasives.getNoCurrentPasiveValue() / getNetWorth();
        return longIndebtedness == 0 ? Constants.NONE : longIndebtedness ;
    }

    //STATUS
    @Override
    public String statusTotalIndebtedness() {
        if (calcTotalIndebtedness() != Constants.NONE){
            String complement = (calcTotalIndebtedness()*100)> 45?" reduzca sus deudas" : ".";
            return "El "+calcTotalIndebtedness()*100+" de sus fondos provienen de recursos Ajenos,"+ complement;
        }return "no se puede calcular";

    }

    @Override
    public String statusShortIndebtedness() {
        if (calcShortIndebtedness() != Constants.NONE){
            return calcShortIndebtedness()<0.2||(0.2>calcShortIndebtedness() &&calcShortIndebtedness()>0.3)
            ? "Podría adquirir mas deudas si lo necesitara":"Debería reducir sus deudas";
        }return "no se puede calcular";
    }

    @Override
    public String statusLongIndebtedness() {
        if (calcLongIndebtedness() !=Constants.NONE){
            return calcLongIndebtedness()>1?"Su liquidez se encuentra en riesgo" : "Su liquidez se encuentra estable";
        }return  " no se puede calcular";
    }


    //@overwrite liquidity
    @Override
    public float calcCurrentReason() {
        float currentReason = 0;
        if (Pasives.getCurrentPasiveValue()!= Constants.NONE && Assets.getCurrentAssetsValue() != Constants.NONE) currentReason = Assets.getCurrentAssetsValue() / Pasives.getCurrentPasiveValue();
        return currentReason == 0 ? Constants.NONE :currentReason;
    }

    @Override
    public float calcAcidTest() {
        float acidTets = 0;
        if (Assets.getCurrentAssetsValue() != Constants.NONE && Inventory.getInventoryValue() != Constants.NONE)
            acidTets = Assets.getCurrentAssetsValue() - Inventory.getInventoryValue();
        return acidTets == 0 ? Constants.NONE : acidTets;
    }

    @Override
    public float calcWorkingCapital() {
        float workingCapital = 0;
        if (Assets.getCurrentAssetsValue()!=Constants.NONE && Pasives.getCurrentPasiveValue() != Constants.NONE) {
            workingCapital = Assets.getCurrentAssetsValue() - Pasives.getCurrentPasiveValue();
        }
        return workingCapital == 0 ? Constants.NONE : workingCapital;
    }
    //STATUS
    @Override
    public String statusCurrentReason() {

        String good = "puede cumplir con las obligaciones a corto plazo";
        String bad =  "puede cumplir con las obligaciones a corto plazo";
        String cant = " no se puede calcular.";
        if (calcCurrentReason()== Constants.NONE){
            return cant;
        }
        return calcCurrentReason() >1 ? good : bad;
    }

    @Override
    public String statusAcidTest() {
        String good = "puede cumplir con las obligaciones a corto plazo";
        String bad =  "puede cumplir con las obligaciones a corto plazo";
        String cant = "No se puede calcular.";
        if (calcAcidTest()== Constants.NONE){
            return cant;
        }
        return calcCurrentReason() >1 ? good : bad;
    }

    @Override
    public String statusWorkingCapital() {
        String good = "Tiene un buen equilibrio financiero";
        String bad = "Su equilibrio financiero se encuentra en peligro";
        String cant = "No se puede calcular";
        if (calcWorkingCapital()==Constants.NONE){
            return cant;
        }return calcWorkingCapital() > 0 ? good : bad;
    }
}
