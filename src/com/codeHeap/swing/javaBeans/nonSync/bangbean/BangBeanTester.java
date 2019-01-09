package com.codeHeap.swing.javaBeans.nonSync.bangbean;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;

public class BangBeanTester extends JFrame {
    private JTextField textField = new JTextField(20);

    {
        textField.setEditable(false);
    }

    class BBL implements ActionListener{
        private int counter = 0;
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            BangBeanTester.this.textField.setText("BangBean action " + ++BangBeanTester.BBL.this.counter);
        }
    }

    BangBeanTester(){
        BangBean bb = new BangBean();
        try{
            bb.addActionListener(new BBL());
        }catch (TooManyListenersException e){
            throw new RuntimeException(e);
        }
        add(bb);
        add(BorderLayout.SOUTH, textField);
    }

    public static void main(String[] args) {
        SwingConsole.run(new BangBeanTester(), 400, 500);
    }
}
