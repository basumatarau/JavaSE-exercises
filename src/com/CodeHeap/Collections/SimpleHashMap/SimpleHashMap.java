package com.CodeHeap.Collections.SimpleHashMap;

import java.util.*;

public class SimpleHashMap<K, V> implements Map<K, V> {
    private final int SIZE = 1024;
    @SuppressWarnings("unchecked")
    private List<Map.Entry<K, V>>[] buckets = new LinkedList[SIZE];

    SimpleHashMap(Map<K, V> map) {
        for (Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public int size() {
        int result=0;
        for (List<Entry<K, V>> bucket : buckets) {
            if(bucket!=null){
                result+=bucket.size();
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean containsKey(Object k) {
        int index = Math.abs(k.hashCode()) % SIZE;
        if(buckets[index]==null){
            return false;
        }

        for (Entry<K, V> entry : buckets[index]) {
            if(entry.getKey().equals(k)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object v) {
        for (List<Entry<K, V>> bucket : buckets) {
            if(bucket!=null){
                for (Entry<K, V> entry : bucket) {
                    if(entry.getValue().equals(v)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(o)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private class MapEntry<Key, Val> implements Map.Entry<Key, Val> {
        private Key key;
        private Val value;

        MapEntry(Key key, Val value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public Val getValue() {
            return value;
        }

        @Override
        public Val setValue(Val v) {
            this.value = v;
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            @SuppressWarnings("unchecked")
            MapEntry entry = (MapEntry) o;
            return (key == null ? entry.getKey() == null : key.equals(entry.getKey())) &&
                    (value == null ? entry.getValue() == null : value.equals(entry.getValue()));
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }
    }


    @Override
    public V put(K k, V v) {
        V oldValue = null;
        int index = Math.abs(k.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        } else {
            System.out.println("collision at index=" + index + " when adding \"" + k + "=" + v + "\" pair");
        }
        boolean found = false;
        MapEntry<K, V> entry = new MapEntry<>(k, v);
        for (Entry<K, V> kvEntry : buckets[index]) {
            System.out.println("collision is being resolved at index#" + index + "for \"" + k + "=" + v + "\" pair");
            if (entry.equals(kvEntry)) {
                oldValue = kvEntry.getValue();
                kvEntry.setValue(v);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(entry);
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        V removedVal = null;
        if(buckets[index]==null){
            return null;
        }
        for (Entry<K, V> entry : buckets[index]) {
            if(entry.getKey().equals(key)){
                removedVal = entry.getValue();
                buckets[index].remove(entry);
                return removedVal;
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            int index = Math.abs(entry.getKey().hashCode())%SIZE;
            if(buckets[index]==null){
                buckets[index] = new LinkedList();
            }
            boolean found = false;
            for (Entry<K, V> bucketEntry : buckets[index]) {
                if(bucketEntry.getKey().equals(entry.getKey())){
                    bucketEntry.setValue(entry.getValue());
                    found = true;
                }
            }
            if(!found){
                buckets[index].add(new MapEntry<>(entry.getKey(), entry.getValue()));
            }
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> result = new HashSet<>();
        for (List<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                result.addAll(bucket);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean remove(Object o, Object o1) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if(buckets[index]==null) return false;
        for (Entry<K, V> entry : buckets[index]) {
            if(entry.getKey().equals(o)&&
                    entry.getValue().equals(o1)){
                buckets[index].remove(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new LinkedList[SIZE];
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";

        for (List<Entry<K, V>> bucket : buckets) {
            if(bucket!=null){
                for (Entry<K, V> kvEntry : bucket) {
                    result.append(delimiter)
                            .append(kvEntry.getKey())
                            .append("=")
                            .append(kvEntry.getValue());
                    delimiter = ", ";
                }
            }
        }
        return result.append("}").toString();
    }
}
