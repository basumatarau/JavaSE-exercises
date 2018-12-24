package com.codeHeap.threads.concurrentCollections;

public class MapTestRunner {
    public static void main(String[] args) {

        Tester.initMain(args);

        new SynchronizedHashMapTest(10, 0);
        new SynchronizedHashMapTest(9, 1);
        new SynchronizedHashMapTest(5, 5);
        new ConcurrenHashMapTest(10, 0);
        new ConcurrenHashMapTest(9, 1);
        new ConcurrenHashMapTest(5, 5);
    }
}
