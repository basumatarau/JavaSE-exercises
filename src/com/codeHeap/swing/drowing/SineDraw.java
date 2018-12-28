package com.codeHeap.swing.drowing;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SineDraw extends JPanel {
    private int SCALE_FACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    SineDraw(int cycles) {
        setCycles(cycles);
        setBackground(Color.BLUE);
    }

    private void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALE_FACTOR * 2 * cycles;
        sines = new double[points];

        for (int i = 0; i < sines.length; i++) {
            sines[i] = Math.sin((Math.PI / SCALE_FACTOR) * i);
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int maxWidth = getWidth();
        int maxHeight = getHeight();
        double step = (double) maxWidth / (double) points;
        pts = new int[points];

        for (int i = 0; i < points; i++) {
            pts[i] = (int) (sines[i] * maxHeight / 2 * 0.95 + maxHeight / 2);
        }

        graphics.setColor(Color.WHITE);
        graphics.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        graphics.drawLine(getWidth()/2,0, getWidth()/2, getHeight());
        graphics.setColor(Color.YELLOW);
        for (int i = 1; i < points; i++) {
            int x1 = (int) ((i - 1) * step);
            int x2 = (int) (i * step);
            int y1 = pts[i - 1];
            int y2 = pts[i];
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    public static class SinWave extends JFrame{
        private SineDraw sineDraw = new SineDraw(3);
        private JSlider slider = new JSlider(1, 30, 5);
        SinWave(){
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    sineDraw.setCycles(((JSlider) changeEvent.getSource()).getValue());
                }
            });
            add(sineDraw);
            add(BorderLayout.SOUTH, slider);
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new SinWave(), 800, 400 );
    }
}
