package com.codeHeap.swing.comboboxes;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxes extends JFrame {
    private String[] description = {
            "Ebullient", "Obtuse", "Recalcitrant", "Brilliant",
            "Somnescent", "Timorous", "Florid", "Putrescent"
    };
    private JTextField textField = new JTextField(15);
    private JComboBox<String> comboBox = new JComboBox<>();
    private JButton button = new JButton("add item");

    private int count = 0;

    ComboBoxes(){
        for (int i = 0; i < 4; i++) {
            comboBox.addItem(description[count++]);
        }
        textField.setEditable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(count<description.length){
                    comboBox.addItem(description[count++]);
                }
            }
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText("index: "+ comboBox.getSelectedIndex()
                        + " " + ((JComboBox) actionEvent.getSource()).getSelectedItem());
            }
        });
        setLayout(new FlowLayout());
        add(textField);
        add(comboBox);
        add(button);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ComboBoxes(), 200, 200);
    }
}
