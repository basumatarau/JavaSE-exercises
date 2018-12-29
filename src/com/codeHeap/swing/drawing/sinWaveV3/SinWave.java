package com.codeHeap.swing.drawing.sinWaveV3;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SinWave extends JPanel {

    private SineDraw sineDraw = new SineDraw(3);
    private JSlider slider = new JSlider(1, 30, 5);
    private JSlider sliderSpeed = new JSlider(1, 30, 5);
    SinWave(){
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                sineDraw.setCycles(((JSlider) changeEvent.getSource()).getValue());
            }
        });
        sliderSpeed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                sineDraw.setIncr(((JSlider) changeEvent.getSource()).getValue());
            }
        });
        setLayout(new GridLayout(2, 1));
        add(sineDraw);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,2));
        jPanel.add(new JLabel("frequency"));
        jPanel.add(slider);
        jPanel.add(new JLabel("speed"));
        jPanel.add(sliderSpeed);
        add(jPanel);

        new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        sineDraw.increaseShift();
                        return null;
                    }
                };
                swingWorker.execute();
            }
        }).start();

        /* SwingTimer example
        new javax.swing.Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sineDraw.increaseShift();
            }
        }).start();
        */

        /* java.util.Timer example
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sineDraw.increaseShift();
            }
        }, 0, TimeUnit.MILLISECONDS.convert(100, TimeUnit.MILLISECONDS));
        */

        /* using ExecutorService
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
        */
    }

}
