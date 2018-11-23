package com.CodeHeap.Collections.SlowMap;

import com.CodeHeap.Collections.AbstractCollections.countingInteger.CountingMapData;
import com.CodeHeap.Collections.AbstractCollections.flyweight.FlyweightMap;
import com.CodeHeap.Collections.sortedMap.MapsTest;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        /*SlowMap<String, String> slowMap = new SlowMap<>();
        slowMap.putAll(FlyweightMap.capitals(10));
        System.out.println(slowMap);
        System.out.println(slowMap.get("ANGOLA"));
        System.out.println(slowMap.entrySet());*/

        SlowMap<Integer, String> slow = new SlowMap<>(CountingMapData.select(26));
        System.out.println(slow);
        MapsTest.test(slow);
        System.out.println(slow);

        HashMap<Integer, String> fast = new HashMap<>(10);
        for (Map.Entry<Integer, String> entry : CountingMapData.select(26).entrySet()) {
            fast.put(entry.getKey(), entry.getValue());
        }
        System.out.println(fast);
        MapsTest.test(fast);
        System.out.println(CountingMapData.select(26));
    }
}
