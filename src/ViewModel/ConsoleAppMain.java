package ViewModel;
import Model.EJEMPLO;
import Model.GeneralRegistry;
import ViewModel.Spaces.FinancialSpace;
import ViewModel.Spaces.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleAppMain {
    static EJEMPLO ejemplo =new EJEMPLO();

    public static void main(String[] args) {
        ejemplo.setExampleGeneralRegistry();
        User usuarioLogeado= new User();
        System.out.println("bienvenido, selecciona un espacio financiero");
        printFinancialSpacesinDB();
        selectFinancialSpace(usuarioLogeado);
        System.out.println("usted puede ir a las siguientes secciones");
        printBarraLateral();

        Scanner s = new Scanner(System.in);
        int seleccion;
        do {
            seleccion = s.nextInt();
            switch (seleccion) {
                case 1 -> {
                    mostrarHome();
                    agregarNuevoRegistro(false);
                }
                case 2 -> mostrarCashflow();
                case 3 -> mostrarActivos();

                case 4 -> mostrarPasivos();
                case 5 -> mostrarEstadisticas(usuarioLogeado);
                case 6 -> mostrarInventario();
                default -> {
                }
            }
            printBarraLateral();


        }while (seleccion!=9);
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
                            "tipo de interés: "+" "+ pasive.getInterestType()+" "+
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

    private static void mostrarHome() {
        // mostrar patrimonio neto
        // mostrar deudas cercanas por pagar
        // mostrar deudas atrasadas
        //Ingresos totales sorteados por motivo
        //egresos totales sorteados por motivo
        //agregar nuevo registro


    }

    private static void printBarraLateral() {
        System.out.println("1. ir al HOME");
        System.out.println("2. ver flujo de caja");
        System.out.println("3. ver activos");
        System.out.println("4. ver pasivos");
        System.out.println("5. ver estadísticas");
        if (Manager.getFinEspId()!=0){
            System.out.println("6. ver inventario");
        }
        System.out.println("7. seleccionar otro espacio fianaciero");
        System.out.println("9. cerrar programa");
    }

    private static void selectFinancialSpace(User usuarioLogeado) {
        Scanner input = new Scanner(System.in);
        int espacio = input.nextInt();
        usuarioLogeado.openFinancialSpace(GeneralRegistry.getFinancialSpaceHashMap().get(espacio));
        System.out.println("usted entró a su espacio financiero: " + GeneralRegistry.getFinancialSpaceHashMap().get(espacio).getName());
    }

    private static void printFinancialSpacesinDB() {
        HashMap<Integer,FinancialSpace> financialSpace = GeneralRegistry.getFinancialSpaceHashMap();
        for (FinancialSpace finanSpace: new ArrayList<FinancialSpace>(financialSpace.values())
             ) {

            System.out.println(finanSpace.getId() + ". " + finanSpace.getName());
        }
    }
}
