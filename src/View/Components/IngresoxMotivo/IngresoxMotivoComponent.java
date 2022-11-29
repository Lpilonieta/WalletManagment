package View.Components.IngresoxMotivo;

import View.MainPanel.MainPanelComponent;
import View.Components.ModelAux.IngresoxMotivo;
import View.Components.ModelAux.Services.IngresosxMotivoService;
import View.Services.RecursosService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;

public class IngresoxMotivoComponent implements ActionListener, MouseListener, FocusListener {

    private IngresosxMotivoService ingresosxMotivoService;

    private IngresosxMotivoTemplate ingresosxMotivoTemplate;

    private IngresoxMotivo ingresoxMotivo;

    private String [] placeHolers = {"Ingreso", "Motivo", "Filtrar"};

    public IngresoxMotivoComponent (MainPanelComponent mainPanelComponent){

        this.ingresosxMotivoTemplate = new IngresosxMotivoTemplate(this);
        ingresosxMotivoService = IngresosxMotivoService.getService();

    }

    public IngresosxMotivoTemplate getIngresosxMotivoTemplate() {
        return ingresosxMotivoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ingresosxMotivoTemplate.getbShow()){
            showRegistros();
        } else if (e.getSource() == ingresosxMotivoTemplate.getbInsert()){
            insertDataTable();
        } else if (e.getSource() == ingresosxMotivoTemplate.getbModify()){
            modifyDataTable();
        } else if (e.getSource() == ingresosxMotivoTemplate.getbDelete()){
            deleteDataTable();
        } else if (e.getSource() == ingresosxMotivoTemplate.getbFiltrar()){
            filterDataTable();
        }

    }

    @Override
    public void focusGained(FocusEvent e) {

        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getbVerde());
        if(
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
        if (e.getSource() instanceof  JTable){
            int row = ingresosxMotivoTemplate.getTable().getSelectedRow();
            ingresoxMotivo = ingresosxMotivoService.devolverIngresoxMotivo(row);
            ingresosxMotivoTemplate.getlIdValue().setText(ingresoxMotivo.getId()+"");
            ingresosxMotivoTemplate.gettIngreso().setText(ingresoxMotivo.getIngreso());
            ingresosxMotivoTemplate.gettMotivo().setText(ingresoxMotivo.getMotivo());

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if(e.getSource() instanceof JButton){
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorGrisOscuro());
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if(e.getSource() instanceof JButton){
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getMainColor());
        }

    }

    public void resetValues (){

        ingresosxMotivoTemplate.getlIdValue().setText(ingresosxMotivoService.devolverCantidadIngresosxMotivo()+"");
        ingresosxMotivoTemplate.gettIngreso().setText(placeHolers[1]);
        ingresosxMotivoTemplate.gettMotivo().setText(placeHolers[2]);

    }

    public void showRegistros(){

        for (int i = 0; i < ingresosxMotivoService.devolverCantidadIngresosxMotivo(); i++) {
            ingresoxMotivo = ingresosxMotivoService.devolverIngresoxMotivo(i);
            this.addDta(ingresoxMotivo);
        }

        ingresosxMotivoTemplate.getlIdValue().setText(ingresosxMotivoService.devolverCantidadIngresosxMotivo()+"");
        ingresosxMotivoTemplate.getbShow().setEnabled(false);
    }

    public void insertDataTable (){

        ingresoxMotivo = new IngresoxMotivo();
        ingresoxMotivo.setId(ingresosxMotivoService.devolverCantidadIngresosxMotivo());
        ingresoxMotivo.setIngreso(ingresosxMotivoTemplate.gettIngreso().getText());
        ingresoxMotivo.setMotivo(ingresosxMotivoTemplate.gettMotivo().getText());
        this.addDta(ingresoxMotivo);
        resetValues();


    }

    public void modifyDataTable (){

        int filaSelected = ingresosxMotivoTemplate.getTable().getSelectedRow();
        if (filaSelected !=-1){
            ingresosxMotivoTemplate.getModel().setValueAt(
                    ingresosxMotivoTemplate.gettIngreso().getText(), filaSelected, 1);
            ingresosxMotivoTemplate.getModel().setValueAt(
            ingresosxMotivoTemplate.gettMotivo().getText(), filaSelected, 2);

        }else {
             JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error" , JOptionPane.ERROR_MESSAGE);
        }


    }
    public void deleteDataTable (){

        int filaSelect = ingresosxMotivoTemplate.getTable().getSelectedRow();
        if (filaSelect != -1){
            ingresosxMotivoTemplate.getModel().removeRow(filaSelect);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error" , JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filterDataTable (){

        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(ingresosxMotivoTemplate.getModel());
        ingresosxMotivoTemplate.getTable().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(ingresosxMotivoTemplate.gettConsult().getText()));
    }

    public void addDta (IngresoxMotivo ingresoxMotivo){

      ingresosxMotivoTemplate.getModel().addRow(
              new Object[]{ingresoxMotivo.getId(), ingresoxMotivo.getIngreso(), ingresoxMotivo.getMotivo()}
      );
    }
}
