package com.codeHeap.swing.buttons;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button2 extends JFrame {
    private JButton button1 = new JButton("button1"),
            button2 = new JButton("button2"),
            button3 = new JButton("button3");

    private JTextField textField = new JTextField(15);

    private ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String text = ((JButton) actionEvent.getSource()).getText();
            textField.setText(text);
        }
    };

    Button2(){
        setLayout(new FlowLayout());
        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);
        add(textField);
        add(button1);
        add(button2);
        add(button3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button2(), 200, 150);
    }
}
