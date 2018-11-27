package com.CodeHeap.Collections.perfomanceTests;

import java.util.*;

public class SlowMap<K extends Comparable<K>, V> implements Map<K, V> {
    private List<Map.Entry<K,V>> entries = new ArrayList<>();

    public SlowMap() {}

    public SlowMap(Map<K, V> map) {
        for (Map.Entry<K, V> kvEntry : map.entrySet()) {
            put(kvEntry.getKey(), kvEntry.getValue());
        }
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.size() == 0;
    }

    @Override
    public boolean containsKey(Object o) {
        boolean keyFound = false;
        for (Map.Entry<K, V> entry : entries) {
            if(entry.getKey().equals(o)){
                keyFound = true;
                break;
            }
        }
        return keyFound;
    }

    @Override
    public boolean containsValue(Object o) {
        boolean valeuFound = false;
        for (Map.Entry<K, V> entry : entries) {
            if(entry.getValue().equals(o)){
                valeuFound = true;
                break;
            }
        }
        return valeuFound;
    }

    public V get(Object key) {
        V vaule = null;
        MapEntry<K,V> dummy = new MapEntry<>((K)key, null);

        int i = Collections.binarySearch(entries, dummy, (o1, o2) -> {
            int comparison = o1.getKey().compareTo(o2.getKey());
            if (comparison != 0) {
                return comparison;
            }
            return 0;
        });
        if(i>=0){
            vaule = entries.get(i).getValue();
        }

        return vaule;
    }

    public V put(K key, V value) {
        V oldValue = null;
        MapEntry<K,V> entry = new MapEntry<>(key,value);
        for (Map.Entry<K, V> kvEntry : entries) {
            if(kvEntry.equals(entry)){
                oldValue = kvEntry.getValue();
                kvEntry.setValue(value);
                break;
            }
        }
        if(oldValue==null){
            entries.add(entry);
            entries.sort((e1,e2)->{
                int comparison = e1.getKey().compareTo(e2.getKey());
                if(comparison!=0){
                    return comparison;
                }
                return 0;
            });
        }
        return oldValue;
    }

    @Override
    public V remove(Object o) {
        V removedValue = null;
        for (Map.Entry<K, V> entry : entries) {
            if(entry.getKey().equals(o)){
                removedValue = entry.getValue();
                entries.remove(entry);
                break;
            }
        }
        return removedValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            boolean found = false;
            for (Map.Entry<K, V> kvEntry : entries) {
                if(kvEntry.equals(entry)){
                    found = true;
                    break;
                }
            }
            if(!found){
                entries.add(new MapEntry<>(entry.getKey(), entry.getValue()));
            }
        }
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public Set<K> keySet() {
        return new Set<K>(){
            @Override
            public int size() {
                return entries.size();
            }

            @Override
            public boolean isEmpty() {
                return entries.size()==0;
            }

            @Override
            public boolean contains(Object o) {
                for (Entry<K, V> entry : entries) {
                    if(entry.getKey().equals(o)){
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>() {
                    MapEntry<K,V> next = null;
                    Iterator<Entry<K, V>> iterator;
                    {
                         iterator = entries.iterator();
                    }

                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public K next() {
                        return iterator.next().getKey();
                    }
                };
            }

            @Override
            public Object[] toArray() {
                Object[] kk = new Object[entries.size()];
                for (int i = 0; i < entries.size(); i++) {
                    kk[i]= entries.get(i).getKey();
                }
                return kk;
            }

            @Override
            public <T> T[] toArray(T[] objects) {

                for (int i = 0; i < objects.length; i++) {
                    objects[i]=(T) entries.get(i).getKey();
                }
                return objects;
            }

            @Override
            public boolean add(K k) {
                boolean found = false;
                for (Entry<K, V> entry : entries) {
                    if(entry.getKey().equals(k)){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    entries.add(new MapEntry<>(k, null));
                }
                return found;
            }


            @Override
            public boolean remove(Object o) {
                boolean removed = false;
                for (Entry<K, V> entry : entries) {
                    if(entry.getKey().equals(o)){
                        entries.remove(entry);
                        removed = true;
                        break;
                    }
                }
                return removed;
            }

            @Override
            public boolean containsAll(Collection collection) {
                for (Object o : collection) {
                    boolean found = false;
                    for (Entry<K, V> entry : entries) {
                        if(entry.getKey().equals(o)){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        return false;
                    }
                }
                return true;
            }

            @Override
            public boolean addAll(Collection collection) {
                boolean addAny = false;
                for (Object o : collection) {
                    boolean contains = false;
                    for (Entry<K, V> entry : entries) {
                        if(entry.getKey().equals(o)){
                            contains = true;
                            break;
                        }
                    }
                    if(!contains){
                        entries.add(new MapEntry<>((K)o, null));
                        addAny = true;
                    }
                }
                return addAny;
            }

            @Override
            public boolean retainAll(Collection collection) {
                boolean changed = false;
                Iterator<Entry<K, V>> it = entries.iterator();
                while(it.hasNext()){
                    Entry<K, V> next = it.next();
                    boolean found = false;
                    for (Object o : collection) {
                        if(next.getKey().equals(o)){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        it.remove();
                        changed = true;
                    }
                }
                return changed;
            }

            @Override
            public boolean removeAll(Collection collection) {
                boolean removedAny = false;
                Iterator<Entry<K, V>> it = entries.iterator();
                while(it.hasNext()){
                    Entry<K, V> next = it.next();
                    for (Object o : collection) {
                        if(next.getKey().equals(o)){
                            it.remove();
                            removedAny = true;
                            break;
                        }
                    }
                }
                return removedAny;
            }

            @Override
            public void clear() {
                entries.clear();
            }

            @Override
            public String toString() {
                return entries.toString();
            }
        };
    }

    @Override
    public Collection<V> values() {
        List<V> result = new ArrayList<>();
        for (Entry<K, V> entry : entries) {
            result.add(entry.getValue());
        }
        return result;
    }

    private class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private List<Map.Entry<K,V>> entries;
        private int counter = -1;

        EntrySet(List<Map.Entry<K,V>> entries) {
            this.entries = entries;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private int counter = -1;
                @Override
                public boolean hasNext() {
                    return counter < entries.size() - 1;
                }

                @Override
                public Map.Entry<K, V> next() {
                    return entries.get(++counter);
                }
            };
        }

        @Override
        public int size() {
            return entries.size();
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet<>(entries);
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
