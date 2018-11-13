package com.testProject.ReflectionAPI.TransactionViaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object obj) {
        this.proxied = obj;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        System.out.println(
                "Method \"" + method.getName() +
                "\" invocation on proxied object: " + proxied.toString()
        );

        Object returnedObj=null;
        try {
            returnedObj = method.invoke(proxied, objects);
            System.out.println("Transaction \""+method.getName()+"\" has been committed");
        }catch (RuntimeException e){
            //here goes rollback... this is a wrong implementation of transaction :| ...to be revised
            System.out.println("Transaction \""+method.getName()+"\" has been rolled back");
        }
        return returnedObj;
    }

}
