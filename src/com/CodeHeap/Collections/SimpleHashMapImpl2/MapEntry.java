package com.CodeHeap.Collections.SimpleHashMapImpl2;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V>{
    private K key;
    private V val;
    private MapEntry<K,V> next;

    MapEntry(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public MapEntry<K,V> next(){
        return next;
    }

    public void setNext(MapEntry<K, V> next) {
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return val;
    }

    @Override
    public V setValue(V v) {
        V result = val;
        val = v;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) o;
        return key == null ? entry.getKey() == null : key.equals(entry.getKey())
                && val == null ? entry.getValue() == null : val.equals(entry.getValue());
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (val == null ? 0 : val.hashCode());
    }


}
