package com.codeHeap.threads.concurrentCollections;

import com.codeHeap.arrays.countingGenerator.CountingGenerator;
import com.codeHeap.collections.mapData.MapData;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedHashMapTest extends TestMap {
    public SynchronizedHashMapTest(int nReaders, int nWriters) {
        super("SynchronizedHashMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return Collections.synchronizedMap(
                new HashMap<>(
                        MapData.map(
                                new CountingGenerator.Integer(),
                                new CountingGenerator.Integer(),
                                containerSize
                        )
                )
        );
    }
}
