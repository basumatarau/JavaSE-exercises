package com.codeHeap.threads.bankTellerSimulation;

import java.util.concurrent.TimeUnit;

public class Teller implements Runnable, Comparable<Teller> {

    private static int counter = 0;
    private final int id = ++counter;
    private int servedCustomers = 0;
    private CustomerLine line;
    private boolean isServicingCustomers = true;

    Teller(CustomerLine line) {
        this.line = line;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Customer customer = line.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    servedCustomers++;
                    while (!isServicingCustomers) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " has finished working");
    }

    synchronized public void doSomethingElse(){
        servedCustomers = 0;
        isServicingCustomers = false;
    }
    synchronized public void serveCustomerLine(){
        isServicingCustomers = true;
        notifyAll();
    }

    @Override
    synchronized public int compareTo(Teller teller) {
        return servedCustomers > teller.servedCustomers ? 1 :
                (servedCustomers < teller.servedCustomers ? -1 : 0);
    }

    @Override
    public String toString() {
        return "Teller# " + id + " ";
    }

    public String shortString() {
        return "T" + id;
    }
}
