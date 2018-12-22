package com.codeHeap.threads.bankTellerSimulation;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);

        executorService.execute(new CustomerGenerator(customers));
        executorService.execute(new TellerManager(customers, ADJUSTMENT_PERIOD, executorService));

        System.out.println("press any key to stop the simulation");
        System.in.read();

        executorService.shutdownNow();
    }
}
