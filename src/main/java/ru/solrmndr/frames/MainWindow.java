package ru.solrmndr.frames;

import ru.solrmndr.utils.ApplicationConfig;

import javax.swing.*;
import java.awt.*;

/**
 * Основное окно приложения
 */
public class MainWindow extends JFrame {

    JTable mainDataTable;

    public MainWindow() throws HeadlessException {
        setTitle(ApplicationConfig.MAIN_WINDOW_NAME + " v." + ApplicationConfig.VERSION);
        setSize(ApplicationConfig.MAIN_WINDOW_WIDTH, ApplicationConfig.MAIN_WINDOW_HEIGHT);
        initGui();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * В методе инициализируются компоненты которые содержат основные компоненты
     */
    protected void initGui() {
        initTable();
    }

    private void initTable () {
        mainDataTable = new JTable(new TableModel());
        mainDataTable.setAutoCreateRowSorter(true);
        mainDataTable.setBackground(Color.WHITE);
        JScrollPane tableScrollPane = new JScrollPane(mainDataTable);
        add(tableScrollPane);
    }

}
