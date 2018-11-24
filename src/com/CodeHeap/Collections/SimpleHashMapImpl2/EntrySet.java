package com.CodeHeap.Collections.SimpleHashMapImpl2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class EntrySet<K, V> implements Set<MapEntry<K, V>> {

    private MapEntry<K, V>[] entries;
    EntrySet(MapEntry<K, V>[] buckets){
        for (MapEntry<K, V> bucket : buckets) {

        }
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean add(MapEntry<K, V> kvMapEntry) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends MapEntry<K, V>> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}