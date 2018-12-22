package com.codeHeap.threads.bankTellerSimulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class TellerManager implements Runnable {

    private ExecutorService exec;
    private CustomerLine line;
    private PriorityQueue<Teller> workingTellrs = new PriorityQueue<>();
    private Queue<Teller> restingTellers = new LinkedList<>();
    private int adjustmentPeriod;

    TellerManager(CustomerLine line, int adjustmentPeriod, ExecutorService exec) {
        this.line = line;
        this.adjustmentPeriod = adjustmentPeriod;
        this.exec = exec;

        Teller teller = new Teller(line);
        exec.execute(teller);
        workingTellrs.add(teller);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(1000);
                adjustTellersNumber();
                System.out.print("line: " + line);
                for (Teller workingTellr : workingTellrs) {
                    System.out.print(workingTellr);
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " has been interrupted");
        }
        System.out.println(this + " has been terminated");
    }

    private void adjustTellersNumber() {
        if (line.size() / workingTellrs.size() > 2) {
            if (restingTellers.size() > 0) {
                Teller teller = restingTellers.remove();
                teller.serveCustomerLine();
                workingTellrs.add(teller);
                return;
            }
            Teller teller = new Teller(line);
            workingTellrs.add(teller);
            exec.execute(teller);
            return;
        }
        if (workingTellrs.size() > 1 &&
                line.size() / workingTellrs.size() < 2){
            reassignOneTeller();
        }
        if(line.size()==0 && exec.isTerminated()){
            while (workingTellrs.size()>0){
                reassignOneTeller();
            }
        }
    }

    private void reassignOneTeller() {
        Teller teller = workingTellrs.remove();
        teller.doSomethingElse();
        restingTellers.add(teller);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
