package com.codeHeap.swing.textFieldsAndScrollPanes;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegExp extends JFrame {
    JTextField regExpTextField = new JTextField(20);
    JButton testButton = new JButton("go");
    JTextArea inputTextArea = new JTextArea(20, 40);
    JTextArea resultTextArea = new JTextArea(20, 40);

    TestRegExp(){
        setLayout(new FlowLayout());
        add(testButton);
        add(regExpTextField);
        add(new JLabel("input"));
        add(new JScrollPane(inputTextArea));

        add(new JLabel("output"));
        add(new JScrollPane(resultTextArea));
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder result = new StringBuilder();
                try {
                    String regExp = regExpTextField.getText();
                    Matcher matcher = Pattern.compile(regExp).matcher(inputTextArea.getText());
                    while (matcher.find()) {
                        result.append(matcher.group());
                    }
                }catch (Exception e){
                    result.setLength(0);
                    result.append(e.getMessage());
                }
                resultTextArea.setText(result.toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.run(new TestRegExp(), 500, 500);
    }
}
