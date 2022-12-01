package View.Components.Stats;

import View.Services.ObjGraficosService;
import View.Services.RecursosService;
import ViewModel.Stats;

import javax.swing.*;
import java.awt.*;

public class StatsTemplate extends JPanel {

    private StatsComponent statsComponent;
    private ObjGraficosService objGraficosService;
    private RecursosService recursosService;

    private Stats stats = new Stats();

    private JLabel lTotalIngresos, LTotalEgresos, lNethWorth, lIngresosBrutos,
            lEgresosBrutos, lIvaGastos, lIngresoIva, lFondoDeManiobra, lRazonCorrriente, lPruebaAcida,
            lEndeudamientoTotal,lMargenDeUtilidad, lRentabilidadSobrePatrimonio, lRentabilidadSobreActivos, RentabilidadSobreVentas, title;

    public StatsTemplate (StatsComponent statsComponent){

        this.objGraficosService = ObjGraficosService.getService();
        this.recursosService = RecursosService.getService();
        this.statsComponent = statsComponent;

        this.builtLabels();

        this.setSize(1300, 850);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void builtLabels () {

        this.title = objGraficosService.construirJLabel("Estadisticas financieras", (1300 - 260) / 2 - 200,
                50, 260, 40, Color.DARK_GRAY, null, recursosService.getMainFont(), null, null, null, "null"
        );
        this.add(title);

        this.lTotalIngresos = objGraficosService.construirJLabel("Total ingresos: ", (1300 - 260) / 2 - 200,
                150, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lTotalIngresos);

        this.LTotalEgresos = objGraficosService.construirJLabel("Total egresos: ", (1300 - 260) / 2 - 200,
                200, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(LTotalEgresos );

        this.lNethWorth = objGraficosService.construirJLabel("Neth Worth: ", (1300 - 260) / 2 - 200,
                250, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lNethWorth);

        this.lIngresosBrutos = objGraficosService.construirJLabel("Ingresos brutos: ", (1300 - 260) / 2 - 200,
                300, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lIngresosBrutos);

        this.lEgresosBrutos = objGraficosService.construirJLabel("Egreosos brutos: ", (1300 - 260) / 2 - 200,
                350, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lEgresosBrutos);

        this.lIvaGastos = objGraficosService.construirJLabel("IVA gastos: ", (1300 - 260) / 2 - 200,
                400, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lIvaGastos);

        this.lIngresoIva = objGraficosService.construirJLabel("IVA ingresos: ", (1300 - 260) / 2 - 200,
                450, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lIngresoIva);

        this.lFondoDeManiobra = objGraficosService.construirJLabel("Fondo de maniobra: ", (1300 - 260) / 2 - 200,
                500, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lFondoDeManiobra);

        this.lRazonCorrriente = objGraficosService.construirJLabel("Razón corriente: ", (1300 - 260) / 2 - 200,
                550, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lRazonCorrriente);

        this.lPruebaAcida = objGraficosService.construirJLabel("Prueba ácida: ", (1300 - 260) / 2 - 200,
                600, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lPruebaAcida);

        this.lEndeudamientoTotal = objGraficosService.construirJLabel("Endeudamiento total: ", (1300 - 260) / 2 - 200,
                650, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lEndeudamientoTotal);

        this.lMargenDeUtilidad = objGraficosService.construirJLabel("Margen de utilidad bruta: ", (1300 - 260) / 2 - 200,
                700, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lMargenDeUtilidad);

        this.lRentabilidadSobreActivos = objGraficosService.construirJLabel("Rentabilidad sobre activos: ", (1300 - 260) / 2 - 200,
                750, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        this.add(lRentabilidadSobreActivos);

        this.lRentabilidadSobrePatrimonio = objGraficosService.construirJLabel("Rentabilidad sobre el partrimonio: ", (1300 - 260) / 2 - 200,
                750, 260, 40, Color.DARK_GRAY, null, recursosService.getCursivafont(), null, null, null, "null"
        );
        //this.add(lRentabilidadSobrePatrimonio);

    }

}
