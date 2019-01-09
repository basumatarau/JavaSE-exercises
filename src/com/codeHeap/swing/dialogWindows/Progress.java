package com.codeHeap.swing.dialogWindows;

import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Progress extends JFrame {
    private JProgressBar pb = new JProgressBar();
    private JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);

    private ProgressMonitor pm = new ProgressMonitor(this,
            "monitoring this",
            "test",
            0,
            100
    );

    Progress() {

        setLayout(new GridLayout(2, 1));
        add(pb);
        pm.setProgress(0);
        pm.setMillisToPopup(1000);
        sb.setValue(0);
        sb.setPaintTicks(true);
        sb.setMajorTickSpacing(20);
        sb.setMinorTickSpacing(5);
        sb.setBorder(new TitledBorder("slide me"));

        ChangeListener chL = (event) -> pm.setProgress(sb.getValue());

        sb.addChangeListener(chL);
        pb.setModel(sb.getModel());

        new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sb.setValue(sb.getValue() + 1);
            }
        }).start();

        add(sb);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Progress(), 300, 200);
    }
}
