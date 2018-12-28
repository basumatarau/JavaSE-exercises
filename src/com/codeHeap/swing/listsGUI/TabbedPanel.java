package com.codeHeap.swing.listsGUI;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TabbedPanel extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
    };

    private JTabbedPane tabs = new JTabbedPane();
    private JTextField textField = new JTextField(20);

    public TabbedPanel(){
        int i=0;
        for (String flavor : flavors) {
            tabs.addTab(flavor, new JButton("Tabbed Panel" + i++));
        }
        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                textField.setText("Tab selected: " + tabs.getSelectedIndex());
            }
        });
        textField.setEditable(false);
        add(BorderLayout.SOUTH, textField);
        add(tabs);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TabbedPanel(), 400, 250);
    }
}
