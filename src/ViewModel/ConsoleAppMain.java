package ViewModel;
//import Model.EJEMPLO;
import Model.GeneralRegistry;
import Model.TestData.AssetsTests;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ConsoleAppMain {
   // static EJEMPLO ejemplo =new EJEMPLO();

    public static void main(String[] args) {
        //ejemplo.setExampleGeneralRegistry();
        AssetsTests assetsTests = new AssetsTests();
        ArrayList<FinancialSpace> financialSpacesInDB = Manager.getAllFinancialSpaces();
        User usuarioLogeado= new User();
        System.out.println("bienvenido, selecciona un espacio financiero");
        printFinancialSpacesinDB(financialSpacesInDB);
        selectFinancialSpace(usuarioLogeado,financialSpacesInDB);
        System.out.println("usted puede ir a las siguientes secciones");
        printBarraLateral();
        Scanner s = new Scanner(System.in);
        int seleccion;
        do {
            seleccion = s.nextInt();
            switch (seleccion) {
                case 1 -> mostrarHome(usuarioLogeado);
                case 2 -> mostrarCashflow();
                case 3 -> mostrarActivos();

                case 4 -> mostrarPasivos();
                case 5 -> mostrarEstadisticas(usuarioLogeado);
                case 6 -> mostrarCondicionesTributarias();
                case 7 -> mostrarInventario();
                case 8 -> changeFinancialSpace();
                default -> {
                }
            }
            printBarraLateral();


        }while (seleccion!=9);
    }

    private static void changeFinancialSpace() {
    }

    private static void mostrarCondicionesTributarias() {
    }

    private static void agregarNuevoRegistro(boolean selecc) {
    }

    private static void mostrarInventario() {
        //mostrar todos el inventario del espacio financiero
        for (Inventory inv: new GeneralRegistry().getAllInventory()
             ) {
            System.out.println(
                    "id: " +" "+ inv.getId()+" "+
                            "nombre: " +" "+ inv.getName()+" "+
                            "descripcion: " +" "+ inv.getDescription()+" "+
                            "tipo: " +" "+ inv.getType() +" "+
                            "categoría: " +" "+ inv.getCategory() +" "+
                            "valor por unidad: " +" "+ inv.getUnitValue() +" "+
                            "unidades en stock" +" " + inv.getStockNumber()+ " " +
                            "numero de venta" + " " + inv.getSaleNumbers()
            );
            System.out.println();
        }
    }

    private static void mostrarEstadisticas(User usuarioLogeado) {
        usuarioLogeado.printAllStats();

        // mostrar todas las estadisticas con su significado
    }

    private static void mostrarPasivos() {
        //mostrar todos los pasivos del espacio financiero
        for (Pasives pasive : new GeneralRegistry().getAllPasives()
                ) {
            System.out.println(
                    "id: "+" "+pasive.getId()+" "+
                    "nombre: " +" "+pasive.getName()+" "+
                            "deudor: "+" "+pasive.getDeudor()+" "+
                            "tipo: " +" "+ pasive.getType() +" "+
                            "descripción: "+" "+pasive.getDescription()+" "+
                            "porcentaje de interés: "+" "+pasive.getInterestPercentage()+" "+
                            "tipo de interés: "+" "+ pasive.getSaldoDeuda()+" "+
                            "numero de cuotas"+" "+pasive.getNumberOfInstallments()+" "+
                            "valor de cada cuota"+" "+pasive.getInstallmentValue()+" "+
                            "siguiente fecha de pago"+" "+pasive.getPaymentdDate()
            );
        }
    }

    private static void mostrarActivos() {
        //mostrar todos los activos del espacio financiero
        for (Assets asset: new GeneralRegistry().getAllAssets()
             ) {
            System.out.println(
                    "id: " +" "+ asset.getId()+" "+
                            "nombre: " +" "+ asset.getName()+" "+
                            "descripcion: " +" "+ asset.getDescription()+" "+
                            "tipo: " +" "+ asset.getType() +" "+
                            "% rentabilidad: " +" "+ asset.getRentability()
            );
        }
    }

    private static void mostrarCashflow() {
        //tomar registros por día y:
        // mostrar saldo inicial
        //mostar ingresos y egresos del día
        //sumar all
        //mostar saldo del día anterior
        //repetir para una semana

    }

    private static void mostrarHome(User usuarioLogeado) {
        // mostrar patrimonio neto
        System.out.println("Patrimonio neto: "+usuarioLogeado.getNetWorth());
        // mostrar deuda más cara
        System.out.println("Deuda más álta: "+Pasives.getPasivoMasCaro());
        //Ingresos totales sorteados por motivo
        ArrayList<Form>allRevenueFormsInDB = new GeneralRegistry().getAllRevenuesForms();
        System.out.println("ingresos sorteados por categoria");
        printRevenuesByMotive(allRevenueFormsInDB);
        //egresos totales sorteados por motivo
        System.out.println("egresos sorteados por categoria");
        printExpensesByMotive(allRevenueFormsInDB);
        System.out.println("\n1. Hacer un nuevo registro"+"\n"+ "2.volver");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        //agregar nuevo registro
        if (opcion == 1)makeNewRegistry();



    }

    private static void makeNewRegistry() {
        System.out.println("haz hecho un registro... en mi corazón");
    }

    private static /*HashMap<String,Integer>*/void printRevenuesByMotive(ArrayList<Form> allRevenueForms) {
        HashMap<String,Integer> revenuesByMotive= new HashMap<>();
        String key;
        int saldo;
        while (!allRevenueForms.isEmpty()){
            if (revenuesByMotive.containsKey(allRevenueForms.get(0).getMotive())){
                key = allRevenueForms.get(0).getMotive();
                saldo = revenuesByMotive.get(key);
                revenuesByMotive.replace(key,saldo,saldo+allRevenueForms.get(0).getPurchaseValue());
            }else revenuesByMotive.put(allRevenueForms.get(0).getMotive(), allRevenueForms.get(0).getPurchaseValue());
            allRevenueForms.remove(0);
        }//return revenuesByMotive;
        System.out.println(revenuesByMotive.toString());
    }
    private static void printExpensesByMotive(ArrayList<Form> allExpenseFormsInDB) {
        HashMap<String,Integer> expensesByMotive= new HashMap<>();
        String key;
        int saldo;
        while (!allExpenseFormsInDB.isEmpty()){
            if (expensesByMotive.containsKey(allExpenseFormsInDB.get(0).getMotive())){
                key = allExpenseFormsInDB.get(0).getMotive();
                saldo = expensesByMotive.get(key);
                expensesByMotive.replace(key,saldo,saldo+allExpenseFormsInDB.get(0).getPurchaseValue());
            }else expensesByMotive.put(allExpenseFormsInDB.get(0).getMotive(), allExpenseFormsInDB.get(0).getPurchaseValue());
            allExpenseFormsInDB.remove(0);
        }//return revenuesByMotive;
        System.out.println(expensesByMotive.toString());
    }

    private static void printBarraLateral() {
        System.out.println("1. ir al HOME");
        System.out.println("2. ver flujo de caja");
        System.out.println("3. ver activos");
        System.out.println("4. ver pasivos");
        System.out.println("5. ver estadísticas");
        System.out.println("6. ver condiciones tributarias");
        if (Manager.getFinEspId()!=0){
            System.out.println("7. ver inventario");
        }else System.out.println("7. inventario no disponible");
        System.out.println("8. seleccionar otro espacio fianaciero");
        System.out.println("9. cerrar programa");
    }

    private static void selectFinancialSpace(User usuarioLogeado, ArrayList<FinancialSpace> financialSpacesInDB) {
        Scanner input;
        int espacio;
        do {
            input = new Scanner(System.in);
            espacio = input.nextInt();
        }while (espacio > financialSpacesInDB.size());

        Iterator<FinancialSpace>financialSpaceIterator = financialSpacesInDB.iterator();
        FinancialSpace financialSpaceSelected = new FinancialSpace();
        while (financialSpaceIterator.hasNext()){
            financialSpaceSelected = financialSpaceIterator.next();
            if(financialSpaceSelected.getId() == espacio) break;
        }
        usuarioLogeado.openFinancialSpace(financialSpaceSelected);
        System.out.println("usted entró a su espacio financiero: " +financialSpaceSelected.getName());
    }

    private static void printFinancialSpacesinDB(ArrayList<FinancialSpace> financialSpacesInDB) {
        Iterator<FinancialSpace>financialSpaceIterator= financialSpacesInDB.iterator();
        FinancialSpace financialSpace;
        while (financialSpaceIterator.hasNext()){
            financialSpace = financialSpaceIterator.next();
            System.out.println(financialSpace.getId() + ". " + financialSpace.getName());

        }
    }
}
