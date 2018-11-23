package com.CodeHeap.Collections.SimpleHashMap;

import com.CodeHeap.Collections.AbstractCollections.flyweight.FlyweightMap;

import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        SimpleHashMap<String, String> shm = new SimpleHashMap<>(FlyweightMap.capitals(4));
        shm.putAll(FlyweightMap.capitals(3));
        shm.putAll(FlyweightMap.capitals(2));
        for (Map.Entry<String, String> entry : FlyweightMap.capitals(2).entrySet()) {
            shm.put(entry.getKey(), entry.getValue());
        }
        System.out.println(shm);
    }
}
