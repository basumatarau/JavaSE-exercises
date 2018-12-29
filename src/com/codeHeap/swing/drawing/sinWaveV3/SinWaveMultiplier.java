package com.codeHeap.swing.drawing.sinWaveV3;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class SinWaveMultiplier extends JFrame {

    SinWaveMultiplier(int n){
        setLayout(new GridLayout(n, 1));
        for (int i = 0; i < n; i++) {
            add(new SinWave());
        }
    }

    public static void main(String[] args) {
        int sinPanels = 4;
        if(args.length>0){
            sinPanels = Integer.parseInt(args[0]);
        }
        SwingConsole.run(new SinWaveMultiplier(sinPanels), 800, 400 );
    }
}
