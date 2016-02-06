package ru.solrmndr.frames;

import javax.swing.*;
import java.awt.*;

public class ToolbarPanel extends JPanel {
    private JButton addRowButton;
    private JButton saveButton;

    public ToolbarPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 5));

        ImageIcon addRow = new ImageIcon(getClass().getClassLoader().getResource("resources/row_add_after.png"));
        addRowButton = new JButton(addRow);
        addRowButton.setPreferredSize(new Dimension (25, 25));
        addRowButton.setBackground(Color.WHITE);

        ImageIcon save = new ImageIcon(getClass().getClassLoader().getResource("resources/save.png"));
        saveButton = new JButton(save);
        saveButton.setPreferredSize(new Dimension (25, 25));
        saveButton.setBackground(Color.WHITE);

        add(addRowButton);
        add(saveButton);
    }

    public JButton getAddRowButton() {
        return addRowButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}