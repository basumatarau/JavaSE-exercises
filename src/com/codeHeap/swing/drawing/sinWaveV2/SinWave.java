package com.codeHeap.swing.drawing.sinWaveV2;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(()->{
            try {
                while (!Thread.interrupted()) {
                    sineDraw.increaseShift();
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }catch (InterruptedException e){
                System.out.println(this + " has been interrupted");
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.run(new SinWave(), 800, 400 );
    }

}
