package com.CodeHeap.ReflectionAPI.NullObject.RobotExample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class NullRobotProxyHandler implements InvocationHandler {

    private String nullName;
    NullRobotProxyHandler(Class<? extends Robot> cl){
        nullName = cl.getSimpleName() + " NullRobot";
    }

    private Robot proxied = new NullRobot();

    private class NullRobot implements Null, Robot{
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return "undefined";
        }

        @Override
        public List<IOperation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return method.invoke(proxied, objects);
    }
}
