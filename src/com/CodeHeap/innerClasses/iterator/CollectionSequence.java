package com.CodeHeap.innerClasses.iterator;

import java.util.Collection;
import java.util.Iterator;

public class CollectionSequence implements Collection<Object> {
    private Object[] items;
    private int next = 0;
    public CollectionSequence(int len){
        items = new Object[len];
    }
    public boolean add(Object item){
        if(next<items.length){
            items[next++] = item;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        for (Object item : items) {
            if(item.equals(o)){
                item = null;
                removed = true;
                break;
            }
        }
        return removed;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            boolean found = false;
            for (Object item : items) {
                if(item.equals(o)){
                    found=true;
                    break;
                }
            }
            if(!found) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<?> collection) {
        for (Object o : collection) {
            if(next>=items.length){
                return false;
            }
            items[next++]=o;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean found = false;
        for (int i = 0; i < items.length; i++) {
            for (Object o : collection) {
                if(items[i].equals(o)){
                    items[i]=null;
                    found=true;
                    break;
                }
            }
        }
        return found;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        for (int i = 0; i < items.length; i++) {
            boolean found = false;
            for (Object o : collection) {
                if(items[i].equals(o)){
                    found=true;
                    break;
                }
            }
            if(!found){
                items[i]=null;
            }
        }
        return size()>0;
    }

    @Override
    public void clear() {
        items=null;
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        return size()>0;
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        for (Object item : items) {
            if(item.equals(o)){
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Object>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count<items.length;
            }

            @Override
            public Object next() {
                return items[count++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    class SequenceSelector implements Selector{
        int ptr = 0;

        @Override
        public Object next() {
            return items[ptr++];
        }

        @Override
        public boolean hasNext() {
            return ptr<items.length;
        }
    }

    public Selector getSelector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        CollectionSequence sequence = new CollectionSequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selector iterator = sequence.getSelector();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(Iterator it = sequence.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
