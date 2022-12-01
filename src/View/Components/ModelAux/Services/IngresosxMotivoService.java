package View.Components.ModelAux.Services;

import View.Components.ModelAux.IngresoxMotivo;
import View.Components.ModelAux.Logic.IngresosxMotivoControl;

import java.util.ArrayList;

public class IngresosxMotivoService {

    private static IngresosxMotivoService ingresosxMotivoService;
    private IngresosxMotivoControl ingresosxMotivoControl;
    private ArrayList<IngresoxMotivo> ingresoxMotivos;

    public static IngresosxMotivoService getService (){

        if (ingresosxMotivoService == null) ingresosxMotivoService = new IngresosxMotivoService();
        return ingresosxMotivoService;

    }

    public IngresosxMotivoService (){

    ingresosxMotivoControl = new IngresosxMotivoControl();
    ingresoxMotivos = ingresosxMotivoControl.getIngresoxMotivosArrayList();

    }

    public IngresoxMotivo devolverIngresoxMotivo (int position){
        try {
            return ingresoxMotivos.get(position);
        } catch (Exception e){
            return null;

        }
    }

    public void addIngresoxMotivo (IngresoxMotivo ingresoxMotivo){

        this.ingresoxMotivos.add(ingresoxMotivo);

    }

    public int devolverCantidadIngresosxMotivo (){

        return ingresoxMotivos.size();
    }

}
