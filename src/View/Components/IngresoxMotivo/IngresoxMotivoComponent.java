package View.Components.IngresoxMotivo;

import View.MainPanel.MainPanelComponent;
import View.Components.ModelAux.IngresoxMotivo;
import View.Components.ModelAux.Services.IngresosxMotivoService;
import View.Services.RecursosService;
import ViewModel.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.Map;

public class IngresoxMotivoComponent implements ActionListener, MouseListener, FocusListener {

    private IngresosxMotivoService ingresosxMotivoService;

    private IngresosxMotivoTemplate ingresosxMotivoTemplate;

    private IngresoxMotivo ingresoxMotivo;

    private String[] placeHolers = {"Ingreso", "Motivo", "Filtrar"};

    private User user = new User();


    public IngresoxMotivoComponent(MainPanelComponent mainPanelComponent) {

        this.ingresosxMotivoTemplate = new IngresosxMotivoTemplate(this);
        ingresosxMotivoService = IngresosxMotivoService.getService();

    }

    public IngresosxMotivoTemplate getIngresosxMotivoTemplate() {
        return ingresosxMotivoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ingresosxMotivoTemplate.getbShow()) {
            showRegistros();
        } else if (e.getSource() == ingresosxMotivoTemplate.getbFiltrar()) {
            filterDataTable();
        }

    }

    @Override
    public void focusGained(FocusEvent e) {

        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getbVerde());
        if (
                textField.getText().equals(placeHolers[0]) || textField.getText().equals(placeHolers[1]) || textField.getText().equals(placeHolers[2])
        )
            textField.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {

        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(null);

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

        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorGrisOscuro());
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getMainColor());
        }

    }


    public void showRegistros() {


        this.addDta(user);

        ingresosxMotivoTemplate.getlIdValue().setText(user.getTotalRevenuesByMotive().size()+"");
        ingresosxMotivoTemplate.getbShow().setEnabled(false);
    }

    public void filterDataTable() {

        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(ingresosxMotivoTemplate.getModel());
        ingresosxMotivoTemplate.getTable().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(ingresosxMotivoTemplate.gettConsult().getText()));

    }

    public void addDta(User user) {

        for (Map.Entry<?, ?> entry :user.getTotalRevenuesByMotive().entrySet()) {
            ingresosxMotivoTemplate.getModel().addRow(
                    new Object[]{entry.getValue(), entry.getKey()}
            );
        }
    }
}
