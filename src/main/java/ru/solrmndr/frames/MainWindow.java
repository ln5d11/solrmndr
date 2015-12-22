package ru.solrmndr.frames;

import javax.swing.*;
import java.awt.*;

/**
 * Основное окно приложения
 */
public class MainWindow extends JFrame {

    public static final String MAIN_WINDOW_NAME = "Solution Reminder";
    public static final String VERSION = "0.00001";
    public static final int MAIN_WINDOW_WIDTH = 600;
    public static final int MAIN_WINDOW_HEIGHT = 400;

    public MainWindow() throws HeadlessException {
        setTitle(MAIN_WINDOW_NAME + " v." + VERSION);
        setSize(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);
        initGui();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * В методе инициализируются компоненты которые содержат основные компоненты
     */
    protected void initGui() {

    }


}
