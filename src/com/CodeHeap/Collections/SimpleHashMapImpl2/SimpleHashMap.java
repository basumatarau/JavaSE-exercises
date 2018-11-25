package com.CodeHeap.Collections.SimpleHashMapImpl2;

import java.util.*;

public class SimpleHashMap<K, V> implements Map<K, V> {
    private final int SIZE = 1024;

    @SuppressWarnings("unchecked")
    private MapEntry<K, V>[] buckets = (MapEntry<K, V>[]) new MapEntry[1024];

    SimpleHashMap(Map<K, V> map) {
        putAll(map);
    }

    @Override
    public int size() {
        int result = 0;
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                MapEntry<K, V> entry = bucket;
                result++;
                while (entry.next() != null) {
                    entry = entry.next();
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object o) {

        int index = Math.abs(o.hashCode()) % SIZE;

        if (buckets[index] != null) {
            MapEntry<K, V> entry = buckets[index];
            do {
                if (entry.getKey().equals(o)) {
                    return true;
                }
                entry = entry.next();
            } while (entry.next() != null);
        }
        return false;
    }

    @Override
    public boolean containsValue(Object o) {

        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                MapEntry<K, V> entry = bucket;
                do {
                    if (entry.getValue().equals(o)) {
                        return true;
                    }
                    entry = entry.next();
                } while (entry != null);
            }
        }
        return false;
    }

    @Override
    public V put(K k, V v) {

        int index = Math.abs(k.hashCode()) % SIZE;

        if (buckets[index] != null) {
            MapEntry<K, V> entry = buckets[index];
            do {
                if (entry.getKey().equals(k)) {
                    V oldValue = entry.getValue();
                    entry.setValue(v);
                    return oldValue;
                }
                entry = entry.next();
            } while (entry.next() != null);
        } else {
            buckets[index] = new MapEntry<>(k, v);
            return null;
        }

        MapEntry<K, V> next = buckets[index].next();
        buckets[index] = new MapEntry<>(k, v);
        buckets[index].setNext(next);
        return null;
    }

    @Override
    public V get(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        } else {
            MapEntry<K, V> entry = buckets[index];
            do {
                if (entry.getKey().equals(o)) {
                    return entry.getValue();
                }
                entry = entry.next();
            } while (entry.next() != null);
        }
        return null;
    }

    @Override
    public V remove(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        } else {
            MapEntry<K, V> entry = buckets[index];
            MapEntry<K, V> buff = null;
            while (entry != null) {
                if (entry.getKey().equals(o)) {
                    if (buff == null) {
                        buckets[index] = entry.next();
                    }else{
                        buff.setNext(entry.next());
                    }
                    return entry.getValue();
                }
                buff = entry;
                entry = entry.next();
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
    }

    @Override
    public Collection<V> values() {
        List<V> result = new ArrayList<>();
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                MapEntry<K, V> entry = bucket;
                do {
                    result.add(entry.getValue());
                    entry = entry.next();
                } while (entry != null);
            }
        }
        return result;
    }

    @Override
    public Set<K> keySet() {
        return new KeySet<>(buckets);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new EntrySet<>(buckets);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
