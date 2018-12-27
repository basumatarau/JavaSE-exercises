package com.codeHeap.swing.trackEvent;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFields extends JFrame {
    private JButton b1 = new JButton("get text"),
    b2 = new JButton("set text");

    private JTextField t1 = new JTextField(30),
    t2 = new JTextField(30),
    t3 = new JTextField(30);

    private String s = "";

    private UpperCaseDocument ucd = new UpperCaseDocument();

    class T1 implements DocumentListener{
        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            t2.setText(t1.getText());
            t3.setText("Text: " + t1.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            t2.setText(t1.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            //not implemented
        }
    }

    private class T1A implements ActionListener {
        private int counter = 0;
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            t3.setText("t1 action event " + counter++);
        }
    }

    private class B1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(t1.getSelectedText() == null){
                s = t1.getText();
            } else {
                s = t1.getSelectedText();
            }
            t1.setEditable(true);
        }
    }
    private class B2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ucd.setUpper(false);
            t1.setText("inserted by Button2: " + s);
            ucd.setUpper(true);
            t1.setEditable(false);
        }
    }

    TextFields(){
        t1.setDocument(ucd);
        ucd.addDocumentListener(new T1());
        b1.addActionListener(new B1());
        b2.addActionListener(new B2());
        t1.addActionListener(new T1A());
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(t1);
        add(t2);
        add(t3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextFields(), 400, 200);
    }
}
