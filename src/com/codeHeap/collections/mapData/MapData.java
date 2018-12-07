package com.codeHeap.collections.mapData;

import com.codeHeap.arrays.CountingGenerator.Generator;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class MapData<K,V> extends LinkedHashMap<K,V> {
    public MapData(Generator<Pair<K,V>> pairGenerator, int size){
        for (int i = 0; i < size; i++) {
            Pair<K,V> p = pairGenerator.next();
            put(p.key, p.value);
        }
    }
    public MapData(Generator<K> keyGen, Generator<V> valueGenerator, int size){
        for (int i = 0; i < size; i++) {
            put(keyGen.next(), valueGenerator.next());
        }
    }

    public MapData(Generator<K> keyGen, V value, int size){
        for (int i = 0; i < size; i++) {
            put(keyGen.next(), value);
        }
    }

    public MapData(Iterable<K> iterable, Generator<V> valueGenerator){
        Iterator<K> iterator = iterable.iterator();
        while(iterator.hasNext()) {
            put(iterator.next(), valueGenerator.next());
        }
    }

    public MapData(Iterable<K> iterable, V value){
        for (K k : iterable) {
            put(k, value);
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> pairGenerator, int size){
        return new MapData<>(pairGenerator, size);
    }
    public static <K,V> MapData<K,V> map(Generator<K> keyGen, Generator<V> valueGen, int size){
        return new MapData<>(keyGen, valueGen, size);
    }
    public static <K,V> MapData<K,V> map(Generator<K> keyGen, V value, int size){
        return new MapData<>(keyGen, value, size);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> iterable, Generator<V> valueGen){
        return new MapData<>(iterable, valueGen);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> iterable, V value){
        return new MapData<>(iterable, value);
    }

}
