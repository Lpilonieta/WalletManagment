package View.Components.CashFlowTable;

import View.MainPanel.MainPanelComponent;
import ViewModel.WeeklyCashFlow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Map;

public class CashFlowTableComponent implements ActionListener, MouseListener, FocusListener {

    private CashFlowTableTemplate cashFlowTableTemplate;

    private MainPanelComponent mainPanelComponent;

    private WeeklyCashFlow weeklyCashFlow;

    public CashFlowTableComponent (MainPanelComponent mainPanelComponent){

        this.cashFlowTableTemplate = new CashFlowTableTemplate(this);
        this.mainPanelComponent = mainPanelComponent;
        try {
            this.weeklyCashFlow = new WeeklyCashFlow("3-30-11-2022");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public CashFlowTableTemplate getCashFlowTableTemplate() {
        return cashFlowTableTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cashFlowTableTemplate.getbShow()){
            showRegistros();
        } else if (e.getSource() == cashFlowTableTemplate.getbFiltrar()){
            filterDataTable();
        }

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
    public void showRegistros(){

        this.addDta(weeklyCashFlow);

        cashFlowTableTemplate.getlIdValue().setText(weeklyCashFlow.getWeeklyCashFlow().size()+"");
        cashFlowTableTemplate.getbShow().setEnabled(false);
    }
    public void filterDataTable (){

        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(cashFlowTableTemplate.getModel());
        cashFlowTableTemplate.getTable().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(cashFlowTableTemplate.gettConsult().getText()));
    }
    public void addDta (WeeklyCashFlow weeklyCashFlow){

        for (Map.Entry<?,?> entry : weeklyCashFlow.getWeeklyCashFlow().entrySet())
            cashFlowTableTemplate.getModel().addRow(
                    new Object[]{weeklyCashFlow.getLunes().getExpensesValues().toString(), weeklyCashFlow.getMartes(), weeklyCashFlow.getMiercoles(), weeklyCashFlow.getJueves(),
                            weeklyCashFlow.getViernes(), weeklyCashFlow.getSabado(),weeklyCashFlow.getDomingo()}
        );
    }
}
