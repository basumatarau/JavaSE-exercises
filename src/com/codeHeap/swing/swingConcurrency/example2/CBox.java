package com.codeHeap.swing.swingConcurrency.example2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CBox extends JPanel implements Runnable{
    private Random random = new Random(47);
    private Color color = new Color(0xB02B0601, true);
    private int pause;

    CBox(int pause){
        this.pause = pause;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(color);
        Dimension size = getSize();
        graphics.fillRect(0,0, size.width, size.height);
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try{
                color = new Color(random.nextInt(0xFFFFFF));
                repaint();
                TimeUnit.MILLISECONDS.sleep(pause);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
