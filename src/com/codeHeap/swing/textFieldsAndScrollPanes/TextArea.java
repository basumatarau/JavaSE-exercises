package com.codeHeap.swing.textFieldsAndScrollPanes;

import com.codeHeap.collections.abstractCollections.flyweight.FlyweightMap;
import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TextArea extends JFrame {
    JTextArea textArea = new JTextArea(20, 40);
    JButton button1 = new JButton("clear data");
    JButton button2 = new JButton("add data");

    Map<String, String> capitals = new HashMap<>();

    TextArea(){
        capitals.putAll(FlyweightMap.capitals());
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (Map.Entry<String, String> entry : capitals.entrySet()) {
                    textArea.append(entry.getKey());
                    textArea.append(":");
                    textArea.append(entry.getValue());
                    textArea.append("\n");
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText("");
            }
        });
        setLayout(new FlowLayout());
        add(button1);
        add(button2);
        add(new JScrollPane(textArea));
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextArea(), 475, 425);
    }
}
