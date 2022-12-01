package View.Components.EgresoXMotivo;

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


   private User user = new User();

    private String [] placeHolers = {"Egreso", "Motivo", "Filtrar"};

    public EgresoxMotivoComponent (MainPanelComponent mainPanelComponent){

       this.egresoXMotivoTemplate = new EgresoXMotivoTemplate(this);
       this.mainPanelComponent = mainPanelComponent;

   }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == egresoXMotivoTemplate.getbShow()){
            showRegistros();
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


    public void showRegistros(){

       this.addDta(user);

        egresoXMotivoTemplate.getlIdValue().setText(user.getTotalExpensesByMotive().size()+"");
        egresoXMotivoTemplate.getbShow().setEnabled(false);
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
