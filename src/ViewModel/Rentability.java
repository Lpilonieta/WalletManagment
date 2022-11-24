package ViewModel;

public interface Rentability {

     static float calcMargenDeUtilidadBruta() {

        float margenDeUtilidadBruta = 0;        //TODO:  Utilidad Bruta / (ventas Netas*100)
        return margenDeUtilidadBruta;
    }

     static float calcRentabilidadSobrePatrimonio() {
        float rentabilidadSobrePatrimonio=0;    //TODO: Utiliad Neta / Patrimonio Neto
        return rentabilidadSobrePatrimonio;
    }
     static float calcRentabilidadSobreActivos() {
        float rentabilidadSobreActivos=0;    //TODO: Utiliad Neta / Valor total activos
        return rentabilidadSobreActivos;
    }

     static float calcRentabilidadSobreVentas() {
        float rentabilidadSobreVentas = 0;  // TODO: Utiliad Neta / (ventas Netas*100)
        return rentabilidadSobreVentas;
    }

}
