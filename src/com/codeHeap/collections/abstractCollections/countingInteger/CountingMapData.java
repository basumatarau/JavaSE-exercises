package com.codeHeap.collections.abstractCollections.countingInteger;

import java.util.*;

public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars = "QWERTYUIOPASDFGHJKLZXCVBNM".split("");
    public CountingMapData(int size){
        this.size = size;
    }

    private static class Entry implements Map.Entry<Integer, String>{
        Entry(int index){
            this.index = index;
        }
        private int index;

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index%chars.length]+(index/chars.length);
        }

        @Override
        public String setValue(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return this.getKey().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Entry) && this.getKey().equals(((Entry)o).getKey());
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>>{
        private int size;
        EntrySet(int size){
            this.size = size;
        }
        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {

                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index<size;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    entry.index=entry.index+1;
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return new EntrySet(chars.length);
    }

    public static Map<Integer, String> select(final int size){
        return new CountingMapData(0){
            @Override
            public Set<Map.Entry<Integer, String>> entrySet() {
                return new CountingMapData.EntrySet(size);
            }
        };
    }

    public static void main(String[] args) {
        CountingMapData cmd = new CountingMapData(5);
        System.out.println(cmd);
        System.out.println(CountingMapData.select(5));
    }
}
