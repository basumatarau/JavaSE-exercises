package com.codeHeap.swing.drawing.sinWaveV1;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

class SinWave extends JFrame {
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

    public static void main(String[] args) {
        SwingConsole.run(new SinWave(), 800, 400 );
    }

}
