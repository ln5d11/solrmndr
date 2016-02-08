package ru.solrmndr.frames;

import ru.solrmndr.controller.TableDataController;
import ru.solrmndr.utils.ApplicationConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Основное окно приложения
 */
public class MainWindow extends JFrame {

    TableModel mainDataTable;
    TableDataController tdc;
    ToolbarPanel toolBar;
    JPanel mainPanel;

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
        mainPanel = new JPanel();
        configMainPanel();
        initTable();
        initToolBar();
        configToolBarButtons();
        JScrollPane tableScrollPane = new JScrollPane(mainDataTable);
        mainPanel.add(toolBar);
        mainPanel.add(tableScrollPane);
        getContentPane().add(mainPanel);
    }

    public void configMainPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    }

    public void initToolBar() {
        toolBar = new ToolbarPanel();
    }

    private void configToolBarButtons() {
        toolBar.getAddRowButton().addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addRow();
            }
        });

        toolBar.getSaveButton().addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mainDataTable.prepareToSaveData();
            }
        });
    }


    private void addRow() {
        mainDataTable.addEmptyRow();
    }

    private void initTable () {
        mainDataTable = new TableModel();
        mainDataTable.setAutoCreateRowSorter(true);
        mainDataTable.setBackground(Color.WHITE);
    }

}