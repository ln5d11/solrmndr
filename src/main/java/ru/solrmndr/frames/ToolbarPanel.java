package ru.solrmndr.frames;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarPanel extends JPanel {
    private JButton addRowButton;

    public ToolbarPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 5));
        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        ImageIcon addRow = new ImageIcon("C:\\addrow.png");
        addRowButton = new JButton(addRow);
        addRowButton.setPreferredSize(new Dimension (25, 25));
        addRowButton.setBackground(Color.WHITE);

        add(addRowButton);
    }

    public JButton getAddRowButton() {
        return addRowButton;
    }
}
