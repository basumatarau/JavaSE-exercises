package com.codeHeap.swing.buttons;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class Button extends JFrame {
    private JButton button1 = new JButton("button1");
    private JButton button2 = new JButton("button2");

    Button(){
        setLayout(new FlowLayout());
        add(button1);
        add(button2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Button(), 200, 100);
    }
}
