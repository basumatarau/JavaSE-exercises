package com.CodeHeap.Collections.SimpleHashMapImpl2;

import java.util.*;

public class KeySet<K, V> implements Set<K> {
    private MapEntry<K, V>[] buckets;

    KeySet(MapEntry<K, V>[] buckets) {
        this.buckets = buckets;
    }

    @Override
    public int size() {
        int result = 0;
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                MapEntry<K, V> next = bucket;
                do {
                    next = next.next();
                    result++;
                } while (next != null);
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
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
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int counter = -1;

            @Override
            public boolean hasNext() {
                return counter < size() - 1;
            }

            @Override
            public K next() {
                int pos = 0;
                counter++;
                for (MapEntry<K, V> bucket : buckets) {
                    if (bucket != null) {
                        MapEntry<K, V> entry = bucket;
                        do {
                            if (counter == pos++) {
                                return entry.getKey();
                            }
                            entry = entry.next();
                        } while (entry != null);
                    }
                }
                //something smart has to be done with the return statement (it looks stupid)
                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        int pos = 0;
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                MapEntry<K, V> entry = bucket;
                do {
                    result[pos++] = entry.getValue();
                    entry = entry.next();
                } while (entry != null);
            }
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    //throws ArrayStoreException when wrong type is attempted to be stored in array of objects of type <T>
    //indicates programmer's mistake
    public <T> T[] toArray(T[] ts) {
        if (ts.length < size()) {
            ts = (T[]) new Objects[size()];
        }
        int pos = 0;
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                MapEntry<K, V> entry = bucket;
                do {
                    ts[pos++] = (T) entry.getValue();
                    entry = entry.next();
                } while (entry != null);
            }
        }
        while (pos < ts.length) {
            ts[pos++] = null;
        }
        return ts;
    }

    @Override
    public boolean add(K k) {
        int index = Math.abs(k.hashCode()) % buckets.length;
        if (buckets[index] == null) {
            buckets[index] = new MapEntry<>(k, null);
            return true;
        }
        for (MapEntry<K, V> entry : buckets) {
            if (entry.getKey().equals(k)) {
                return false;
            }
        }

        MapEntry<K, V> next = buckets[index];
        while (next.next() != null) {
            next = next.next();
        }
        next.setNext(new MapEntry<>(k, null));
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()) % buckets.length;
        if (buckets[index] == null) {
            return false;
        } else {
            MapEntry<K, V> entry = buckets[index];
            MapEntry<K, V> buff = null;
            while (entry != null) {
                if (entry.getKey().equals(o)) {
                    if (buff == null) {
                        buckets[index] = entry.next();
                    } else {
                        buff.setNext(entry.next());
                    }
                    return true;
                }
                buff = entry;
                entry = entry.next();
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            for (MapEntry<K, V> bucket : buckets) {
                if (bucket != null) {
                    boolean found = false;
                    MapEntry<K, V> entry = bucket;
                    while (entry != null) {
                        if (entry.getKey().equals(o)) {
                            found = true;
                            break;
                        }
                        entry = entry.next();
                    }
                    if (!found) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends K> collection) {
        boolean addedAny = false;
        for (K k : collection) {
            if (add(k)) {
                addedAny = true;
            }
        }
        return addedAny;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean changed = false;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {

                MapEntry<K, V> entry = buckets[i];
                MapEntry<K, V> prev = null;

                while (entry != null) {
                    boolean foundMatch = false;
                    for (Object o : collection) {
                        if (entry.getKey().equals(o)) {
                            foundMatch = true;
                            break;
                        }
                    }
                    if (!foundMatch) {
                        if (prev == null) {
                            buckets[i] = entry.next();
                        } else {
                            prev.setNext(entry.next());
                        }
                        changed = true;
                    }
                    prev = entry;
                    entry = entry.next();
                }
            }
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {

                MapEntry<K, V> entry = buckets[i];
                MapEntry<K, V> prev = null;

                while (entry != null) {

                    for (Object o : collection) {
                        if (entry.getKey().equals(o)) {
                            if (prev == null) {
                                buckets[i] = entry.next();
                            } else {
                                prev.setNext(entry.next());
                            }
                            changed = true;
                            break;
                        }
                    }
                    prev = entry;
                    entry = entry.next();
                }
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                MapEntry<K, V> entry = bucket;
                while (entry != null) {
                    result.append(delimiter)
                            .append(entry.getKey());
                    entry = entry.next();
                    delimiter = ", ";
                }
            }
        }
        return result.append("}").toString();
    }
}