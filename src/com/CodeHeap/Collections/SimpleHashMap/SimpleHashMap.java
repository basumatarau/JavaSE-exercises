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
        int result = 0;
        for (List<Entry<K, V>> bucket : buckets) {
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
    public boolean containsKey(Object k) {
        int index = Math.abs(k.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return false;
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(k)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object v) {
        for (List<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(v)) {
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
        V removedVal;
        if (buckets[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
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
            int index = Math.abs(entry.getKey().hashCode()) % SIZE;
            if (buckets[index] == null) {
                buckets[index] = new LinkedList();
            }
            boolean found = false;
            for (Entry<K, V> bucketEntry : buckets[index]) {
                if (bucketEntry.getKey().equals(entry.getKey())) {
                    bucketEntry.setValue(entry.getValue());
                    found = true;
                }
            }
            if (!found) {
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
        if (buckets[index] == null) return false;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(o) &&
                    entry.getValue().equals(o1)) {
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
        return new Set<K>() {
            @Override
            public int size() {
                int result = 0;
                for (List<Entry<K, V>> bucket : buckets) {
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
                for (List<Entry<K, V>> bucket : buckets) {
                    if (bucket != null) {
                        for (Entry<K, V> kvEntry : bucket) {
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
                        for (List<Entry<K, V>> bucket : buckets) {
                            if (bucket != null) {
                                for (Entry<K, V> entry : bucket) {
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
                for (List<Entry<K, V>> bucket : buckets) {
                    if(bucket!=null){
                        for (Entry<K, V> entry : bucket) {
                            result[pos++]=entry.getValue();
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
                if(ts.length<size()){
                    ts=(T[])new Objects[size()];
                }
                int pos = 0;
                for (List<Entry<K, V>> bucket : buckets) {
                    if(bucket!=null){
                        for (Entry<K, V> entry : bucket) {
                            ts[pos++]=(T)entry.getKey();
                        }
                    }
                }
                while(pos<ts.length){
                    ts[pos++]=null;
                }
                return ts;
            }

            @Override
            public boolean add(K k) {
                if(!contains(k)){
                    put(k,null);
                    return true;
                }
                return false;
            }

            @Override
            public boolean remove(Object o) {
                for (List<Entry<K, V>> bucket : buckets) {
                    if(bucket!=null){
                        for (Entry<K, V> entry : bucket) {
                            if(entry.getKey().equals(o)){
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
                    for (List<Entry<K, V>> bucket : buckets) {
                        if(bucket!=null){
                            boolean found = false;
                            for (Entry<K, V> entry : bucket) {
                                if(entry.getKey().equals(o)){
                                    found = true;
                                }
                            }
                            if(!found){
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
                    if(add(k)){
                        addedAny = true;
                    }
                }
                return addedAny;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                boolean changed = false;
                for (List<Entry<K, V>> bucket : buckets) {
                    if(bucket!=null){
                        Iterator<Entry<K, V>> iterator = bucket.iterator();
                        while(iterator.hasNext()){
                            Entry<K, V> next = iterator.next();
                            boolean foundMatch = false;
                            for (Object o : collection) {
                                if(next.getKey().equals(o)){
                                    foundMatch = true;
                                    break;
                                }
                            }
                            if(!foundMatch){
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
                for (List<Entry<K, V>> bucket : buckets) {
                    if(bucket!=null){
                        Iterator<Entry<K, V>> iterator = bucket.iterator();
                        while(iterator.hasNext()){
                            Entry<K, V> next = iterator.next();
                            for (Object o : collection) {
                                if(next.getKey().equals(o)){
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
                for (List<Entry<K, V>> bucket : buckets) {
                    if(bucket!=null){
                        bucket.clear();
                    }
                }
            }

            @Override
            public String toString() {
                StringBuilder result = new StringBuilder("{");
                String delimiter = "";
                for (List<Entry<K, V>> bucket : buckets) {
                    if(bucket!=null){
                        for (Entry<K, V> entry : bucket) {
                            result.append(delimiter).append(entry.getKey());
                            delimiter = ", ";
                        }
                    }
                }
                return result.append("}").toString();
            }
        };
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> result = new ArrayList<>();
        for (List<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> bucketEntry : bucket) {
                    result.add(bucketEntry.getValue());
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";

        for (List<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
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
