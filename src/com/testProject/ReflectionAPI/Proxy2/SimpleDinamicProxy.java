package com.testProject.ReflectionAPI.Proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SimpleDinamicProxy {
    public static void consumer(Interface object){
        object.doSomething();
        object.doSomethingElse("tada!");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);


        InvocationHandler handler = new DynamicProxyHandler(realObject);
        Class<?> proxyClass = Proxy.getProxyClass(Interface.class.getClassLoader(), Interface.class);
        Interface proxyObj;
        try {
             proxyObj = (Interface) proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        consumer(proxyObj);
    }
}
