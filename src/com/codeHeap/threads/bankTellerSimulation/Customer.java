package com.codeHeap.threads.bankTellerSimulation;

public class Customer {
    private final int serviceTime;

    Customer(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}
