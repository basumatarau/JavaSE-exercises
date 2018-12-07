package com.codeHeap.generics.decorator.v3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MixinProxy implements InvocationHandler {
    private Map<String, Object> delegatedByMethod;

    private MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatedByMethod = new HashMap<>();

        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.getSecond().getMethods()) {
                String methodName = method.getName();
                if (!delegatedByMethod.containsKey(methodName)) {
                    delegatedByMethod.put(methodName, pair.getFirst());
                }
            }
        }
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object delegate = delegatedByMethod.get(method.getName());

        return method.invoke(delegate, objects);
    }

    public static Object newInstance(TwoTuple<Object, Class<?>>... pairs){

        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = pairs[i].getSecond();
        }
        ClassLoader classLoader = pairs[0].getFirst().getClass().getClassLoader();

        return Proxy.newProxyInstance(classLoader, interfaces, new MixinProxy(pairs));
    }

}
