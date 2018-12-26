package com.codeHeap.swing.textFieldsAndScrollPanes;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class BorderLayOutTryouts extends JFrame {
    {
        int i = 1;
        JButton button1 = new JButton("button#" + i++);
        JButton button2 = new JButton("button#" + i++);
        JButton button3 = new JButton("button#" + i++);
        JButton button4 = new JButton("button#" + i++);
        JButton button5 = new JButton("button#" + i++);
        add(BorderLayout.NORTH, button1);
        add(BorderLayout.WEST, button3);
        add(BorderLayout.SOUTH, button2);
        add(BorderLayout.EAST, button4);
        add(BorderLayout.CENTER, button5);
    }

    public static void main(String[] args) {
        SwingConsole.run(new BorderLayOutTryouts(), 500, 500);
    }
}
