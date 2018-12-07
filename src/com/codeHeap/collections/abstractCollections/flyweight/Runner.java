package com.codeHeap.collections.abstractCollections.flyweight;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        System.out.println(FlyweightMap.select(10));
        System.out.println(new HashMap<>(FlyweightMap.capitals(5)));
        System.out.println(new LinkedHashMap<>(FlyweightMap.capitals(5)));
        System.out.println(new TreeMap<>(FlyweightMap.capitals(5)));
        System.out.println(new Hashtable<>(FlyweightMap.capitals(5)));
        System.out.println(new HashSet<>(FlyweightMap.names(5)));
        System.out.println(new LinkedHashSet<>(FlyweightMap.names(5)));
        System.out.println(new TreeSet<>(FlyweightMap.names(5)));
        System.out.println(new ArrayList<>(FlyweightMap.names(5)));
        System.out.println(new LinkedList<>(FlyweightMap.names(5)));
        System.out.println(new FlyweightMap());
    }
}
