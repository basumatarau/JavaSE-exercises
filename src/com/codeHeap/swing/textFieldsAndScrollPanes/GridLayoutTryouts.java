package com.codeHeap.swing.textFieldsAndScrollPanes;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTryouts extends JFrame {
    {
        setLayout(new GridLayout(7, 3));
        for (int i = 0; i < 20; i++) {
            add(new JButton("button#" + i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new GridLayoutTryouts(), 500, 500);
    }
}
