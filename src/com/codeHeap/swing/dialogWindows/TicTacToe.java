package com.codeHeap.swing.dialogWindows;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe extends JFrame{
    private JTextField rows = new JTextField(5);
    private JTextField cols = new JTextField(5);

    private enum State{
        BLANK, OO, XX
    }

    private static class ToeDialog extends JDialog {
        private State turn = State.XX;

        ToeDialog(int cellsWide, int cellsHigh){
            setTitle("the game itself");
            setLayout(new GridLayout(cellsHigh, cellsWide));
            for (int i = 0; i < cellsHigh * cellsWide; i++) {
                add(new ToeButton());
            }
            setSize(cellsHigh*50, cellsWide*50);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        class ToeButton extends JPanel{
            private State state = State.BLANK;

            ToeButton(){
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        if(state == State.BLANK){
                            state = turn;
                            turn = (turn == State.XX ? State.OO : State.XX);
                        } else {
                            state = (state == State.XX ? State.OO : State.XX);
                        }
                        repaint();
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                int x1 = 0, y1 = 0;
                int x2 = getSize().width -1;
                int y2 = getSize().height -1;
                graphics.drawRect(x1, y1, x2, y2);

                x1 = x2/4;
                y1 = y2/4;
                int width = x2/2;
                int height = y2/2;
                if(state == State.XX){
                    graphics.drawLine(x1, y1, x1+width, y1 + height);
                    graphics.drawLine(x1 + width, y1, x1, y1 + height);
                }else if (state == State.OO){
                    graphics.drawOval(x1, y1, x1 + width/2, y1 + height/2);
                }
            }
        }
    }

    public TicTacToe(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,2));
        jPanel.add(new Label("vertical cells:"));
        jPanel.add(rows);
        jPanel.add(new Label("horizontal cells:"));
        jPanel.add(cols);

        add(BorderLayout.NORTH, jPanel);
        JButton go = new JButton("go");
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ToeDialog(
                        Integer.valueOf(cols.getText()),
                        Integer.valueOf(rows.getText())
                ).setVisible(true);
            }
        });
        add(BorderLayout.SOUTH, go);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TicTacToe(), 200, 200);
    }
}
