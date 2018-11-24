package com.CodeHeap.Collections.SimpleHashMapImpl2;

import com.CodeHeap.Collections.AbstractCollections.countingInteger.CountingMapData;
import com.CodeHeap.Collections.AbstractCollections.flyweight.FlyweightMap;
import com.CodeHeap.Collections.sortedMap.MapsTest;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>(FlyweightMap.capitals(4));
        shm.putAll(FlyweightMap.capitals(6));
        for (Map.Entry<String, String> entry : FlyweightMap.capitals(2).entrySet()) {
            shm.put(entry.getKey(), entry.getValue());
        }
        System.out.println(shm);

        SimpleHashMap<Integer, String> simpleHashMap = new SimpleHashMap<>(CountingMapData.select(10));
        System.out.println(simpleHashMap);
        MapsTest.test(simpleHashMap);

        HashMap<Integer, String> plainHashMap = new HashMap<>(CountingMapData.select(10));
        System.out.println(plainHashMap);
        MapsTest.test(plainHashMap);

        HashMap<String, String> mapTest = new HashMap<>(FlyweightMap.capitals(10));
        System.out.println(mapTest);

    }
}
