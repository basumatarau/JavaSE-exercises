package com.codeHeap.swing.listsGUI;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Popups extends JFrame {
    private JPopupMenu popup = new JPopupMenu();
    private JTextField textField = new JTextField(15);

    public Popups(){
        setLayout(new FlowLayout());
        add(textField);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField.setText(((JMenuItem) actionEvent.getSource()).getText());
            }
        };

        JMenuItem m = new JMenuItem("Hither!");
        m.addActionListener(listener);
        popup.add(m);
        m = new JMenuItem("Yon");
        m.addActionListener(listener);
        popup.add(m);
        m = new JMenuItem("Yon");
        m.addActionListener(listener);
        popup.add(m);
        m = new JMenuItem("Afar");
        m.addActionListener(listener);
        popup.add(m);
        m = new JMenuItem("Here");
        m.addActionListener(listener);
        popup.add(m);

        PopupListener menuListener = new PopupListener();
        addMouseListener(menuListener);
        textField.addMouseListener(menuListener);
    }

    class PopupListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            maybeShowPopup(mouseEvent);;
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            maybeShowPopup(mouseEvent);
        }

        private void maybeShowPopup(MouseEvent e){
            if(e.isPopupTrigger()){
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new Popups(), 300, 200);
    }
}
