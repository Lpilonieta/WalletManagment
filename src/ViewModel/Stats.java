package ViewModel;

import Model.GeneralRegistry;

public class Stats implements Liquidity, Solvency, Rentability{
    public static float getNetWorth() {
        return netWorth;
    }

    public static void setNetWorth(float networth) {
        netWorth=networth;
    }

    //stats generales
    public  static float netWorth;
    private float totalRevenue;
    private float totalExpenses;


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


    public Stats() {
        calculateTotalRevenue();
        calculateTotalExpenses();
        calculateNethWorth();
        this.fondoDeManiobra = calculateFondoDeManiobra();
        this.razonCorriente = calculateRazonCorriente();
        this.pruebaAcida = calculatePruebaAcida();
        this.endeudamientoTotal = calcEndeudamientoTotal();
        this.endeudamientoCortoPlazo = calcEndeudamientoCP();
        this.endeudamientoLargoPlazo = calcEndeudamientoLP();
        this.apalancamientoTotal = calcApalancamientoTotal();
        this.margenDeUtilidadBruta = calcMargenDeUtilidadBruta();
        this.rentabilidadSobrePatrimonio = calcRentabilidadSobrePatrimonio();
        this.rentabilidadSobreActivos = calcRentabilidadSobreActivos();
        this.rentabilidadSobreVentas = calcRentabilidadSobreVentas();   //check 'til here
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
}
