package com.codeHeap.swing.swingConcurrency.example2;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ColorBoxes extends JFrame {
    private int gridNum;
    private int pause;
    private ExecutorService executorService;

    ColorBoxes(int gridNum, int pause){
        this.gridNum = gridNum;
        this.pause = pause;
        executorService = Executors.newFixedThreadPool(gridNum*gridNum);

        setLayout(new GridLayout(gridNum, gridNum));
        for (int i = 0; i < gridNum * gridNum; i++) {
            CBox component = new CBox(pause);
            add(component);
            executorService.execute(component);
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new ColorBoxes(24, 150), 400, 400);
    }

}
