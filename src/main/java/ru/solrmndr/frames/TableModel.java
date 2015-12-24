package ru.solrmndr.frames;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    String[] columnNames = {"Название раствора", "Концентрация", "Ед. измерения", "Дата изготовления", "Годен до",
            "Особые условия", " "};

    Object[][] data = {
            {"C2H5OH", "10%", "ml", "21.12.15", "30.01.16", "-", " "}
    };

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        super.setValueAt(aValue, rowIndex, columnIndex);
    }
}
