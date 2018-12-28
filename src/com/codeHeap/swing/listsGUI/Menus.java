package com.codeHeap.swing.listsGUI;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menus extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
            "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
    };

    private JTextField textField = new JTextField("No flavor",20);
    private JMenuBar menuBar1 = new JMenuBar();

    private JMenu[] menusBar1 = {
            new JMenu("File"),
            new JMenu("Flavors"),
            new JMenu("Safety")
    };

    private JRadioButtonMenuItem[] safety = {
            new JRadioButtonMenuItem("Guard"),
            new JRadioButtonMenuItem("Hide")
    };

    private JMenuItem[] file = {
            new JMenuItem("Open")
    };

    private JMenuBar menuBar2 = new JMenuBar();
    private JMenu fooBar = new JMenu("fooBar");

    private JMenuItem[] other = {
            new JMenuItem("Foo", KeyEvent.VK_F),
            new JMenuItem("Bar", KeyEvent.VK_A),
            new JMenuItem("Baz")
    };

    JButton button = new JButton("swap menus");
    class BL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setJMenuBar(getJMenuBar().equals(menuBar1) ? menuBar2 : menuBar1 );
            validate();
        }
    }
    class ML implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JMenuItem target = ((JMenuItem) actionEvent.getSource());
            String actionCommand = target.getActionCommand();
            if(actionCommand.equals("Open")){
                String s = textField.getText();
                boolean found = false;
                for (String flavor : flavors) {
                    if(flavor.equals(s)){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    textField.setText("Choose a flavor first!");
                }else{
                    textField.setText("opening " + s + ". Mmmm...");
                }
            }
        }
    }
    class FL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JMenuItem target = (JMenuItem) actionEvent.getSource();
            textField.setText(target.getText());
        }
    }

    class FooL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            textField.setText("Foo selected");
        }
    }
    class BarL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            textField.setText("Bar selected");
        }
    }
    class Baz implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            textField.setText("Baz selected");
        }
    }

    class CMIL implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            JRadioButtonMenuItem target = (JRadioButtonMenuItem) itemEvent.getSource();
            String actionCommand = target.getActionCommand();
            if(actionCommand.equals("Guard")){
                textField.setText("Guard the ice cream!" + "Guarding ");
            }else if(actionCommand.equals("Hide")){
                textField.setText("Hide the ice cream!" + "Hiding " );
            }
        }
    }

    Menus(){
        ML ml = new ML();
        CMIL cmil = new CMIL();
        safety[0].setActionCommand("Guard");
        safety[0].setMnemonic(KeyEvent.VK_G);
        safety[0].addItemListener(cmil);
        safety[1].setActionCommand("Hide");
        safety[1].setMnemonic(KeyEvent.VK_H);
        safety[1].addItemListener(cmil);

        other[0].addActionListener(new FooL());
        other[1].addActionListener(new BarL());
        other[2].addActionListener(new Baz());

        FL fl = new FL();
        int i = 0;
        for (String flavor : flavors) {
            JMenuItem item = new JMenuItem(flavor);
            item.addActionListener(fl);
            menusBar1[1].add(item);
            if(i++ % 3 == 0){
                menusBar1[1].addSeparator();
            }
        }

        for (JRadioButtonMenuItem item : safety) {
            menusBar1[2].add(item);
        }
        menusBar1[2].setMnemonic(KeyEvent.VK_A);
        menusBar1[0].add(menusBar1[2]);
        menusBar1[0].setMnemonic(KeyEvent.VK_F);

        for (int j = 0; j < file.length; j++) {
            file[j].addActionListener(ml);
            menusBar1[0].add(file[j]);
        }

        menuBar1.add(menusBar1[0]);
        menuBar1.add(menusBar1[1]);
        setJMenuBar(menuBar1);

        textField.setEditable(false);
        add(textField, BorderLayout.CENTER);

        button.addActionListener(new BL());
        button.setMnemonic(KeyEvent.VK_S);
        add(button, BorderLayout.NORTH);

        for (JMenuItem item : other) {
            fooBar.add(item);
        }
        fooBar.setMnemonic(KeyEvent.VK_B);
        menuBar2.add(fooBar);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Menus(), 300, 200);
    }
}
