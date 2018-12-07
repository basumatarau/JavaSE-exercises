package com.codeHeap.collections.simpleHashMap;

import java.util.*;

public class EntrySet<K, V> implements Set<K> {
    private List<Map.Entry<K, V>>[] buckets;

    EntrySet(List<Map.Entry<K, V>>[] buckets) {
        this.buckets = buckets;
    }

    @Override
    public int size() {
        int result = 0;
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                result += bucket.size();
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
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Map.Entry<K, V> kvEntry : bucket) {
                    if (kvEntry.getKey().equals(o)) {
                        return true;
                    }
                }
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
                counter++;
                int pos = 0;
                for (List<Map.Entry<K, V>> bucket : buckets) {
                    if (bucket != null) {
                        for (Map.Entry<K, V> entry : bucket) {
                            if (pos++ == counter) {
                                return entry.getKey();
                            }
                        }
                    }
                }
                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size()];
        int pos = 0;
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Map.Entry<K, V> entry : bucket) {
                    result[pos++] = entry.getValue();
                }
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
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Map.Entry<K, V> entry : bucket) {
                    ts[pos++] = (T) entry.getKey();
                }
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
            buckets[index] = new LinkedList<>();
        }
        for (Map.Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(k)) {
                return false;
            }
        }
        buckets[index].add(new MapEntry<>(k, null));
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Map.Entry<K, V> entry : bucket) {
                    if (entry.getKey().equals(o)) {
                        bucket.remove(entry);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            for (List<Map.Entry<K, V>> bucket : buckets) {
                if (bucket != null) {
                    boolean found = false;
                    for (Map.Entry<K, V> entry : bucket) {
                        if (entry.getKey().equals(o)) {
                            found = true;
                        }
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
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                Iterator<Map.Entry<K, V>> iterator = bucket.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<K, V> next = iterator.next();
                    boolean foundMatch = false;
                    for (Object o : collection) {
                        if (next.getKey().equals(o)) {
                            foundMatch = true;
                            break;
                        }
                    }
                    if (!foundMatch) {
                        iterator.remove();
                        changed = true;
                    }
                }
            }
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                Iterator<Map.Entry<K, V>> iterator = bucket.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<K, V> next = iterator.next();
                    for (Object o : collection) {
                        if (next.getKey().equals(o)) {
                            iterator.remove();
                            changed = true;
                            break;
                        }
                    }
                }
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                bucket.clear();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (List<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Map.Entry<K, V> entry : bucket) {
                    result.append(delimiter).append(entry.getKey());
                    delimiter = ", ";
                }
            }
        }
        return result.append("}").toString();
    }
}