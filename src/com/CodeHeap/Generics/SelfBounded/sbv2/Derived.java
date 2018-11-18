package com.CodeHeap.Generics.SelfBounded.sbv2;

public class Derived extends SelfBounded<Derived> {
    private String content;
    Derived(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    @Override
    public Derived setAndGet(Derived obj) {
        System.out.println("setAndGet(Derived obj);");
        element = obj;
        return element;
    }

    public static void main(String[] args) {

        Derived d2 = new Derived("another test string");
        System.out.println(d2.setAndGet(new Derived("this is a test string")).getContent());
        System.out.println(d2.invoker(d2).getContent());
    }
}
