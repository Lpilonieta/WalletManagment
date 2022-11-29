package View.Components.ModelAux.Logic;

import View.Components.ModelAux.IngresoxMotivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class IngresosxMotivoControl {

    private ArrayList<IngresoxMotivo> ingresoxMotivosArrayList;

    public IngresosxMotivoControl (){

        ingresoxMotivosArrayList = new ArrayList<IngresoxMotivo>();
        cargarDatos();

    }

    public void cargarDatos(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("Archives/IngresosxMotivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null){
                String[] atributos = linea.split(",");
                IngresoxMotivo ingresoxMotivo = new IngresoxMotivo();
                ingresoxMotivo.setId(Integer.parseInt(atributos[0]));
                ingresoxMotivo.setIngreso(atributos[1]);
                ingresoxMotivo.setMotivo(atributos[2]);
                ingresoxMotivosArrayList.add(ingresoxMotivo);
            }
            fr.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<IngresoxMotivo> getIngresoxMotivosArrayList() {
        return ingresoxMotivosArrayList;
    }
}
