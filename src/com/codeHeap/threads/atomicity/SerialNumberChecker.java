package com.codeHeap.threads.atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialNumberChecker {
    private static final int SIZE = 10;

    private static CircularSet serials = new CircularSet(1000);

    private static ExecutorService executor = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while(true){
                synchronized (SerialNumberGenerator.class) {
                    int serial = SerialNumberGenerator.nextSerialNumber();
                    if (serials.contains(serial)) {
                        System.out.println("Duplicate entry: " + serial);
                        System.exit(0);
                    }
                    serials.add(serial);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            executor.execute(new SerialChecker());
        }
    }
}
