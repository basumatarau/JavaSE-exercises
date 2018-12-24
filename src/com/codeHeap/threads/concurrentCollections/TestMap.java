package com.codeHeap.threads.concurrentCollections;

import java.util.Map;

public abstract class TestMap extends Tester<Map<Integer, Integer>> {
    public TestMap(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    @Override
    void startReadersAndWriters() {
        for (int i = 0; i < nReaders; i++) {
            executorService.execute(new Reader());
        }
        for (int i = 0; i < nWriters; i++) {
            executorService.execute(new Writer());
        }
    }

    private class Reader extends TestTask{
        long result = 0;
        @Override
        void test() {
            for (int i = 0; i < testCycles; i++) {
                for (int j = 0; j < containerSize; j++) {
                    result += container.get(j);
                }
            }
        }

        @Override
        void putResults() {
            //the method is called within a synchronized block, hence no need to be sync again:
            //noinspection NonAtomicOperationOnVolatileField
            readResult += result;
            //noinspection NonAtomicOperationOnVolatileField
            readTime += duration;
        }
    }

    private class Writer extends TestTask{
        @Override
        void test() {
            for (int i = 0; i < testCycles; i++) {
                for (int j = 0; j < containerSize; j++) {
                    container.put(j, writeData[j]);
                }
            }
        }

        @Override
        void putResults() {
            //the method is called within a synchronized block, hence no need to be sync again:
            //noinspection NonAtomicOperationOnVolatileField
            writeTime += duration;
        }
    }
}
