package com.codeHeap.threads.timers;

import java.util.*;

public class Timeout {
    public static void main(String[] args) {
        List<Timer> timers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Timer timer = new Timer();
            timers.add(timer);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(this + "goes off");
                }
            }, new Random().nextInt(3000));
        }
    }
}
