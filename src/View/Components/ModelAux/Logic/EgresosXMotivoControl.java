package View.Components.ModelAux.Logic;

import View.Components.ModelAux.EgresoXMotivo;
import View.Components.ModelAux.IngresoxMotivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class EgresosXMotivoControl {

    private ArrayList<EgresoXMotivo> egresoXMotivosArrayList;

    public EgresosXMotivoControl (){

        egresoXMotivosArrayList = new ArrayList<EgresoXMotivo>();
        cargarDatos();

    }

    public void cargarDatos(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("Archives/EgresoxMotivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                String[] atributos = linea.split(",");
                EgresoXMotivo egresoXMotivo = new EgresoXMotivo();
                egresoXMotivo.setIdEgreso(Integer.parseInt(atributos[0]));
                egresoXMotivo.setEgreso(atributos[1]);
                egresoXMotivo.setMotivoEgreso(atributos[2]);
                egresoXMotivosArrayList.add(egresoXMotivo);
            }
            fr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<EgresoXMotivo> getEgresoXMotivosArrayList() {
        return egresoXMotivosArrayList;
    }
}
