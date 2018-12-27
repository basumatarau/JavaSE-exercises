package com.codeHeap.swing.trackEvent;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class TrackEvent extends JFrame {
    private HashMap<String, JTextField> textFeildsMapping = new HashMap<>();
    private String[] events = {"focusGained", "focusLost",
            "keyTyped", "keyPressed", "keyReleased", "mouseClicked",
            "mousePressed", "mouseReleased", "mouseEntered", "mouseExited",
            "mouseDragged", "mouseMoved"
            };

    MyButton button1 = new MyButton(Color.BLUE, "button1"),
    button2 = new MyButton(Color.RED, "button2");

    class MyButton extends JButton{
        public void report(String field, String msg){
            textFeildsMapping.get(field).setText(msg);
        }

        FocusListener f1 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                report("focusGained", focusEvent.paramString());
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                report("focusLost", focusEvent.paramString());
            }
        };

        KeyListener k1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                report("keyTyped", keyEvent.paramString());
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                report("keyPressed", keyEvent.paramString());
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                report("keyReleased", keyEvent.paramString());
            }
        };

        MouseListener m1 = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                report("mouseClicked", mouseEvent.paramString());
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                report("mousePressed", mouseEvent.paramString());
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                report("mouseReleased", mouseEvent.paramString());
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                report("mouseEntered", mouseEvent.paramString());
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                report("mouseExited", mouseEvent.paramString());
            }
        };

        MouseMotionListener m2 = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                report("mouseDragged", mouseEvent.paramString());
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                report("mouseMoved", mouseEvent.paramString());
            }
        };

        public MyButton(Color color, String label){
            super(label);
            setBackground(color);
            addFocusListener(f1);
            addKeyListener(k1);
            addMouseListener(m1);
            addMouseMotionListener(m2);
        }
    }

    TrackEvent(){
        setLayout(new GridLayout(events.length + 1, 2));
        for (String event : events) {
            JTextField field = new JTextField();
            field.setEditable(false);
            add(new JLabel(event, JLabel.RIGHT));
            add(field);
            textFeildsMapping.put(event, field);
        }
        add(button1);
        add(button2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TrackEvent(), 700, 500);
    }

}
