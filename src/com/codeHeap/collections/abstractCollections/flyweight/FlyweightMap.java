package com.codeHeap.collections.abstractCollections.flyweight;

import java.util.*;

public class FlyweightMap extends AbstractMap<String, String> {
    private static class Entry implements Map.Entry<String, String> {
        int index;

        Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return Countries.DATA[index][0].equals(o);
        }

        @Override
        public String getKey() {
            return Countries.DATA[index][0];
        }

        @Override
        public String getValue() {
            return Countries.DATA[index][1];
        }

        @Override
        public String setValue(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Countries.DATA[index][0].hashCode();
        }
    }

    static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
        private int size;

        EntrySet(int size) {
            if (size < 0) {
                this.size = 0;
            } else if (size > Countries.DATA.length) {
                this.size = Countries.DATA.length;
            } else {
                this.size = size;
            }
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public Iterator<Map.Entry<String, String>> iterator() {
            return new Iterator<Map.Entry<String, String>>() {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < (size - 1);
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }
            };
        }
    }

    @Override
    public Set<Map.Entry<String, String>> entrySet() {
        return new FlyweightMap.EntrySet(Countries.DATA.length);
    }

    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new FlyweightMap.EntrySet(size);
            }
        };
    }

    public static Map<String, String> capitals() {
        return select(Countries.DATA.length);
    }

    public static Map<String, String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(capitals().keySet());

    static List<String> names() {
        return names;
    }

    static List<String> names(int size) {
        return new ArrayList<>(capitals(size).keySet());
    }

}
