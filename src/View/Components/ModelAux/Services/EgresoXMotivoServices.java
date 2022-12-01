package View.Components.ModelAux.Services;

import View.Components.ModelAux.EgresoXMotivo;
import View.Components.ModelAux.IngresoxMotivo;
import View.Components.ModelAux.Logic.EgresosXMotivoControl;
import View.Components.ModelAux.Logic.IngresosxMotivoControl;

import java.util.ArrayList;

public class EgresoXMotivoServices {

    private static EgresoXMotivoServices egresoXMotivoServices;
    private EgresosXMotivoControl egresosXMotivoControl;
    private ArrayList<EgresoXMotivo> egresoXMotivos;

    public static EgresoXMotivoServices getService (){

        if (egresoXMotivoServices == null) egresoXMotivoServices = new EgresoXMotivoServices();
        return egresoXMotivoServices;

    }

    public EgresoXMotivoServices (){

        egresosXMotivoControl= new EgresosXMotivoControl();
        egresoXMotivos= egresosXMotivoControl.getEgresoXMotivosArrayList();

    }

    public EgresoXMotivo devolverEgresoxMotivo (int position){
        try {
            return egresoXMotivos.get(position);
        } catch (Exception e){
            return null;

        }
    }

    public void addEgresoxMotivo (EgresoXMotivo egresoXMotivo){

        this.egresoXMotivos.add(egresoXMotivo);

    }

    public int devolverCantidadEgresosxMotivo (){

        return egresoXMotivos.size();
    }


}
