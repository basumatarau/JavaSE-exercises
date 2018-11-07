package com.testProject.innerClasses.iterator;

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int len){
        items = new Object[len];
    }
    public void add(Object item){
        if(next<items.length){
            items[next++] = item;
        }
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
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(i);
        }
        Selector iterator = sequence.getSelector();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
