package com.codeHeap.threads.producerAndConsumer;

public class Consumer implements Runnable {
    Dispatcher dispatcher;
    Product p;
    Consumer(Dispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (dispatcher.storedProduct == null) {
                        System.out.println(this + " is waiting for the product to be produced");
                        wait();
                    }
                }
                System.out.println(this + " is to obtain " + dispatcher.storedProduct);
                p = dispatcher.storedProduct;

                synchronized (dispatcher.PRODUCER){
                    dispatcher.storedProduct = null;
                    System.out.println(p + " has been consumed by " + this);
                }
            }
        }catch (InterruptedException e){
            System.out.println(this + " has been interrupted");
        }

        System.out.println(this + " has stopped running");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
