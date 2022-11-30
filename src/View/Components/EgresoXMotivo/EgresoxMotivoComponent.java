package View.Components.EgresoXMotivo;

import View.Components.IngresoxMotivo.IngresosxMotivoTemplate;
import View.Components.ModelAux.EgresoXMotivo;
import View.Components.ModelAux.IngresoxMotivo;
import View.Components.ModelAux.Services.EgresoXMotivoServices;
import View.Components.ModelAux.Services.IngresosxMotivoService;
import View.MainPanel.MainPanelComponent;
import View.Services.RecursosService;
import ViewModel.Stats;
import ViewModel.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.Map;

public class EgresoxMotivoComponent implements ActionListener, MouseListener, FocusListener {

   private EgresoXMotivoTemplate egresoXMotivoTemplate;

   private MainPanelComponent mainPanelComponent;

   private EgresoXMotivoServices egresoXMotivoServices;

   private EgresoXMotivo egresoXMotivo;

   private User user = new User();

    private String [] placeHolers = {"Egreso", "Motivo", "Filtrar"};

    public EgresoxMotivoComponent (MainPanelComponent mainPanelComponent){

       this.egresoXMotivoTemplate = new EgresoXMotivoTemplate(this);
       this.mainPanelComponent = mainPanelComponent;
       this.egresoXMotivoServices = EgresoXMotivoServices.getService();

   }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == egresoXMotivoTemplate.getbShow()){
            showRegistros();
            System.out.println(user.getTotalRevenuesByMotive().toString());
            System.out.println(user.getTotalExpensesByMotive().toString());
        } else if (e.getSource() == egresoXMotivoTemplate.getbInsert()){
            insertDataTable();
        } else if (e.getSource() == egresoXMotivoTemplate.getbModify()){
            modifyDataTable();
        } else if (e.getSource() == egresoXMotivoTemplate.getbDelete()){
            deleteDataTable();
        } else if (e.getSource() == egresoXMotivoTemplate.getbFiltrar()){
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
            int row = egresoXMotivoTemplate.getTable().getSelectedRow();
            egresoXMotivo = egresoXMotivoServices.devolverEgresoxMotivo(row);
            egresoXMotivoTemplate.getlIdValue().setText(egresoXMotivo.getIdEgreso()+"");;
            egresoXMotivoTemplate.gettEgreso().setText(egresoXMotivo.getEgreso());
            egresoXMotivoTemplate.gettMotivo().setText(egresoXMotivo.getMotivoEgreso());

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

        egresoXMotivoTemplate.getlIdValue().setText(egresoXMotivoServices.devolverCantidadEgresosxMotivo()+"");
        egresoXMotivoTemplate.gettEgreso().setText(placeHolers[1]);
        egresoXMotivoTemplate.gettMotivo().setText(placeHolers[2]);

    }

    public void showRegistros(){

       this.addDta(user);

        egresoXMotivoTemplate.getlIdValue().setText("");
        egresoXMotivoTemplate.getbShow().setEnabled(false);
    }

    public void insertDataTable (){

        egresoXMotivo = new EgresoXMotivo();
        egresoXMotivo .setIdEgreso(egresoXMotivoServices.devolverCantidadEgresosxMotivo());
        egresoXMotivo .setEgreso(egresoXMotivoTemplate.gettEgreso().getText());
        egresoXMotivo .setMotivoEgreso(egresoXMotivoTemplate.gettMotivo().getText());
        //this.addDta(egresoXMotivo);
        resetValues();


    }

    public void modifyDataTable (){

        int filaSelected = egresoXMotivoTemplate.getTable().getSelectedRow();
        if (filaSelected !=-1){
            egresoXMotivoTemplate.getModelEgresos().setValueAt(
                    egresoXMotivoTemplate.gettEgreso().getText(), filaSelected, 1);
            egresoXMotivoTemplate.getModelEgresos().setValueAt(
                    egresoXMotivoTemplate.gettMotivo().getText(), filaSelected, 2);

        }else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error" , JOptionPane.ERROR_MESSAGE);
        }


    }
    public void deleteDataTable (){

        int filaSelect = egresoXMotivoTemplate.getTable().getSelectedRow();
        if (filaSelect != -1){
            egresoXMotivoTemplate.getModelEgresos().removeRow(filaSelect);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "Error" , JOptionPane.ERROR_MESSAGE);
        }
    }

    public void filterDataTable (){

        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(egresoXMotivoTemplate.getModelEgresos());
        egresoXMotivoTemplate.getTable().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(egresoXMotivoTemplate.gettConsult().getText()));
    }

    public void addDta (User user){

        for (Map.Entry<?,?> entry : user.getTotalExpensesByMotive().entrySet())
        egresoXMotivoTemplate.getModelEgresos().addRow(
                new Object[]{entry.getValue(), entry.getKey()}
        );
    }

    public EgresoXMotivoTemplate getEgresoXMotivoTemplate() {
        return egresoXMotivoTemplate;
    }
}
