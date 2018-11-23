package com.CodeHeap.Collections.sortedMap;

import com.CodeHeap.Collections.AbstractCollections.flyweight.FlyweightMap;

import java.util.Map;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>(FlyweightMap.capitals(10));
        System.out.println(treeMap);
        TreeMap<String, String> treeMap2 = new TreeMap<>((o1,o2)->{
            if(o1.length()>o2.length()){
                return 1;
            }else if(o1.length()<o2.length()){
                return -1;
            }else{
                return 0;
            }
        });
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            treeMap2.put(entry.getKey(), entry.getValue());
        }
        System.out.println(treeMap2);
    }
}
