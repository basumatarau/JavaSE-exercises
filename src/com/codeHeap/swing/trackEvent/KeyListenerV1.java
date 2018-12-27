package com.codeHeap.swing.trackEvent;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerV1 extends JFrame {

    KeyListenerV1(){
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("button");
        button.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                textArea.setText("");
                System.out.println(focusEvent.paramString());
                ((JButton) focusEvent.getSource()).addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        System.out.println(keyEvent.paramString());
                        textArea.append(keyEvent.getKeyChar()+"");
                    }
                });
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                System.out.println(focusEvent.paramString());
                KeyListener[] keyListeners = ((JButton) focusEvent.getSource()).getKeyListeners();
                System.out.println("focus lost");
                for (KeyListener keyListener : keyListeners) {
                    ((JButton) focusEvent.getSource()).removeKeyListener(keyListener);
                }
            }
        });
        setLayout(new GridLayout(1 , 2));
        add(button);
        add(textArea);
    }

    public static void main(String[] args) {
        SwingConsole.run(new KeyListenerV1(), 200, 150);
    }
}
