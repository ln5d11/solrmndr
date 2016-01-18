package ru.solrmndr.frames;

import javax.swing.*;
import javax.swing.table.*;

public class TableModel extends JTable {

    DefaultTableModel tableModel = new DefaultTableModel();

    String[] columnNames = {"Название раствора", "Концентрация", "Ед. измерения", "Дата изготовления", "Годен до",
            "Особые условия", " "};

    Object[] data = {"C2H5OH", "10%", "мг/л", "11/12/12", "30.01.16", "-", " "};

    private static final String DATE_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)" +
            "(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)" +
            "?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])" +
            "(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public TableModel() {
        setModel(tableModel);
        initColumns();
        //Добавляем тестовую длату, в будующем удалим
        tableModel.addRow(data);
        setUpDateCol(getColumnModel().getColumn(3));
        setUpConditionCol(getColumnModel().getColumn(5));
        setUpUnitCol(getColumnModel().getColumn(2));
    }


    private void initColumns() {
        for(String colName : columnNames) {
            tableModel.addColumn(colName);
        }
    }

    public void setUpDateCol (TableColumn dateCreationCol) {
        for (int r=0; r < tableModel.getRowCount(); r++) {
            for  (int c=0; c < tableModel.getColumnCount(); c++) {
                String date = (String)getValueAt(r, 3);
                if (date.matches(DATE_REGEX)) {
                    dataModel.setValueAt(date, r, 3);
                }
                else {
                    dataModel.setValueAt("Error", r, 3);
                }
            }
        }
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

    public void setUpConditionCol(TableColumn condCol){
        JComboBox condBox = new JComboBox();
        condBox.addItem("-");
        condBox.addItem("Холодильник");
        condBox.addItem("Вытяжка");
        condCol.setCellEditor(new DefaultCellEditor(condBox));
    }

}