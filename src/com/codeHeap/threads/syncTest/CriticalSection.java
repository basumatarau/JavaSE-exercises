package com.codeHeap.threads.syncTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    static void testApproaches(PairManager one, PairManager two){
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator oneManipulator = new PairManipulator(one);
        PairChecker oneChecker = new PairChecker(one);

        PairManipulator twoManipulator = new PairManipulator(two);
        PairChecker twoChecker = new PairChecker(two);

        executorService.execute(oneManipulator);
        executorService.execute(twoManipulator);
        executorService.execute(oneChecker);
        executorService.execute(twoChecker);

        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            System.out.println("sleep interrupted");
        }

        System.out.println("PairMangerOne: " + oneManipulator + ", PairMangerTwo: " + twoManipulator);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pmOne = new ManagerOne();
        PairManager pmTwo = new ManagerTwo();

        testApproaches(pmOne, pmTwo);
    }
}
