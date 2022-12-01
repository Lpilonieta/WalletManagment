package View.Components.CashFlowTable;

import View.MainPanel.MainPanelComponent;
import ViewModel.DailyCashFlow;
import ViewModel.Form;
import ViewModel.WeeklyCashFlow;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CashFlowTableComponent implements ActionListener, MouseListener, FocusListener {

    private CashFlowTableTemplate cashFlowTableTemplate;

    private MainPanelComponent mainPanelComponent;

    private WeeklyCashFlow weeklyCashFlow;

    private DailyCashFlow dailyCashFlow = new DailyCashFlow();

    public CashFlowTableComponent(MainPanelComponent mainPanelComponent) {

        this.cashFlowTableTemplate = new CashFlowTableTemplate(this);

        this.mainPanelComponent = mainPanelComponent;

    }

    public CashFlowTableTemplate getCashFlowTableTemplate() {
        return cashFlowTableTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cashFlowTableTemplate.getbShow()) {
            showRegistros();
        } else if (e.getSource() == cashFlowTableTemplate.getbFiltrar()) {
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

    public void showRegistros() {

       // this.addDta(weeklyCashFlow);


        //cashFlowTableTemplate.getlIdValue().setText(weeklyCashFlow.getWeeklyCashFlow().size() + "");
        //cashFlowTableTemplate.gettSaldoIncial().setText(weeklyCashFlow.getLunes().getSaldoInicial());
        //cashFlowTableTemplate.gettSaldoFinal().setText(weeklyCashFlow.getLunes().getSaldoFinal());
        //cashFlowTableTemplate.getbShow().setEnabled(false);

        cashFlowTableTemplate.getlIdValue().setText("");
        cashFlowTableTemplate.gettSaldoIncial().setText(dailyCashFlow.getSaldoInicial());
        cashFlowTableTemplate.gettSaldoFinal().setText(dailyCashFlow.getSaldoFinal());
        cashFlowTableTemplate.getbShow().setEnabled(false);

    }

    public void filterDataTable() {

        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(cashFlowTableTemplate.getModel());
        cashFlowTableTemplate.getTable().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(cashFlowTableTemplate.gettConsult().getText()));
    }

    public void addDta(WeeklyCashFlow weeklyCashFlow) {

        ArrayList<String> column = null;
        String dateByDefault;

        if (cashFlowTableTemplate.gettConsult().getText() != null){
            dateByDefault = cashFlowTableTemplate.gettConsult().getText();
            System.out.println(dateByDefault);
        }  else {
            dateByDefault = Form.parseDatetoString();
        }

        try {
            column = new DailyCashFlow(dateByDefault).getTotalValues();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Coloca un elemento para filtrar", "ALERTA", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
        Map<String, String> mapTemp = new HashMap<>();
        for (String value :
                column) {
            mapTemp.clear();
            mapTemp.put("key", value);
            //TODO: map temp tiene una clave y un valor


            cashFlowTableTemplate.getModel().addRow(
                        new Object[]{mapTemp.get("key")}
                );
        }

    }
}




