package com.CodeHeap.ReflectionAPI.Proxy;

public class SimpleProxy implements Interface {
    private Interface proxied;

    @Override
    public void doSomething() {
        proxied.doSomething();
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("SimpleProxy implementation");
        proxied.doSomethingElse(arg);
    }

    public SimpleProxy(Interface realObj){
        System.out.println("SimpleProxy implementation");
        this.proxied = realObj;
    }

}
