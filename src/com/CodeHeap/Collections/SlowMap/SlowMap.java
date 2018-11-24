package com.CodeHeap.Collections.SlowMap;

import java.util.*;

public class SlowMap<K, V> implements Map<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public SlowMap() {}

    public SlowMap(Map<K, V> map) {
        for (Map.Entry<K, V> kvEntry : map.entrySet()) {
            keys.add(kvEntry.getKey());
            values.add(kvEntry.getValue());
        }
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.size() == 0;
    }

    @Override
    public boolean containsKey(Object o) {
        return keys.contains(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return values.contains(o);
    }

    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    public V put(K key, V value) {
        V oldValue = get(keys);

        if (keys.contains(key)) {
            values.set(keys.indexOf(key), value);
        } else {
            values.add(value);
            keys.add(key);
        }

        return oldValue;
    }

    @Override
    public V remove(Object o) {
        int valIndex = keys.indexOf(o);
        V value = values.get(valIndex);
        values.remove(valIndex);
        keys.remove(o);
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            boolean found = false;
            for (K key : keys) {
                if(key.equals(entry.getKey())){
                    found=true;
                    break;
                }
            }
            if(!found){
                keys.add(entry.getKey());
                values.add(entry.getValue());
            }
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        return new Set<K>(){
            @Override
            public int size() {
                return keys.size();
            }

            @Override
            public boolean isEmpty() {
                return keys.size()==0;
            }

            @Override
            public boolean contains(Object o) {
                return keys.contains(o);
            }

            @Override
            public Iterator<K> iterator() {
                return keys.iterator();
            }

            @Override
            public Object[] toArray() {
                Object[] kk = new Object[keys.size()];
                for (int i = 0; i < keys.size(); i++) {
                    kk[i]=keys.get(i);
                }
                return kk;
            }

            @Override
            public <T> T[] toArray(T[] objects) {

                for (int i = 0; i < objects.length; i++) {
                    objects[i]=(T)keys.get(i);
                }
                return objects;
            }

            @Override
            public boolean add(Object o) {
                for (K key : keys) {
                    if(key.equals(o)){
                        return false;
                    }
                }
                keys.add((K)o);

                return true;
            }

            @Override
            public boolean remove(Object o) {
                for (K key : keys) {
                    if(key.equals(o)){
                        values.remove(keys.indexOf(key));
                        keys.remove(key);
                        return true;
                    }
                }
                return false;
            }

            @Override
            public boolean containsAll(Collection collection) {
                for (Object o : collection) {
                    for (K key : keys) {
                        if(key.equals(o)){
                            return false;
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean addAll(Collection collection) {
                boolean addAny = false;
                for (Object o : collection) {
                    boolean contains = false;
                    for (K key : keys) {
                        if(key.equals(o)){
                            contains = true;
                            break;
                        }
                    }
                    if(!contains){
                        keys.add((K)o);
                        addAny = true;
                    }
                }
                return addAny;
            }

            @Override
            public boolean retainAll(Collection collection) {
                boolean retainedAny = false;
                Iterator<K> iterator = keys.iterator();
                while(iterator.hasNext()) {
                    K kk = iterator.next();
                    boolean found = false;
                    for (Object o : collection) {
                        if(kk.equals(o)){
                            found = true;
                        }
                    }
                    if(!found){
                        values.remove(keys.indexOf(kk));
                        iterator.remove();
                        retainedAny = true;
                    }
                }
                return retainedAny;
            }

            @Override
            public boolean removeAll(Collection collection) {
                boolean removedAny = false;
                Iterator<K> iterator = keys.iterator();
                while(iterator.hasNext()){
                    for (Object o : collection) {
                        if(o.equals(iterator.next())){
                            iterator.remove();
                            removedAny = true;
                            break;
                        }
                    }
                }
                return removedAny;
            }

            @Override
            public void clear() {
                keys.clear();
                values.clear();
            }

            @Override
            public String toString() {
                return keys.toString();
            }
        };
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    private class Entry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V v) {
            this.value = v;
            return v;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) o;
            return (this.key == null ? entry.getKey() == null : this.key.equals(entry.getKey()))
                    && (this.getValue() == null ? entry.getValue() == null : this.value.equals(entry.getValue()));
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }
    }

    private class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private List<K> keys;
        private List<V> values;
        private int counter = -1;

        EntrySet(List<K> keys, List<V> values) {
            this.keys = keys;
            this.values = values;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                @Override
                public boolean hasNext() {
                    return counter < keys.size() - 1;
                }

                @Override
                public Map.Entry<K, V> next() {
                    counter++;
                    return new Entry<>(keys.get(counter), values.get(counter));
                }
            };
        }

        @Override
        public int size() {
            return keys.size();
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        /*
        Set<Map.Entry<K, V>> result = new HashSet<>();
        Iterator<K> keyIter = keys.iterator();
        Iterator<V> valIter = values.iterator();

        while (keyIter.hasNext()) {
            result.add(new Entry<>(keyIter.next(), valIter.next()));
        }
        */

        return new EntrySet<>(keys, values);
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
