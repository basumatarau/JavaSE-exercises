package com.codeHeap.threads.producerAndConsumer;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    Dispatcher dispatcher;

    Producer(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (dispatcher.storedProduct != null) {
                        System.out.println(this + " is waiting for product to be claimed");
                        wait();
                    }
                }

                dispatcher.storedProduct = new Product();

                if (dispatcher.storedProduct.getId() == 10) {
                    System.out.println("SHUTDOWN!");
                    dispatcher.exec.shutdown();
                }

                synchronized (dispatcher.CONSUMER) {
                    System.out.println("Notifying the consumer on the product completion");
                    dispatcher.CONSUMER.notify();
                }

                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " has stopped running");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

