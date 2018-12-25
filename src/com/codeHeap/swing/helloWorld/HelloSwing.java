package com.codeHeap.swing.helloWorld;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HelloSwing {
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame("Hello swing!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300, 300);

        JLabel label = new JLabel("Label1");
        frame.add(label);
        TimeUnit.SECONDS.sleep(2);
        label.setText("hey, it's different!");
    }
}
