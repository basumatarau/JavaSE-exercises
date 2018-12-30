package com.codeHeap.swing.swingConcurrency.example;

import com.codeHeap.swing.swingConcurrency.TaskManager;
import com.codeHeap.swing.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterruptableLongRunningCallable extends JFrame {
    private JButton
        b1 = new JButton("Start long running task"),
        b2 = new JButton("End long running task"),
        b3 = new JButton("Get results");

    private TaskManager<String, CallableTask> manager = new TaskManager<>();

    InterruptableLongRunningCallable(){
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CallableTask task = new CallableTask();
                manager.addTask(task);
                System.out.println(task + " has been added to the queue");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (String purgedItem : manager.purge()) {
                    System.out.println(purgedItem);
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (String result : manager.getResults()) {
                    System.out.println(result);
                }
            }
        });
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new InterruptableLongRunningCallable(), 300, 100);
    }
}
