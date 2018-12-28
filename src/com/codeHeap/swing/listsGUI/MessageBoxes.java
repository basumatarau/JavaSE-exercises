package com.codeHeap.swing.listsGUI;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageBoxes extends JFrame {
    private JButton[] buttons = {
            new JButton("Alert"), new JButton("Yes/No"),
            new JButton("Color"), new JButton("Input"),
            new JButton("3 Vals")
    };

    private JTextField textField = new JTextField(15);
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String id = ((JButton) actionEvent.getSource()).getText();
            if(id.equals("Alert")){
                JOptionPane.showMessageDialog(null,
                        "There's a bug on you!",
                        "Hey!", JOptionPane.ERROR_MESSAGE);
            } else if(id.equals("Yes/No")){
                JOptionPane.showConfirmDialog(null, "or no",
                        "choose yes", JOptionPane.YES_NO_OPTION);
            } else if(id.equals("Color")){
                Object[] options = {"Red", "Green"};
                int selection = JOptionPane.showOptionDialog(null, "Choose a color!",
                        "Warning", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                if(selection!=JOptionPane.CLOSED_OPTION){
                    textField.setText("Color selected: " + options[selection]);
                }
            } else if(id.equals("Input")){
                String input = JOptionPane.showInputDialog("How many fingers do you have");
                textField.setText(input);
            }else if(id.equals("3 Vals")){
                Object[] selections = {"First", "Second", "Third"};
                Object selection = JOptionPane.showInputDialog(null, "Choose one", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null, selections, selections[0]);
                if(selection!=null){
                    textField.setText(selection.toString());
                }
            }
        }
    };

    public MessageBoxes(){
        setLayout(new FlowLayout());
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(listener);
            add(buttons[i]);
        }
        add(textField);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MessageBoxes(), 200, 200);
    }
}
