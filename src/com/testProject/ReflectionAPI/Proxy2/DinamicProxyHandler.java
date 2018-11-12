package com.testProject.ReflectionAPI.Proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DinamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DinamicProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println(
                o.getClass().getSimpleName()+"-proxy: "+o.getClass().getSimpleName()+
                    ", method: "+ method.toString() + ", args: " + objects
                );
        if(objects!=null){
            for (Object object : objects) {
                System.out.println(" "+ object);
            }
        }
        return method.invoke(proxied, objects);
    }

}
