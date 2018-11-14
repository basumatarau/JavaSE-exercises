package com.CodeHeap.ReflectionAPI.Proxy;

public class SimpleProxyDemo {
    static void consumer(Interface object){
        object.doSomething();
        object.doSomethingElse("here goes to test string...");
    }
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        Interface proxyObj = new SimpleProxy(realObject);
        consumer(proxyObj);
    }
}
