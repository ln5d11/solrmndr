package ru.solrmndr.frames;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class TableModel extends JTable {

    DefaultTableModel tableModel = new DefaultTableModel();

    String[] columnNames = {"Название раствора", "Концентрация", "Ед. измерения", "Дата изготовления", "Годен до",
            "Особые условия", " "};

    Object[] data = {"C2H5OH", "10%", "ml", "21.12.15", "30.01.16", "-", " "};

    public TableModel() {
        setModel(tableModel);
        initColumns();
        tableModel.addRow(data);
        setUpUnitCol(getColumnModel().getColumn(2));
        getColumnModel().getColumn(3).setCellEditor(getDateCellEditor());
        getColumnModel().getColumn(4).setCellEditor(getDateCellEditor());
        setUpConditionCol(getColumnModel().getColumn(5));
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
        final InputVerifier dateVerifyer = getDateVerifyer();
        DefaultCellEditor editor = new DefaultCellEditor(new JTextField()) {
            {
                getComponent().setInputVerifier(dateVerifyer);
            }

            @Override
            public boolean stopCellEditing() {
                if (!dateVerifyer.shouldYieldFocus(getComponent())) {
                    return false;
                }
                return super.stopCellEditing();
            }

            @Override
            public JTextField getComponent() {
                return (JTextField) super.getComponent();
            }

        };
        return editor;
    }

    private InputVerifier getDateVerifyer() {
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