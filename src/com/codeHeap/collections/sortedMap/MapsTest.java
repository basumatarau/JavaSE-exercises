package com.codeHeap.collections.sortedMap;

import com.codeHeap.collections.abstractCollections.countingInteger.CountingMapData;

import java.util.Map;

public class MapsTest {
    public static <K,V> void printKeys(Map<K,V> map){
        System.out.println("Size: "+map.size());
        System.out.println("Keys: "+map.keySet());
    }

    public static void test(Map<Integer,String> map){
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        System.out.println("Keys: "+map.keySet());
        System.out.println("Values: "+map.values());
        System.out.println("map.containsKey(11): "+map.containsKey(11));
        System.out.println("map.get(11): "+map.get(11));
        System.out.println("map.containsValue(\"W0\")"+map.containsValue("W0"));
        int key = map.keySet().iterator().next();
        System.out.println("First key in map: "+key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty: "+map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty: " + map.isEmpty());
    }
}
