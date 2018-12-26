package com.codeHeap.swing.textFieldsAndScrollPanes;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class CursorReplacer extends JFrame {

    public static void main(String[] args) {
        CursorReplacer frame = new CursorReplacer();
        //frame.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        //JLabel label = new JLabel("some label");
        //label.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        //frame.add(label);
        JButton button = new JButton("button");
        button.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(new JButton("another button"));
        SwingConsole.run(frame, 300, 300);
    }
}
