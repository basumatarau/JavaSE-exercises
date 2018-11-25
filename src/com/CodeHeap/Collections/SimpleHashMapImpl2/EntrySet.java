package com.CodeHeap.Collections.SimpleHashMapImpl2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class EntrySet<K, V> implements Set<MapEntry<K, V>> {

    private MapEntry<K, V>[] buckets;

    EntrySet(MapEntry<K, V>[] buckets) {
        this.buckets = buckets;
    }
    public static <K,V> Set<MapEntry<K, V>> getEntrySet(MapEntry<K, V>[] buckets){
        return new EntrySet<>(buckets);
    }

    @Override
    public int size() {
        int result = 0;
        for (MapEntry<K, V> entry : buckets) {
            MapEntry<K, V> next = entry;
            while (next != null) {
                result++;
                next = next.next();
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
            MapEntry<K, V> next = bucket;
            while (next != null) {
                if (next.equals(o)) {
                    return true;
                }
                next = next.next();
            }
        }
        return false;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return new Iterator<MapEntry<K, V>>() {
            int index;
            MapEntry<K, V> ptr;

            @Override
            public boolean hasNext() {
                if (ptr == null) {
                    for (MapEntry<K, V> bucket : buckets) {
                        if (bucket != null) {
                            return true;
                        }
                    }
                } else if (ptr.next() != null) {
                    return true;
                } else if (index < buckets.length - 1) {
                    for (int i = ++index; i < buckets.length; i++) {
                        if (buckets[i] != null) {
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public MapEntry<K, V> next() {
                if (ptr == null) {
                    for (int i = 0; i < buckets.length; i++) {
                        if (buckets[i] != null) {
                            index = i;
                            ptr = buckets[i];
                            break;
                        }
                    }
                    //todo exception should be thrown here
                    // (second consecutive next() call without hasNext() called before)
                } else if (ptr.next() != null) {
                    ptr = ptr.next();
                } else if (index < buckets.length - 1) {
                    for (int i = ++index; i < buckets.length; i++) {
                        if (buckets[i] != null) {
                            ptr = buckets[i];
                        }
                    }
                }
                return ptr;
            }
        };
    }

    @SuppressWarnings("unchecked")
    //template array instantiation
    @Override
    public Object[] toArray() {
        MapEntry<K, V>[] result = (MapEntry<K, V>[]) new MapEntry[size()];
        int pos = 0;
        for (MapEntry<K, V> bucket : buckets) {
            MapEntry<K, V> next = bucket;
            while (next != null) {
                result[pos++] = next;
                next = next.next();
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    //classCastException is thrown if an array of incompatible type <T> is passed
    //indicates programmer`s mistake...
    @Override
    public <T> T[] toArray(T[] ts) {

        if (ts.length < size()) {
            ts = (T[]) new MapEntry[size()];
        }
        int pos = 0;
        for (MapEntry<K, V> bucket : buckets) {
            MapEntry<K, V> next = bucket;
            while (next != null) {
                ts[pos++] = (T) next;
                next = next.next();
            }
        }
        if (pos < size()) {
            for (int i = pos; i < ts.length; i++) {
                ts[pos++] = null;
            }
        }
        return ts;
    }

    @Override
    public boolean add(MapEntry<K, V> kvMapEntry) {
        int index = Math.abs(kvMapEntry.hashCode()) % buckets.length;
        //ugly but should work
        if (buckets[index] != null) {
            MapEntry<K, V> bucket = buckets[index];
            do {
                if (bucket.equals(kvMapEntry)) {
                    return false;
                }
                if (bucket.next() == null) {
                    bucket.setNext(new MapEntry<>(kvMapEntry.getKey(), kvMapEntry.getValue()));
                    break;
                }
                bucket = bucket.next();
            } while (bucket != null);
        } else {
            buckets[index] = new MapEntry<>(kvMapEntry.getKey(), kvMapEntry.getValue());
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()) % buckets.length;
        if (buckets[index] != null) {
            MapEntry<K, V> ptr = buckets[index];
            MapEntry<K, V> prev = null;
            do {
                if (ptr.equals(o)) {
                    if (prev == null) {
                        buckets[index] = ptr.next();
                    } else {
                        prev.setNext(ptr.next());
                    }
                    return true;
                }
                prev = ptr;
                ptr = ptr.next();
            } while (ptr != null);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            for (MapEntry<K, V> bucket : buckets) {
                MapEntry<K, V> next = bucket;
                boolean found = false;
                do {
                    if (next.equals(o)) {
                        found = true;
                        break;
                    }
                    next = next.next();
                } while (next != null);
                if (!found) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends MapEntry<K, V>> collection) {
        boolean addedAny = false;
        for (MapEntry<K, V> entry : collection) {
            if (add(entry)) {
                addedAny = true;
            }
        }
        return addedAny;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean changed = false;
        for (MapEntry<K, V> bucket : buckets) {
            MapEntry<K, V> next = bucket;
            do {
                boolean found = false;

                for (Object o : collection) {
                    if (next.equals(o)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    remove(next);
                    changed = true;
                }

                next = next.next();
            } while (next != null);

        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        for (Object o : collection) {
            for (MapEntry<K, V> bucket : buckets) {
                MapEntry<K, V> next = bucket;
                do {
                    if (next.equals(o)) {
                        remove(next);
                        changed = true;
                    }
                    next = next.next();
                } while (next != null);

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
}