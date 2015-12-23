package ru.solrmndr.frames;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
    String[] columnNames = {"Название раствора", "Концентрация", "Ед. измерения", "Дата изготовления", "Годен до",
            "Особые условия", " "};

    Object[][] data = {
            {"C2H5OH", "10%", "ml", "21.12.15", "30.01.16", "-", " "}
    };

    @Override
    public int getRowCount()
    {return data.length;}

    @Override
    public int getColumnCount()
    {return columnNames.length;}

    @Override
    public Object getValueAt(int row, int column)
    {return data[row][column];}

    @Override
    public String getColumnName(int column)
    {return columnNames[column];}

    @Override
    public Class getColumnClass(int c)
    {return getValueAt(0, c).getClass();}

    @Override
    public boolean isCellEditable(int row, int column)
    {
        if (column == 0 || column == 1)
        {return false;}
        else
        {return true;}
    }
}
