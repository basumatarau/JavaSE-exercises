package com.codeHeap.swing.buttons;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ButtonGroups extends JFrame {
    private static String[] ids = {
            "June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"
    };

    static JPanel makePanel(Class<? extends AbstractButton> buttonType, String[] ids) {
        JPanel result = new JPanel();
        ButtonGroup group = new ButtonGroup();
        String title = buttonType.getSimpleName();
        title = title.substring(title.lastIndexOf('.') + 1);
        result.setBorder(new TitledBorder(title));

        for (String id : ids) {
            AbstractButton button = new JButton("failed");
            try{
                Constructor constructor = buttonType.getConstructor(String.class);
                button = ((AbstractButton) constructor.newInstance(id));
            } catch (NoSuchMethodException |
                    IllegalAccessException |
                    InstantiationException |
                    InvocationTargetException e) {
                System.out.println("can't create " + buttonType.getSimpleName());
            }
            group.add(button);
            result.add(button);
        }
        return result;
    }

    ButtonGroups(){
        setLayout(new FlowLayout());
        add(makePanel(JButton.class, ids));
        add(makePanel(JToggleButton.class, ids));
        add(makePanel(JCheckBox.class, ids));
        add(makePanel(JRadioButton.class, ids));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonGroups(), 500, 350);
    }
}
