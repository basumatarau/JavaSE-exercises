package com.codeHeap.swing.listsGUI;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILists extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
    };

    private DefaultListModel<String> lItems = new DefaultListModel<>();
    private JList<String> list = new JList<>(lItems);
    private JTextArea textArea = new JTextArea(flavors.length, 20);

    private JButton button = new JButton("add flavor");
    private int count = 0;

    public GUILists(){
        textArea.setEditable(false);
        setLayout(new FlowLayout());

        Border border = BorderFactory.createMatteBorder(1,1,2,2, Color.BLACK);
        list.setBorder(border);
        textArea.setBorder(border);
        for (int i = 0; i < 4; i++) {
            lItems.addElement(flavors[count++]);
        }

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if(listSelectionEvent.getValueIsAdjusting()){
                    return;
                }
                textArea.setText("");
                for (Object selectedValue : list.getSelectedValues()) {
                    textArea.append(selectedValue + "\n");
                }
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(count<flavors.length){
                    lItems.add(0, flavors[count++]);
                }else {
                    button.setEnabled(false);
                }
            }
        });

        add(textArea);
        add(list);
        add(button);
    }

    public static void main(String[] args) {
        SwingConsole.run(new GUILists(), 250, 400);
    }

}
