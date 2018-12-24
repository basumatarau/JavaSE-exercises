package com.codeHeap.threads.concurrentCollections;

import com.codeHeap.collections.abstractCollections.countingInteger.CountingInteger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class CopyOnWriteArrayListTest extends TestList {
    CopyOnWriteArrayListTest(int nReaders, int nWriters) {
        super("CopyOnWriteArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        return new CopyOnWriteArrayList<>(new CountingInteger(containerSize));
    }
}
