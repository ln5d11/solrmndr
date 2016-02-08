package ru.solrmndr.frames;

import ru.solrmndr.controller.TableDataController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.IOException;
import java.util.ArrayList;

public class TableModel extends JTable {

    DefaultTableModel tableModel = new DefaultTableModel();

    String[] columnNames = {"Название раствора", "Концентрация", "Ед. измерения", "Дата изготовления", "Годен до",
            "Особые условия", " "};

    public TableModel() {
        setModel(tableModel);
        initColumns();
        setUpUnitCol(getColumnModel().getColumn(2));
        getColumnModel().getColumn(3).setCellEditor(getDateCellEditor());
        getColumnModel().getColumn(4).setCellEditor(getDateCellEditor());
        setUpConditionCol(getColumnModel().getColumn(5));
        prepareData();
    }

    public void prepareToSaveData() {
        ArrayList<String> rows = new ArrayList<String>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            ArrayList<String> rowlist = new ArrayList<String>();
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                if ((tableModel.getValueAt(i, j) != null)) {
                    rowlist.add((String) tableModel.getValueAt(i, j));
                } else {
                    rowlist.add(" ");
                }
            }
            String listString = "";
                for (String s : rowlist) {
                    listString += s + ", ";
                }
            rows.add(listString);
            //  rows.add("\n");
        }
        String complete = "";
        for (String s : rows) {
            complete += s;
        }
        TableDataController.saveData(complete);
    }


    private void prepareData() {
        try {
            for(String[] data : TableDataController.loadData()) {
                tableModel.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEmptyRow() {
        tableModel.addRow(new String[]{"", "", "", "", "", "", ""});
    }

    private void initColumns() {
        for(String colName : columnNames) {
            tableModel.addColumn(colName);
        }
    }

    public void setUpConditionCol(TableColumn condCol){
        JComboBox condBox = new JComboBox();
        condBox.addItem("-");
        condBox.addItem("Холодильник");
        condBox.addItem("Вытяжка");
        condCol.setCellEditor(new DefaultCellEditor(condBox));
    }

    public void setUpUnitCol(TableColumn unitCol) {
        JComboBox unitBox = new JComboBox();
        unitBox.addItem("мг/л");
        unitBox.addItem("мг/дм^3");
        unitBox.addItem("моль/дм^3");
        unitBox.addItem("ммоль/дм^3");
        unitBox.addItem("мг/см^3");
        unitCol.setCellEditor(new DefaultCellEditor(unitBox));
    }

    private DefaultCellEditor getDateCellEditor() {
        final InputVerifier dateVerifier = getDateVerifier();
        return new DefaultCellEditor(new JTextField()) {
            {
                getComponent().setInputVerifier(dateVerifier);
            }

            @Override
            public boolean stopCellEditing() {
                return dateVerifier.shouldYieldFocus(getComponent()) && super.stopCellEditing();
            }

            @Override
            public JTextField getComponent() {
                return (JTextField) super.getComponent();
            }

        };
    }

    private InputVerifier getDateVerifier() {
        final String dateRegEx = "(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(19|20)\\d\\d";
        return new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField field = (JTextField) input;
                String text = field.getText();
                return text.matches(dateRegEx) || text.isEmpty();
            }

            @Override
            public boolean shouldYieldFocus(JComponent input) {
                if (!verify(input)) {
                    ((JTextField) input).setText("");
                    JOptionPane.showMessageDialog(null, "Введите дату в формате дд.мм.гггг");
                }
                return true;
            }
        };
    }

}