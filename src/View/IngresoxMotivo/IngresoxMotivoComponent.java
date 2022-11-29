package View.IngresoxMotivo;

import View.MainPanel.MainPanelComponent;
import View.Components.ModelAux.IngresoxMotivo;
import View.Components.ModelAux.Services.IngresosxMotivoService;

import java.awt.event.*;

public class IngresoxMotivoComponent implements ActionListener, MouseListener, FocusListener {

    private IngresosxMotivoService ingresosxMotivoService;

    private IngresosxMotivoTemplate ingresosxMotivoTemplate;

    private IngresoxMotivo ingresoxMotivo;

    private String [] placeHolers = {"Ingreso", "Motivo", "Filtrar", "Agregar", "Modificar", "Eliminar", "Buscar"};

    public IngresoxMotivoComponent (MainPanelComponent mainPanelComponent){

        this.ingresosxMotivoTemplate = new IngresosxMotivoTemplate(this);
        ingresosxMotivoService = IngresosxMotivoService.getService();

    }

    public IngresosxMotivoTemplate getIngresosxMotivoTemplate() {
        return ingresosxMotivoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
