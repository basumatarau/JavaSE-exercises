package com.codeHeap.threads.producerAndConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispatcher {
    Product storedProduct;
    final Consumer CONSUMER;
    final Producer PRODUCER;
    ExecutorService exec;

    Dispatcher(){
        CONSUMER = new Consumer(this);
        PRODUCER = new Producer(this);
        exec = Executors.newFixedThreadPool(2);
        exec.execute(PRODUCER);
        exec.execute(CONSUMER);
    }

    public static void main(String[] args) {
        new Dispatcher();
    }
}
