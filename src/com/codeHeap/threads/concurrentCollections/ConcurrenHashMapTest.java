package com.codeHeap.threads.concurrentCollections;

import com.codeHeap.arrays.countingGenerator.CountingGenerator;
import com.codeHeap.collections.mapData.MapData;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrenHashMapTest extends TestMap {
    public ConcurrenHashMapTest(int nReaders, int nWriters) {
        super("ConcurrentHashMapTest", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ConcurrentHashMap<>(
                MapData.map(
                        new CountingGenerator.Integer(),
                        new CountingGenerator.Integer(),
                        containerSize
                )
        );
    }
}
