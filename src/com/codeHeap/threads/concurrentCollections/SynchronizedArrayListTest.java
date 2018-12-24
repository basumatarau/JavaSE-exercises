package com.codeHeap.threads.concurrentCollections;

import com.codeHeap.collections.abstractCollections.countingInteger.CountingInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SynchronizedArrayListTest extends TestList {
    SynchronizedArrayListTest(int nReaders, int nWriters) {
        super("SynchronizedArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        return Collections.synchronizedList(
                new ArrayList<>(
                        new CountingInteger(containerSize)
                )
        );
    }
}
