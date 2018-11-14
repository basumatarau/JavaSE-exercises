package com.CodeHeap.Generics.DataStructures.LinkedStackAndRandList;

public class LinkedStack<T> {

    private Node<T> top = new Node<>();

    private static class Node<T> {
        T item;
        Node<T> next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return next == null && item == null;
        }
    }

    public void push(T object){
        top = new Node<>(object, top);
    }

    public T pop(){
        Node<T> obj = top;
        if(!top.end()){
            top = top.next;
        }
        return obj.item;
    }
}
