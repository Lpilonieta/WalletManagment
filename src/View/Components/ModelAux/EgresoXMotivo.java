package View.Components.ModelAux;

public class EgresoXMotivo {

    private int IdEgreso;

    private String egreso, motivoEgreso;

    public int getIdEgreso() {
        return IdEgreso;
    }

    public void setIdEgreso(int idEgreso) {
        IdEgreso = idEgreso;
    }

    public String getEgreso() {
        return egreso;
    }

    public void setEgreso(String egreso) {
        this.egreso = egreso;
    }

    public String getMotivoEgreso() {
        return motivoEgreso;
    }

    public void setMotivoEgreso(String motivoEgreso) {
        this.motivoEgreso = motivoEgreso;
    }
}
