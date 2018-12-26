package com.codeHeap.swing.eventListeners;

import com.codeHeap.swing.util.SwingConsole;
import sun.tools.java.ClassNotFound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowListeners extends JFrame {
    private JTextField typeName = new JTextField(15);
    private JTextArea results = new JTextArea(20,40);

    private static Pattern methodName = Pattern.compile("(add\\w+?Listener\\(.*?\\))");

    class InputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String typeName = ShowListeners.this.typeName.getText().trim();
            if(typeName.length()==0){
                results.setText("no match");
                return;
            }
            Class<?> type;
            try{
                type = Class.forName("javax.swing." + typeName);
            }catch (ClassNotFoundException e){
                results.setText("no match");
                return;
            }

            results.setText("");
            Method[] methods = type.getMethods();
            for (Method method : methods) {
                Matcher matcher = methodName.matcher(method.toString());
                if(matcher.find()){
                    results.append(matcher.group() + "\n");
                }
            }
        }
    }

    ShowListeners(){
        setLayout(new FlowLayout());
        typeName.addActionListener(new InputListener());

        JPanel panel = new JPanel();
        panel.add(new JLabel("type in swing Class name and press enter:"));
        panel.add(typeName);

        add(BorderLayout.NORTH, panel);
        add(BorderLayout.CENTER, new JScrollPane(results));

    }

    public static void main(String[] args) {
        SwingConsole.run(new ShowListeners(), 500,  500);
    }
}
